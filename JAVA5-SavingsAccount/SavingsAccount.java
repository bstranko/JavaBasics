//Bridgette Stranko
//JAVA Assignment 5 (Part 1)

import java.text.DecimalFormat;

/**
	This class stores data about a savings account
*/

public class SavingsAccount
{
	private double annualInterestRate;
	private double balance;

	/**
		This constructor sets the annual interest rate to 0.5%
		and sets the starting balance to 0.00
	*/

	public SavingsAccount()
	{
		annualInterestRate = 0.005;	//The annual interest rate for the account
		balance = 0.00;					//The account balance
	}

	/**
		This constructor sets the starting balance and
		and annual interest rate to the values passed as
		an arguments.
		@param bal The starting balance
		@param annRate The annual interest rate
	*/

	public SavingsAccount(double bal, double annRate)
	{
		//Validate that the starting balance is not a negative number
		//If it is negative set it to the default $0.00
		//If it is positive set it to the value passed as an argument
		if(bal < 0)
		{
			System.out.println("WARNING: Starting balance must not be negative; " +
									 "setting it to $0.00");
			balance = 0.00;
		}

		else
		{
			balance = bal;
		}

		//Validate that the annual interest rate is not a negative number
		//If it is negative set it to the default 0.5%
		//If it is positive set it to the value passed as an argument
		if(annRate < 0)
		{
			System.out.println("WARNING: Interest rate must not be negative; " +
									"setting it to 0.5%");

			annualInterestRate = 0.005;
		}
		else
		{
			annualInterestRate = annRate;
		}
	}

	/**
		The update method updates the balance in the savings account
		@param balUpdate The amount deposited or withdrawn
	*/

	public void update(double balUpdate)
	{
		DecimalFormat money = new DecimalFormat("$#,##0.00");
		//Add the balance update to the balance
		//If it is positive it will act like a deposit
		//If it is negative it will act like a withdrawal
		balance += balUpdate;

		//If the new balance is negative, send a message to the
		//console.
		if(balance < 0)
		{
			System.out.println("WARNING: ACCOUNT OVERDRAWN" +
										"\nCurrent balance: " + money.format(balance));
		}
	}

	/**
		The addInterest method computes and then adds the
		monthly interest rate to the account
	*/

	public void addInterest()
	{
		double monthlyInterestRate;	//To hold the monthly interest Rate
		double monthlyInterest;			//To hold the calculate monthly interest

		//If the balance is positive, calculate and add the
		//the monthly interest
		//If it is negative, balance does not change.
		if(balance > 0)
		{
			monthlyInterestRate = annualInterestRate / 12;
			monthlyInterest =  balance * monthlyInterestRate;
			balance += monthlyInterest;
		}
	}

	/**
		The equal method compares two objects to see if they contain the same data
		@param account2 The object you are comparing
		@return true if the objects contain the same data. Otherwise false.
	*/

	public boolean equals(SavingsAccount account2)
	{
		boolean status;	//Used to hold the boolean
								//that determines if balances are equal

		//If the balances are equal set status to true
		//If the balance are not equal set status to false
		if(account2.balance == balance &&
			account2.annualInterestRate == annualInterestRate)
		{
			status = true;
		}

		else
		{
			status = false;
		}

		//return true if the balance match. Otherwise, false.
		return status;
	}

	/**
		The compareTo method compares the balance in an object to see if it
		lesser, greater or equal to the balance in the object it is being compared to.
		@param account2 The object you are comparing
		@return 0 if it is equal, 1 if it is greater, and -1 if it is lesser
	*/

	public int compareTo(SavingsAccount account2)
	{
		int status;	//Used to hold the boolean that determines
						//if balance is greater, lesser, or equal

		//If the balance is greater than this object's balance set to status to 1
		if(balance > account2.balance)
		{
			status = 1;
		}

		//If the balance is equal to this object's balance set to status to 0
		else if(balance == account2.balance)
		{
			status = 0;
		}

		//If the balance is less than this object's balance set to status to 1
		else
		{
			status = -1;
		}

		//return 1 if it is greater, 0 if they are equal, and -1 if it is lesser
		return status;
	}

	/**
		The copy method initializes the object as a copy of another SavingsAccount object.
		@return a copy of the object.
	*/

	public SavingsAccount copy()
	{
		//Create an SavingsAccount object
		SavingsAccount copyOfAccount = new SavingsAccount();

		//Set the values in the new object
		//To the values in this object.
		copyOfAccount.balance = balance;
		copyOfAccount.annualInterestRate = annualInterestRate;

		//return a copy of the object
		return copyOfAccount;
	}

	/**
		The toString method creates a string with the current account information.
		@return A string containing the savings account information
	*/

	public String toString()
	{
		DecimalFormat money = new DecimalFormat("#,##0.00");
		DecimalFormat percent = new DecimalFormat("#0.0%");

		//Create a string representing the object.
		String data = "Balance: $" + money.format(balance) +
						"\nInterest Rate: " + percent.format(annualInterestRate);

		//Return the string
		return data;
	}

	/**
		The getInterestRate method returns the annual interest rate.
		@return The value in the annual interest rate field.
	*/

	public double getInterestRate()
	{
		//return the annual interest rate
		return annualInterestRate;
	}

	/**The getBalance method returns the account balance.
		@return The value in the balance field.
	*/

	public double getBalance()
	{
		//return the balance
		return balance;
	}
}

/*
[client] Bridgette Stranko

[client] Welcome to the Fleesum Bank
[client] This is the monthly interest calculator

[client] First SavingsAccount object

[client] Balance: 0.0
[client] Interest Rate: 0.005

[client] Using toString:
Balance: $0.00
Interest Rate: 0.5%

[client] Second SavingsAccount object

[client] Balance: 1000.0
[client] Interest Rate: 0.1

[client] Using toString:
Balance: $1,000.00
Interest Rate: 10.0%

[client] Interest computed. New balance: 1008.3333333333334

[client] Fifty dollars deposited. New balance: 1058.3333333333335
WARNING: ACCOUNT OVERDRAWN
Current balance: -$941.67

[client] Two thousand dollars withdrawn. New balance: -941.6666666666665

[client] Interest computed. New balance: -941.6666666666665

[client] Using toString:
Balance: $-941.67
Interest Rate: 10.0%

[client] savings1 has the larger balance

[client] savings1 and savings2 do not match

[client] savings1 matches itself

[client] Creating savings3, a copy of savings2
[client] savings2:
Balance: $-941.67
Interest Rate: 10.0%
[client] savings3:
Balance: $-941.67
Interest Rate: 10.0%

Press any key to continue . . .

*/