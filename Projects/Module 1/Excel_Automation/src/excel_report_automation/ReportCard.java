package excel_report_automation;

public class ReportCard {
	
	String rollNo,email;
	int mark1,mark2,mark3,mark4,mark5;
	public ReportCard(String rollNo,String email, int mark1, int mark2, int mark3, int mark4, int mark5) {
		this.rollNo=rollNo;
		this.email = email;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.mark4 = mark4;
		this.mark5 = mark5;
	}
	public String getRollNo() {
		return rollNo;
	}
	public String getEmail() {
		return email;
	}
	public int getMark1() {
		return mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public int getMark4() {
		return mark4;
	}
	public int getMark5() {
		return mark5;
	}
	
}
	