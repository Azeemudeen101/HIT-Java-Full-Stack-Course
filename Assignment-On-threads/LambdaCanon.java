public class LambdaCanon{
	public static void main(String[] args) {
		Canon bofors=new Canon();
		//Thread 1
		Thread naina=
		new Thread(()->{
			for(int i=0;i<5;i++) {
				bofors.fill();
			}
		},"naina");
		//Thread 2
		Thread shabeer=
		new Thread(()->{  //Jvm automatically takes this is as a Runnable object's run method
			for(int i=0;i<5;i++) {
				bofors.shoot();
			}
		},"shabeer"); //Create thread using lambda

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
