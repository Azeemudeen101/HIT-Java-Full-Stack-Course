package excel_report_automation;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* CLASS : SendMail
 * METHODS :
 * 	getSession() - get Session properties
 *	makeConnection() - Connect to Server Once using Constructor
 *	compose() - Create Message and Send to send()
 *	send() - Send prepared Email to Server
 */
public class SendEmail {
	public Transport transport;

	private String username="useremail";
	private String password="password";

	public SendEmail() {
		System.out.print("Email Server Connection Status: ");
		makeConnection();
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
			System.out.println("[SUCCESSFUL]");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void compose(String recipientRollNo, String recipientEmail, String filepath) {
		Message message=new MimeMessage(getSession());
		try {
			message.setFrom(new InternetAddress(username));  //From address
			message.setRecipient(RecipientType.TO, new InternetAddress(recipientEmail,recipientRollNo));  //To Address
			message.setSubject("EXAM MARKLIST");
			String htmlText="<h2>ROLL NO :"+recipientRollNo+" MARKLIST,</h2>"
			+ "<i>Thanks for Attending the Exam..</i> <br></br>"
			+ "You can Download your Marklist from the Attachment below.<br></br>";
			BodyPart messageBodyPart=new MimeBodyPart();
			messageBodyPart.setContent(htmlText, "text/html");
			Multipart multipart =new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart=new MimeBodyPart();
			DataSource source=new FileDataSource(filepath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(recipientRollNo+".xlsx");
			multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);
			
			if(transport == null) {
				transport = getSession().getTransport("smtp");              
			}
			if(!transport.isConnected()) { 
				transport.connect(username, password);
			}
			System.out.print(" [Sending Email to "+recipientEmail+"..]");
		}catch(MessagingException | UnsupportedEncodingException e) {
			System.out.print(" [Email Error]");
		}
		send(message);
	}
	public void send(Message message) {
		try {
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println(": Sent Successfully");
		}
		catch (Exception e) {System.out.println(": Failed to Send");}
	}
}