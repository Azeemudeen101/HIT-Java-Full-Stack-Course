public class MethodExpReservation{
	public static void main(String[] args) throws Exception{
		Thread t=Thread.currentThread();
		t.setName("muhaimeen");
		System.out.println("Reservation counter starting working..."+t.getName());
		
		ReservationCounter central=new ReservationCounter();
		
		Thread imran=new Thread(new BookingJob(central,1000)::booking,"imran");
		Thread taqi=new Thread(new BookingJob(central,500)::booking,"taqi");
		
		imran.start();
		taqi.start();
	}
}
class BookingJob{
	ReservationCounter central;
	int amt;
	public BookingJob(ReservationCounter central,int amt) {
		this.central=central;
		this.amt=amt;
	}
	public void booking() {
		synchronized(central){
			central.bookTicket(amt);
			central.giveChange();
		}
	}
}
class ReservationCounter{
	int amt;
	public void bookTicket(int amt) {
		Thread t=Thread.currentThread();
		this.amt=amt;
		String name=t.getName();
		System.out.println(name+" has come to book the ticket...");
		System.out.println(name+" brought ticket for...:"+amt);
	}
	
	public void giveChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change given to...:"+name);
		System.out.println(name+" takes...:"+(amt-100));
	}
}