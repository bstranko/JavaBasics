//Bridgette Stranko
//JAVA A-3

/*
This program is an interactive game
It starts with a number of stones chosen by the user
The turns will alternate between human and computer
For the humans turn, the user will input number of stones
between one and half of the stones remaining.
For the computers turn, the system will generate a random number
within range.
Those stones are taken from the pile.
When there is only one stone left. The game ends
*/

import java.util.Scanner; //needed for input
import java.util.Random; //needed for computer's turn

public class Stones
{
	public static void main(String[] args)
	{
		String input;
		int numOfStones, stonesPlayed;
		char player;

		Scanner kb = new Scanner(System.in);
		Random computerPlays = new Random();

		System.out.println("Bridgette Stranko");
		System.out.println("\nWelcome to my game!");

		//get number of stones from player
		System.out.print("How many stones are in the pile? ");
		numOfStones = kb.nextInt();

		//validate input from user
		while(numOfStones < 10 || numOfStones > 100)
		{
			System.out.println("There must be between 10 and 100 stones.");
			System.out.print("How many stones are in the pile? ");
			numOfStones = kb.nextInt();
		}

		//consume next line
		kb.nextLine();

		//get first player from user
		System.out.print("Who goes first H or h (human) or C or c (computer)? ");
		input = kb.nextLine();
		player = input.charAt(0);

		//validate input from user
		while(player != 'h' && player != 'H' && player != 'c' && player != 'C' )
		{
			System.out.print("Who goes first H or h (human) or C or c (computer)? ");
			input = kb.nextLine();
			player = input.charAt(0);
		}

		//A loop that will run until there is only one stone left
		while(numOfStones > 1)
		{

			if(player == 'H' || player == 'h')
			{
				System.out.println("\nYou can take up to " + numOfStones/2 + " stone(s)");
				System.out.print("How many do you want to take? ");
				stonesPlayed = kb.nextInt();

				//validate number of stones played
				while(stonesPlayed < 1 || stonesPlayed > numOfStones/2)
				{
					System.out.println("Take 1 to " + numOfStones/2 + " stone(s)");
					System.out.print("How many do you want? ");
					stonesPlayed = kb.nextInt();
				}

				//changes next player to computer for next run
				player = 'c';
			}

			else
			{
				//gets a random number within range for computer's turn
				stonesPlayed = computerPlays.nextInt(numOfStones/2) + 1;
				System.out.println("\nComputer takes " + stonesPlayed + " stone(s)");

				//changes next player to human for next run
				player = 'h';
			}

			//removes stones played from the pile
			numOfStones -= stonesPlayed;

			System.out.println("There is/are " + numOfStones + " stone(s) left");
		}


		// if the last player was the computer than the human wins
		if(player != 'h')
		{
			System.out.println("\nBRIDGETTE STRANKO WINS!");
		}

		// else if the last player was the human than the computer wins
		else
		{
				System.out.println("\nCOMPUTER WINS!");
		}
	}

}

/*
Bridgette Stranko

Welcome to my game!
How many stones are in the pile? 20
Who goes first H or h (human) or C or c (computer)? h

You can take up to 10 stone(s)
How many do you want to take? 10
There is/are 10 stone(s) left

Computer takes 3 stone(s)
There is/are 7 stone(s) left

You can take up to 3 stone(s)
How many do you want to take? 3
There is/are 4 stone(s) left

Computer takes 1 stone(s)
There is/are 3 stone(s) left

You can take up to 1 stone(s)
How many do you want to take? 1
There is/are 2 stone(s) left

Computer takes 1 stone(s)
There is/are 1 stone(s) left

COMPUTER WINS!

________________________________________________

Bridgette Stranko

Welcome to my game!
How many stones are in the pile? 5
There must be between 10 and 100 stones.
How many stones are in the pile? -5
There must be between 10 and 100 stones.
How many stones are in the pile? 200
There must be between 10 and 100 stones.
How many stones are in the pile? 10
Who goes first H or h (human) or C or c (computer)? x
Who goes first H or h (human) or C or c (computer)? Y
Who goes first H or h (human) or C or c (computer)? C

Computer takes 5 stone(s)
There is/are 5 stone(s) left

You can take up to 2 stone(s)
How many do you want to take? 8
Take 1 to 2 stone(s)
How many do you want? 0
Take 1 to 2 stone(s)
How many do you want? -1
Take 1 to 2 stone(s)
How many do you want? 2
There is/are 3 stone(s) left

Computer takes 1 stone(s)
There is/are 2 stone(s) left

You can take up to 1 stone(s)
How many do you want to take? 1
There is/are 1 stone(s) left

BRIDGETTE STRANKO WINS!

*/
