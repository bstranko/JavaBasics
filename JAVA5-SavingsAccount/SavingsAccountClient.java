/**
Javadoc goes here
*/

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SavingsAccountClient
{
	public static void main(String args[]) throws IOException
	{
		// Use these declarations. Add any others you need.
		double interestRate;      			// Annual interest rate
		double balance;						// Balance in the account
		double interestEarned;    			// Interest earned
		double amount;            			// Amount of a deposit or withdrawal
		double totalUpdates = 0;			// Total amount deposited and withdrawn
		double balanceDiff; 					// The difference in balances
		int trackTime = 0; 					// The time it takes for balance to be greater in months
		int years; 								// Years it takes for balance to be greater (not including months)
		int months;		 						// Remaining months it takes for balance to be greater


		// Display your name
		System.out.println("Bridgette Stranko");

		// Welcome message
		System.out.println("\nWelcome to the Fleesum Bank"
			+ "\nThis is the monthly interest calculator");

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Get the annual interest rate.
		System.out.print("\nEnter the savings account's " +
			"annual interest rate: ");
		interestRate = keyboard.nextDouble();

		// Get the starting balance.
		System.out.print("\nEnter the starting balance: ");
		balance = keyboard.nextDouble();

		//Create a new SavingsAccount object pass it the values assigned to the
		//variables balance and interestRate
		SavingsAccount myAccount = new SavingsAccount(balance, interestRate);

		//Display the starting values.
		System.out.println("\nStarting Values:\n" + myAccount.toString() + "\n");

		//Make sure the file exists.
		File transactFile = new File("Updates.txt");

		if(!transactFile.exists())
		{
			System.out.println("File not found");
			System.exit(0);
		}

		//Open the file for reading.
		Scanner inputFile = new Scanner(transactFile);

		//Read all the data from the file
		while(inputFile.hasNext())
		{
			amount = inputFile.nextDouble();
			myAccount.update(amount);
			totalUpdates +=amount;
		}

		//Close the file
		inputFile.close();

		//Add monthly interest to account
		myAccount.addInterest();

		//Calculate interest earned
		interestEarned = (myAccount.getBalance() - balance) - totalUpdates;

		//Display ending balance and interest rate for the month
		System.out.println("\nFinal values:\n" + myAccount.toString()+ "\n");

		//Display some information about myAccount
		System.out.printf("Starting Balance: %,30.2f%n", balance);
		System.out.printf("Total Updates this month: %,22.2f%n",  totalUpdates);
		System.out.printf("Interest earned for this month: %,16.2f%n", interestEarned);
		System.out.printf("Balance at the end of the month: %,15.2f%n", myAccount.getBalance());

		//Create a new SavingsAccount object pass it the values $800 and 6%
		SavingsAccount first = new SavingsAccount(800, 0.06);

		//Create a new SavingsAccount object pass it the values 1000 and 5%
		SavingsAccount second = new SavingsAccount(1000, 0.05);

		//Pre-test loop that will add interest to the two accounts
		//on a monthly basis, and tracks the time it takes (in months)
		//for the first account to reach a greater balance than the second account
		while(second.compareTo(first) > 0)
		{
			first.addInterest();
			second.addInterest();
			trackTime++;
		}

		//Calculate the number of years
		years = trackTime / 12;

		//Calculate the remaining months
		months = trackTime % 12;

		//Display the results
		System.out.println("\nFirst:");
		System.out.println(first.toString());
		System.out.println("Second:");
		System.out.println(second.toString());
		System.out.println("It took " + years + " years " + months + " months\n");

		//Create a new SavingsAccount object pass it the values $800 and 6%
		SavingsAccount third = new SavingsAccount(1000, 0.05);

		//Create a new SavingsAccount object pass it the values 1000 and 5%
		SavingsAccount fourth = new SavingsAccount(1000, 0.06);

		//Add compound interest over a 50 year period to the balance
		addCompoundInterest(third);

		//Add compound interest over a 50 year period to the balance
		addCompoundInterest(fourth);

		//Calculate the balance difference between the third and fourth
		//savings account
		balanceDiff = fourth.getBalance() - third.getBalance();

		//Display some information about the account
		System.out.println("\nThird:");
		System.out.println(third.toString());
		System.out.println("Fourth:");
		System.out.println(fourth.toString());
		System.out.printf("The difference is $%,.2f%n", balanceDiff);

	}

	/**
		The addCompoundInterest method adds compound interest for a 50 year
		period, and adds it to the balance
		@param account The object you are updating
	*/
	public static void addCompoundInterest(SavingsAccount account)
	{
		final int COMPOUND_INTEREST_RATE = 12;  //# of times the interest compounds per year
		final int TIME = 50;							//Time period in which the interest is accrued
		double interestEarned;						//The total interest earned over the set period
															//of time.

		/*Calculate the interest earned over a 50 year period using the compound interest
		formula:  A = P(1 + r/n)^n*t and subtract P from A
		where
		P = principal amount (the initial amount you borrow or deposit)
		r  = annual rate of interest (as a decimal)
		t  = number of years the amount is deposited or borrowed for.
		A = amount of money accumulated after n years, including interest.
		n  =  number of times the interest is compounded per year */
		interestEarned = (account.getBalance() * Math.pow((1 + (account.getInterestRate()
								/ COMPOUND_INTEREST_RATE)), (COMPOUND_INTEREST_RATE * TIME))) - account.getBalance();

		//Add the balance to the interest earned
		account.update(interestEarned);
	}

}

/*
Bridgette Stranko

Welcome to the Fleesum Bank
This is the monthly interest calculator

Enter the savings account's annual interest rate: 0.035

Enter the starting balance: 1000

Starting Values:
Balance: $1,000.00
Interest Rate: 3.5%

WARNING: ACCOUNT OVERDRAWN
Current balance: -$275.00

Final values:
Balance: $1,514.35
Interest Rate: 3.5%

Starting Balance:                       1,000.00
Total Updates this month:                 509.95
Interest earned for this month:             4.40
Balance at the end of the month:        1,514.35

First:
Balance: $3,060.28
Interest Rate: 6.0%
Second:
Balance: $3,060.27
Interest Rate: 5.0%
It took 22 years 5 months


Third:
Balance: $12,119.38
Interest Rate: 5.0%
Fourth:
Balance: $19,935.96
Interest Rate: 6.0%
The difference is $7,816.57
*/
