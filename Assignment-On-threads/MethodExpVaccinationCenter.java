//One Thread Program
import java.util.Date;
public class MethodExpVaccinationCenter{
	public static void main(String[] args) throws Exception{
		VaccinationCenter vc=new VaccinationCenter();
		Thread t=Thread.currentThread();
		t.setName("shoiab");
		System.out.println(new Date());
		System.out.println("Before comming to class....");
		Thread kala=new Thread(new JobToKala(vc)::run,"kala"); //Creating thread for JobTokoala and Set name 
		kala.start();
		// vc.getToken();
		System.out.println("Take class.....for 7-9 Golden Batch...."+new Date());
	}	
}
class JobToKala{
	VaccinationCenter vc;
	public JobToKala(VaccinationCenter vc) {
		this.vc=vc;
	}
	public void run() {
		System. out.println("The job given to kala is executed from this method...");
		try{
			vc.getToken();
		}catch(Exception e) {
			e.printStackTrace();
		}
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