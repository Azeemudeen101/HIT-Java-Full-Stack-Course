public class LambdaCounsellingHall {
	public static void main(String[] args) {
		CounsellingHall university=new CounsellingHall();
		
		new Thread(()->{
			university.table1();university.table2();
		},"Imran").start();

		new Thread(()->{
			university.water();
		},"Taqi").start();

	}
}

class CounsellingHall{
	synchronized public void table1() {
		System.out.println("entered table1...:"+Thread.currentThread().getName());
		try {Thread.sleep(3000);}catch(Exception e) {}
	}
	synchronized public void table2() {
		System.out.println("entered table2...:"+Thread.currentThread().getName());
	}
	public void water() {
		System.out.println("entered water area to drink water....:"+Thread.currentThread().getName());
	}
}