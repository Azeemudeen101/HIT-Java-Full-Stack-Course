import java.util.Scanner;
public class LambdaReservation {
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		int a;
		t.setName("Muhaimeen");
		System.out.println("Reservation counter starting working...Officer:"+t.getName());
		
		ReservationCounter central=new ReservationCounter();

		Scanner scan=new Scanner(System.in);

		System.out.print("Enter Amount for imran:");
		int amt1=scan.nextInt();
		System.out.print("Enter Amount for taqi:");
		int amt2=scan.nextInt();
		
		new Thread(()-> {
			synchronized(central){
				central.bookTicket(amt1);
				central.giveChange();
			}
		},"imran").start();
		new Thread(()-> {
			synchronized(central){
				central.bookTicket(amt2);
				central.giveChange();
			}
		},"taqi").start();
		
	}
}


class ReservationCounter{
	int amt;
	public void bookTicket(int amt) {
		Thread t=Thread.currentThread();
		this.amt=amt;
		String name=t.getName();
		System.out.println(name+" has come to book the ticket...");
		System.out.println(name+" brought...:"+amt);
	}
	
	public void giveChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change given to...:"+name);
		System.out.println(name+" takes...:"+(amt-100));
	}
}