package bulkemailapp;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/* Session Class: 
 * 		Have All the Properties and Authentication information
 * Methods: 
 * 	getSessionDetails - return session
 * 	getUserEmail - return userEmail 
*/
public class SessionDetails {
	//Username and Password
	private String userEmail="YourEmailAccount@gmail.com"; //<----- Sender Email MUST
	private String password="YourPassw*rd";  //<------- Sender Password MUST

	public String getUserEmail() {
		return userEmail;
	}	
	public Session getSession() {
		System.out.println("[---BulkEmailApp Session Started @"+new Date()+"---]");
		
		//Setup Session Properties
		Properties sessionProp=new Properties();
		sessionProp.put("mail.smtp.auth", "true");
		sessionProp.put("mail.smtp.starttls.enable", "true");
		sessionProp.put("mail.smtp.host", "smtp.gmail.com");
		sessionProp.put("mail.smtp.port", "587");
		
		//Start Session 
		Session session=Session.getInstance(sessionProp, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userEmail,password);
			}});
		return session;
	}

}
