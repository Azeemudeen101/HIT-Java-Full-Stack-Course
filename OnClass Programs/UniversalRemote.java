public class UniversalRemote {
	public static void main(String[] args) {
		System.out.println("Demonstration of Remote...");
		Tv tv=new Tv();
		SetTopBox setTopBox=new SetTopBox();
		NetFlix netFlix=new NetFlix();
		SoundSystem soundSystem=new SoundSystem();
		
		FatherNewsChannelCommand fncc=new FatherNewsChannelCommand(tv, setTopBox, soundSystem, netFlix);
		MotherSerialCommand msc=new MotherSerialCommand(tv, setTopBox, soundSystem, netFlix);
		MotherOldMovieCommand momc=new MotherOldMovieCommand(tv, setTopBox, soundSystem, netFlix);
		
		Remote universalRemote=new Remote();
		universalRemote.executeCommand(1);
		universalRemote.setCommand(fncc, 0);
		universalRemote.setCommand(momc, 1);
		universalRemote.setCommand(msc, 2);
		
		System.out.println("My Father wants to see news channell...");
		universalRemote.executeCommand(0);
				
	}
}
class Tv{
	public void av1() {
		System.out.println("tv switched to av1 mode...");
	}
	public void switchOn() {
		System.out.println("tv switched on....");
	}
}
class SetTopBox{
	public void newsChannel() {
		System.out.println("news channel started.....");
	}
	public void serialChannel() {
		System.out.println("serial channel started.....");
	}
}
class NetFlix{
	public void movieOld() {
		System.out.println("old movie started....");
	}
}
class SoundSystem{
	public void lowSound() {
		System.out.println("sound volume....decreased....");
	}
}
interface Command{
	public void execute() ;
}
class FatherNewsChannelCommand implements Command{
	Tv tv;SetTopBox setTopBox; SoundSystem soundSystem;NetFlix netFlix;
	public FatherNewsChannelCommand(Tv tv, SetTopBox setTopBox, SoundSystem soundSystem, NetFlix netFlix) {
		this.tv = tv;
		this.setTopBox = setTopBox;
		this.soundSystem = soundSystem;
		this.netFlix = netFlix;
	}
	
	@Override
	public void execute() {
		System.out.println("Father Tv action started....");
		tv.switchOn();
		tv.av1();
		setTopBox.newsChannel();
		soundSystem.lowSound();
		System.out.println("dad enjoy your news channel....");
	}
}
class MotherOldMovieCommand implements Command{
	Tv tv;SetTopBox setTopBox; SoundSystem soundSystem;NetFlix netFlix;
	public MotherOldMovieCommand(Tv tv, SetTopBox setTopBox, SoundSystem soundSystem, NetFlix netFlix) {
		this.tv = tv;
		this.setTopBox = setTopBox;
		this.soundSystem = soundSystem;
		this.netFlix = netFlix;
	}
	@Override
	public void execute() {
		System.out.println("mother old movie command started...");
		tv.switchOn();
		tv.av1();
		netFlix.movieOld();
		System.out.println("enjoy the old movie mom.............");
	}
}
class MotherSerialCommand implements Command{
	Tv tv;SetTopBox setTopBox; SoundSystem soundSystem;NetFlix netFlix;
	public MotherSerialCommand(Tv tv, SetTopBox setTopBox, SoundSystem soundSystem, NetFlix netFlix) {
		this.tv = tv;
		this.setTopBox = setTopBox;
		this.soundSystem = soundSystem;
		this.netFlix = netFlix;
	}
	@Override
	public void execute() {
		System.out.println("mother serial command started....");
		tv.switchOn();
		tv.av1();
		setTopBox.serialChannel();
		System.out.println("enjoy the serial mom..........");
	}
}
class DummyCommand implements Command{
	@Override
	public void execute() {
		System.out.println("I am a dummy button...");
	}
}
class Remote{
	Command command[]=new Command[5];
	public Remote() {
		for(int i=0;i<command.length;i++) {
			command[i]=new DummyCommand();
		}
	}
	public void setCommand(Command command,int slot) {
		this.command[slot]=command;
	}
	public void executeCommand(int slot) {
		command[slot].execute();
	}
}