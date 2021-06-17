package labwork2;

import java.util.Random;
import java.util.Scanner;

public class Rock {
	public static void main(String[] args) {
		String personPlay = null; // User's play -- "R", "P", or "S"
		String computerPlay = null; // Computer's play -- "R", "P",or "S"
		int computerInt = 0; // Randomly generated number used to determine computer's play
		Scanner scan = new Scanner(System.in);

		Random generator = new Random();
		//Get player's play -- note that this is stored as a string
		//Make player's play uppercase for ease of comparison
		System.out.print("Rock,Paper,Scissors\n Your Choice (R/P/S): ");
		personPlay=scan.next();
		//Generate computer's play (0,1,2)
		computerInt=generator.nextInt(3);
		//Translate computer's randomly generated play to string
		switch (computerInt) {
		case 0:
			computerPlay="R";
			break;
		case 1:
			computerPlay="P";
			break;
		case 2:
			computerPlay="S";
			break;
		}
		System.out.println("Computer Chose: "+computerPlay);
		//Print computer's play
		//See who won. Use nested ifs instead of &&.
		if (personPlay.equals(computerPlay))
			System.out.println("It's a tie!");
		else if (personPlay.equals("R"))
			if (computerPlay.equals("S"))
				System.out.println("Rock crushes scissors. You win!!");
			else {
				System.out.println("Rock can't beat Paper, Computer Wins!");
			}
		else if(personPlay.equals("P"))
			if (computerPlay.equals("S"))
				System.out.println("Scissors will cut Paper. Computer Wins!!");
			else {
				System.out.println("Rock can't beat Paper, You Win!");
			}
		else if(personPlay.equals("S"))
			if (computerPlay.equals("R"))
				System.out.println("Rock crushes scissors. Computer Wins!!");
			else {
				System.out.println("Scissors will cut Paper, You Win!");
			}
		
	}
}