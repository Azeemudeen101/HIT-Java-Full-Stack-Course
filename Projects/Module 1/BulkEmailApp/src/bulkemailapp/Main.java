package bulkemailapp;

/* Main Class:
 * 		Call sendEmail method from SendBulkMail Class
 * 		& Pass the method of ListOfEmails Class which return a Collection of email's.
*/
public class Main {
 
	public static void main(String[] args) {
		SendBulkMail sendBulkMail=new SendBulkMail();
		ListOfEmails listOfEmails=new ListOfEmails();
		
		sendBulkMail.sendEmail(listOfEmails.emailSet());
	}
}
