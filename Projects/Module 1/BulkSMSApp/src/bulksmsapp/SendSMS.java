package bulksmsapp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class SendSMS {
	int messageSent;
	int messageFailed;
	int invalidNumbers;
	
	//-------- Process Name and Numbers from HashMap ---------- 
	public void processSMSList(HashMap<String,String> smsList) {
		System.out.println("[========= BULK SMS APPLICATION ==========]");
		Iterator<Entry<String, String>> smsListIter=smsList.entrySet().iterator();
		String name,number;
		while(smsListIter.hasNext()) {
			Map.Entry<String,String> smsEntries=(Map.Entry<String,String>)smsListIter.next();
			name=smsEntries.getKey();
			number=smsEntries.getValue();
			if(ValidateNumber(number)) {
				prepareMessage(name, number);
			}
		}
		
		System.out.println("Invalid Numbers: "+invalidNumbers);
		System.out.println("Successfull Sent: "+messageSent+" SMS");
		System.out.println("Failed to Sent: "+messageFailed+" SMS");
	}
	
	//------- Validate Mobile Numbers -------
	private boolean ValidateNumber(String number) {
		boolean isValid=false;
		if(number.length()==10) {
			isValid=true;
		}
		else {
			invalidNumbers++;
		}
		return isValid;
	}
	
	//-------- Create Message -------- 
	public void prepareMessage(String name,String number) {
		System.out.print("Sending SMS to Name:"+name+" Number:"+number+" Delivery-Status:" );
		try {
			String messageBody="Hello "+name+",\nWelcome to Github.\n I'm inviting you to Visit profile : https://www.github.com/Azeemudeen101";
			String apikey= "<---YOUR API_KEY--->";
			
			HttpResponse<String> response_JSON = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
					.header("authorization", apikey)
					.header("Content-Type", "application/x-www-form-urlencoded")
					.body("sender_id=TXTIND&message="+messageBody+"&route=v3&numbers="+number)
					.asString();
			
			boolean isSuccess=response_JSON.getBody().contains("\"return\":true");
			if(isSuccess) {
				System.out.println("[SUCCESSFUL]");
				messageSent++;
			}else {
				System.out.println("[FAILED] Cause: UNKNOWN ERROR");
			}
		} catch (Exception e) {
			System.out.println("[FAILED] Cause:"+ e.getLocalizedMessage());
			messageFailed++;
		}
	}
}
