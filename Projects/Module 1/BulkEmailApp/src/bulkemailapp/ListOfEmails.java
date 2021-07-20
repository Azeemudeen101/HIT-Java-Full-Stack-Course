package bulkmailapp;

import java.util.HashSet;

/* CLASS : LisOfEmails
 * METHODS : getEmails() - Store and Return Email's in HashSet
*/
public class ListOfEmails {
	public HashSet<String> getEmailList(){
		HashSet<String> emailList=new HashSet<String>();
		emailList.add("example@gmail.com");
		return emailList;
	}
}
