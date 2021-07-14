package bulkemailapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class ListOfEmails {
	//Use ArrayList if we don't care about repeated email's in List
	public ArrayList<String> emailList(){
		ArrayList<String> emailList=new ArrayList<>();
		emailList.add("example@gmail.com");
		emailList.add("example@gmail.com");
		emailList.add("example@gmail.com");
		emailList.add("example@gmail.com");
		return emailList;
	}
	
	//Use HashSet to ensure there is no duplicate email
	public HashSet<String> emailSet() {
		HashSet<String> emailList=new HashSet<String>();
		emailList.add("example@gmail.com");
		emailList.add("example@gmail.com");
		emailList.add("example@gmail.com");
		emailList.add("example@gmail.com");
		return emailList;
	}
	
	//Use when we have Name and Email information to specify.
	public TreeMap<String,String> emailsMap(){
		TreeMap<String,String> emailList=new TreeMap<>();
		//Add Email List as TreeMap Collection
		emailList.put("Name", "youremail@gmail.com");
		emailList.put("Name", "youremail@gmail.com");
		emailList.put("Name", "youremail@gmail.com");
		emailList.put("Name", "youremail@gmail.com");
		emailList.put("Name", "youremail@gmail.com");
		return emailList;
	}
}
