import java.util.Date;
public class LamdaVaccinationCenter{
	public static void main(String[] args) throws Exception{
		VaccinationCenter vc=new VaccinationCenter();
		Thread t=Thread.currentThread();
		t.setName("Shoiab");
		System.out.println(new Date());
		System.out.println("Before comming to class....");
		new Thread(()->{
			System.out.println("The job given to kala is executed from this method...");
			try{
				vc.getToken();
			}catch(Exception e) {
				e.printStackTrace();
			}
		},"Kala").start(); //Creating thread using Lamda expression
		System.out.println("Take class.....for 7-9 Golden Batch...."+new Date());
	}
}

class VaccinationCenter {
	public void getToken() throws Exception{
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+"...standing in queue for token....");
		Thread.sleep(5000);
		System.out.println("token received..."+new Date());
	}
}