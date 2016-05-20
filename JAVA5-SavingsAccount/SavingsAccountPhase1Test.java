// TEST SAVINGS ACCOUNT PHASE 1
// DO NOT MAKE ANY CHANGES TO THIS FILE EXCEPT YOUR NAME

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SavingsAccountPhase1Test
{
	public static void main(String args[]) throws IOException
	{
		double interestRate;       	// Annual interest rate
		double balance;				// Balance in the account
		double interestEarned;     	// Interest earned
		double amount;             	// Amount of a deposit or withdrawal
		double totalUpdates;		// Total amount deposited and withdrawn

		// Create a DecimalFormat object for formatting output.
		DecimalFormat df = new DecimalFormat("$#,##0.00");

		// Display your name
		System.out.println("[client] Bridgette Stranko");

		// Welcome message
		System.out.println("\n[client] Welcome to the Fleesum Bank"
			+ "\n[client] This is the monthly interest calculator");

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Create a SavingsAccount object using the no-argument constructor
		SavingsAccount savings1 = new SavingsAccount();

		// Display the initial state of savings1
		System.out.println("\n[client] First SavingsAccount object");
		System.out.println("\n[client] Balance: " + savings1.getBalance());
		System.out.println("[client] Interest Rate: " + savings1.getInterestRate());
		System.out.println("\n[client] Using toString:\n" + savings1.toString());

		// Create a SavingsAccount object using the 2-argument constructor
		SavingsAccount savings2 =
			new SavingsAccount(1000, 0.10);

		// Display the initial state of savings2
		System.out.println("\n[client] Second SavingsAccount object");
		System.out.println("\n[client] Balance: " + savings2.getBalance());
		System.out.println("[client] Interest Rate: " + savings2.getInterestRate());
		System.out.println("\n[client] Using toString:\n" + savings2.toString());

		// Test method addInterest when balance is >= 0
		savings2.addInterest();
		System.out.println("\n[client] Interest computed. New balance: " + savings2.getBalance());

		// update the balance:
		savings2.update( 50 );
		System.out.println("\n[client] Fifty dollars deposited. New balance: " + savings2.getBalance());
		// update, overdrawing the account
		savings2.update( -2000 );
		System.out.println("\n[client] Two thousand dollars withdrawn. New balance: " +
			savings2.getBalance());

		// Test method addInterest when balance is < 0
		savings2.addInterest();
		System.out.println("\n[client] Interest computed. New balance: " + savings2.getBalance());

		// Show final state of savings2:
		System.out.println("\n[client] Using toString:\n" + savings2.toString() + "\n");

		// Test compareTo method
		if ( savings1.compareTo(savings2) > 0 )
			System.out.println("[client] savings1 has the larger balance");
		else if (savings1.compareTo(savings2) == 0 )
			System.out.println("[client] savings1 and savings2 have the same balance");
		else
			System.out.println("[client] savings2 has the larger balance");

		// Test equals method
		if ( savings1.equals(savings2))
			System.out.println("\n[client] savings1 and savings2 match");
		else
			System.out.println("\n[client] savings1 and savings2 do not match");
		if ( savings1.equals(savings1))
			System.out.println("\n[client] savings1 matches itself");

		// Test copy method
		System.out.println("\n[client] Creating savings3, a copy of savings2");
		SavingsAccount savings3 = savings2.copy();
		System.out.println("[client] savings2:\n" + savings2.toString());
		System.out.println("[client] savings3:\n" + savings3.toString());
		System.out.println();
	}
}

