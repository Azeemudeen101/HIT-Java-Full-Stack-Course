package pdf_ecertificate;

public class Main {

	public static void main(String[] args) {
		StudentDetails sDetails =new StudentDetails();
		CreateCertificate createCertificate=new CreateCertificate();
		createCertificate.generate(sDetails.getNameList(),"FullStack JAVA Developer", "31/01/2021");
	}
}
