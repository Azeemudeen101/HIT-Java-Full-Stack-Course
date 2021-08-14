package bulksmsapp;

public class Main {

	public static void main(String[] args) {
		SmsList smsList=new SmsList();
	    SendSMS sendSms=new SendSMS();
	    sendSms.processSMSList(smsList.getList());
	}
}
