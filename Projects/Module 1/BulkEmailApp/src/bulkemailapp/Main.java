package bulkmailapp;

public class Main {

	public static void main(String[] args) {
		SendEmail sendEmail=new SendEmail();
		ListOfEmails list=new ListOfEmails();
		sendEmail.processList(list.getEmailList());
	}
}
