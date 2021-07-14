package bulkemailapp;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
 * SendBulkMail Class: 
 * 		Have methods to separate Name and Email from List.
 *		Then send it to a fixed number of threads executing sendMail in ComposeEmail class
 * Methods:
 * 	sendEmail - Send the processed name and email to execute method in a loop
 * 				and Terminate the Threads after execution.
 * 	execute - Add composeEmail.(name,email) to the fixed thread 
 */
public class SendBulkMail { 
	ExecutorService executorService=Executors.newFixedThreadPool(10); //Create Thread Pool of 10
	ComposeEmail composeEmail=new ComposeEmail();
	String recipientName,recipientEmail;
	boolean isFinished=false;
	public void sendEmail(List<String> emailList) {
		int index=0;
		for(String email:emailList) {
			StringTokenizer token=new StringTokenizer(email,"@");
			recipientName=token.nextToken();
			recipientEmail=emailList.get(index++);
			execute(recipientEmail,recipientName);
		}
		executorService.shutdown();
	}

	public void sendEmail(Map<String, String> emailList){
		Iterator iterator=emailList.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, String> me=(Map.Entry)iterator.next();
			String recipientName=me.getKey();
			String recipientEmail= me.getValue();
			execute(recipientEmail, recipientName);
		}
		executorService.shutdown();
	}

	public void sendEmail(Set<String> emailList) {
		Iterator<String> iter=emailList.iterator();
		while(iter.hasNext()) {
			String nextEmail=iter.next();
			StringTokenizer token=new StringTokenizer(nextEmail,"@");
			String recipientName=token.nextToken();
			String recipientEmail=nextEmail;
			execute(recipientEmail,recipientName);
		}
		executorService.shutdown();
	}

	//Only Job is Start Threads to Send Email
	public void execute(String recipientEmail,String recipientName) {
		Runnable task=new Runnable() {
			@Override
			public void run() {
				composeEmail.sendMail(recipientName,recipientEmail);
			}
		};
		executorService.execute(task);

	}
}

