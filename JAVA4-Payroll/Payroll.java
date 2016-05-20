//Bridgette Stranko
//JAVA Assignment 4

import java.util.Scanner; 			// Needed for the Scanner class
import java.io.*;				// Needed for the File and IOException

/**
	This program processes some payroll data.
*/

public class Payroll
{
	public static void main(String[] args) throws IOException
	{
		String fileName, employeeName;
		int count = 0;
		double sales, commission, bonus, grossPay;
		double totalGrossPay = 0, averagePay = 0;
		final int BASE_PAY = 400;

		//Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Bridgette Stranko\n");

		//Get file name from user.
		System.out.print("File Name: ");
		fileName = keyboard.nextLine();

		//Make sure the file exists.
		File payDataFile = new File(fileName);
		if(!payDataFile.exists())
		{
			System.out.println("File not found.");
			System.exit(0);
		}

		//Open the file for reading.
		Scanner inputFile = new Scanner(payDataFile);

		System.out.println("\nEMPLOYEE\t\t COMMISSION\t BONUS\t GROSS PAY");
		System.out.println("--------------------------------------------" +
								   "--------------");

		while(inputFile.hasNext())
		{

			//Get employee name from file
			employeeName = inputFile.nextLine();

			//Get employees sales from file
			sales = inputFile.nextDouble();

			//Call getCommission passing the value in sales as
			//an argument. Assign the return value to commission.
			commission = getCommission(sales);

			//Call getBonus passing the value in sales as an
			//argument. Assign the return value to bonus
			bonus = getBonus(sales);

			//Consume the newline character
			inputFile.nextLine();

			//calculate gross pay
			grossPay = BASE_PAY + commission + bonus;

			System.out.printf("%-24s %,10.2f %,10.2f %,11.2f %n"
					   , employeeName, commission, bonus, grossPay);

			//calculate total gross pay
			totalGrossPay += grossPay;
			count++;
		}

		//Make sure there was data in the file
		if(count == 0)
			System.out.println("There was no data in the file.\n");

		else
		{
			averagePay = totalGrossPay/count;

			System.out.printf("%nTOTAL GROSS PAY %,20.2f %n", totalGrossPay);
			System.out.printf("AVERAGE GROSS PAY %,18.2f %n", averagePay);
		}
	}

	/**
		This method calculates the commission earned based on employee sales
		@param sales The employees sales for this pay period.
		@return The commission amount earned for this pay period.
	*/
	public static double getCommission(double sales)
	{
		double commission;
		final double SMALL_COMMISSION = 0.10;
		final double BIG_COMMISSION = 0.12;
		final int SMALL_SALES = 1000;

		//Calculate commission based on the smaller percentage.
		if(sales <= SMALL_SALES)
			commission = sales * SMALL_COMMISSION;

		//calculate the sales based on the larger percentage.
		else
		{
			commission = ((sales - SMALL_SALES)*BIG_COMMISSION)
					+ (SMALL_SALES * SMALL_COMMISSION);
		}

		return commission;
	}

	/**
		This method calculates the bonus earned based on employee sales
		@param sales The employees sales for this pay period.
		@return The bonus amount earned for this pay period.
	*/
	public static double getBonus(double sales)
	{
		double bonus;
		final int BONUS_SALES = 5000;
		final double BONUS_PERCENT = 0.02;

		//Calculate a bonus for sales greater than BONUS_SALES
		if(sales <= BONUS_SALES)
			bonus = 0;

		else
			bonus = (sales - BONUS_SALES) * BONUS_PERCENT;

		return bonus;
	}

}

/*
FROM PAYDATA.TXT


Bridgette Stranko

File Name: payData.txt

EMPLOYEE                 COMMISSION      BONUS   GROSS PAY
----------------------------------------------------------
Chris P. Cream               170.85       0.00      570.85
Scott Free                    45.05       0.00      445.05
Lou Tenant                 2,846.81     377.80    3,624.61
Trish Fish                    76.08       0.00      476.08
Ella Mentry                  388.00       0.00      788.00
Holly Day                    674.74      15.79    1,090.53
Robyn DeCradle             1,186.03     101.01    1,687.03

TOTAL GROSS PAY             8,682.16
AVERAGE GROSS PAY           1,240.31
Press any key to continue . . .
*/

/*
FROM EMPTY FILE

Bridgette Stranko

File Name: emptyFile.txt

EMPLOYEE                 COMMISSION      BONUS   GROSS PAY
----------------------------------------------------------
There was no data in the file.

Press any key to continue . . .

*/


