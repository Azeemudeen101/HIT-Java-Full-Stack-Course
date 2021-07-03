public class MethodExpCounselling {
	public static void main(String[] args) {
		CounsellingHall university=new CounsellingHall();
		CounsellingJob cj=new CounsellingJob(university);
		Thread imran=new Thread(cj::enterHall,"imran");
		Thread secondtaqi=new Thread(cj::enterHall,"secondtaqi");
		imran.start();
		secondtaqi.start();
	}
}
class CounsellingJob{
	CounsellingHall university;
	public CounsellingJob(CounsellingHall university) {
		this.university=university;
	}

	public void enterHall() {
		if(Thread.currentThread().getName().equals("imran")) {
			university.table1();university.table2();
		}
		else if(Thread.currentThread().getName().equals("secondtaqi")){
			university.water();
		}
	}
}
class CounsellingHall{
	synchronized public void table1() {
		System.out.println("entered table1...:"+Thread.currentThread().getName());
		try {Thread.sleep(5000);}catch(Exception e) {}
	}
	synchronized public void table2() {
		System.out.println("entered table2...:"+Thread.currentThread().getName());
	}
	public void water() {
		System.out.println("entered water area to drink water....:"+Thread.currentThread().getName());
	}
}