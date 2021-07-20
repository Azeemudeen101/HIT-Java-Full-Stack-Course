package bulkmailapp;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* CLASS : SendMail
 * METHODS :
 * 	getSession() - get Session properties
 *	makeConnection() - Connect to Server Once using Constructor
 *	processList() - Iterate through the Set & Send name and email to compose() in a Loop
 *	compose() - Create Message and Send to send()
 *	send() - Send prepared Email to Server
 */
public class SendEmail {
	private Transport transport;

	private String username="useremail"; 
	private String password="password";

	public SendEmail() {
		System.out.println("[---------- BULK-EMAIL APPLICATION ----------]");
		System.out.print("Connection Status: ");
		makeConnection();
		System.out.println("[SUCCESSFUL]");
	}

	private Session getSession() {
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session =Session.getInstance(properties);
		return session;
	}
	public void makeConnection(){
		try {
			transport=getSession().getTransport("smtp");
			transport.connect(username, password);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.exit(0);
		}
	}

	public void processList(Set<String> emailList) {
		Iterator<String> iter=emailList.iterator();
		while(iter.hasNext()) {
			String recipientEmail=iter.next();
			String[] recipientName=recipientEmail.split("@");
			compose(recipientName[0],recipientEmail);
		}
	}
	public void compose(String recipientName, String recipientEmail) {
		Message message=new MimeMessage(getSession());
		try {
			message.setFrom(new InternetAddress(username));  //From address
			message.setRecipient(RecipientType.TO, new InternetAddress(recipientEmail,recipientName));  //To Address
			message.setSubject("Github Invite");
			String htmlText="<h2>Dear "+recipientName+",</h2>"
			+ "<i>Greetings to you..</i> </br></br>"
			+ "Welcome to my Github Account..</br></br>"
			+ "Visit Profile with URL: https://github.com/Azeemudeen101";
			message.setContent(htmlText, "text/html");

		}catch(MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.print("[Composed Email for "+recipientEmail+"]");
		send(message);
	}
	public void send(Message message) {
		try {
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println(": Sent Successfully");
		}
		catch (MessagingException e) {e.printStackTrace();}
	}
}