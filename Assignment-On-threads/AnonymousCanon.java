public class AnonymousCanon{
	public static void main(String[] args) {
		Canon bofors=new Canon();
		
		Thread naina=new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					bofors.fill();
				}
			}
		},"naina");
		Thread shabeer=new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					bofors.shoot();
				}
			}
		},"shabeer");

		naina.start();
		shabeer.start();

	}
}

class Canon{
	boolean flag;
	 public synchronized void fill() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println(name+" fills the gun.......");
		flag=true;
		notify();
	}
	
	synchronized public void shoot() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(!flag) {
			try {wait();}catch(Exception e) {}
		}
		System.out.println(name+" shoot the gun...........");
		flag=false;
		notify();
	}
}
