package bulkemailapp;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* ComposeEmail Class: 
 * Methods:  sendMail-  Get the Session from SessionDetails
 * 			Get Email & Name from SendBulkMail
 * 			Use it to create Message Object and Send the Email 
*/
public class ComposeEmail {
	
	SessionDetails sessionObj=new SessionDetails();
	Session session=sessionObj.getSession();
	
	public void sendMail(String recipientName,String recipientEmail) {
		String userEmail=sessionObj.getUserEmail();
		//Creating Message
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userEmail));  //From address
			message.setRecipient(RecipientType.TO, new InternetAddress(recipientEmail,recipientName));  //To Address
			message.setSubject("HIT-JAVA");
			String htmlText="<h2>Dear "+recipientName+",</h2>"
					+ "<i>Greetings to you..</i> <br></br>"
					+ "Welcome to my Github Account..<br></br>"
					+ "Visit Profile with URL: https://github.com/Azeemudeen101";
			message.setContent(htmlText, "text/html"); // Email Body	

			//Sending Message
			System.out.println("Sending Email to "+recipientEmail+" at "+new Date());
			Transport.send(message);
			System.out.println("Email Sent Successfully to "+recipientEmail);
		} catch ( MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (Exception e) {e.printStackTrace();}
		
	}
}
