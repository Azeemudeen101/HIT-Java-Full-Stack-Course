package pdf_ecertificate;

import java.util.HashSet;

/* CLASS : StudentDetails
 * METHODS : getNameLise() - Store and Return HashSet of Student Names 
*/
public class StudentDetails {
	public HashSet<String> getNameList() {
		HashSet<String> nameList=new HashSet<>();
		nameList.add("Azeemudeen.A");
		nameList.add("Muhammed.M");
		nameList.add("Nabeel.S");
		nameList.add("Akash.L");
		nameList.add("Nithish.S");
		return nameList;
	}
}


