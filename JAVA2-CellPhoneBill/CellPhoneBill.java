//Bridgette Stranko
//JAVA A2

/*
This program will calculate the bill for a cellphone
company. The fees are based on 3 different service plans.

Service Plan 1: Regular Service
	>Base Fee: $10.00
	>First 60 minutes are free
	>Overage charge for minutes over 60
	 is $0.20 per minute

Service Plan 2: Premium Service
	>Base Fee: $25.00
	>First daytime 75 minutes are free
	>Overage charge for daytime minutes over 75
	 is $0.15 per minute
	>First 100 nighttime minutes are free
	>Overage charge for nighttime minutes over 100
	 is $0.05 per minute

Service Plan 3: Unlimited Service
	>Base Fee: $70.00
	>No overage charge

This program will get user input for the service type
and then, if necessary, the daytime and nighttime minutes

The program will display:
	>The bill amount
	>An error message if minutes are less than zero
	>An error message if service type is not 1, 2 or 3

*/

import java.util.Scanner;
import java.text.DecimalFormat;


public class CellPhoneBill
{
	public static void main(String[] args)
	{
		//P is short for Service Plan.
		//P1 is short for service plan 1, etc.

		final double BASE_FEE_P1 = 10.00;
		final double BASE_FEE_P2 = 25.00;
		final double BASE_FEE_P3 = 70.00;

		final int FREE_MIN_P1 = 60;
		final int FREE_DAY_P2 = 75;
		final int FREE_NIGHT_P2 = 100;

		final double OVERAGE_CHRG_P1 = 0.20;
		final double OVERAGE_DAY_P2 = 0.15;
		final double OVERAGE_NIGHT_P2 = 0.05;

		int servicePlan, dayMin, nightMin, totalMin;

		//"Charge" represents the amount billable
		//for minutes over the allowable free minutes
		double dayCharge = 0, nightCharge = 0, totalMinCharge = 0;
		double billAmount;

		Scanner keyboard = new Scanner(System.in);

		DecimalFormat money = new DecimalFormat( "$#,##0.00" );


		System.out.println("Bridgette Stranko \n");

		System.out.print("Enter your Service Plan 1, 2 or 3:  ");
		servicePlan = keyboard.nextInt();

		switch (servicePlan)
		{
			case 1:
				System.out.print("\nNumber of daytime minutes used:  ");
				dayMin = keyboard.nextInt();

				System.out.print("Number of nighttime minutes used:  ");
				nightMin = keyboard.nextInt();

				totalMin = dayMin + nightMin;

				if (totalMin < 0)
				{
					System.out.println("Minutes <0");
				}

				else if(totalMin > FREE_MIN_P1)
				{
					totalMin -= FREE_MIN_P1;
					totalMinCharge = totalMin * OVERAGE_CHRG_P1;
				}

				billAmount = totalMinCharge + BASE_FEE_P1;

				System.out.println("\nBill Amount: " + money.format(billAmount));
				break;

			case 2:
				System.out.print("\nNumber of daytime minutes used: ");
				dayMin = keyboard.nextInt();

				System.out.print("Number of nighttime minutes used: ");
				nightMin = keyboard.nextInt();

				if(dayMin > FREE_DAY_P2)
				{
					dayMin -= FREE_DAY_P2;
					dayCharge = dayMin * OVERAGE_DAY_P2;
				}

				if(nightMin > FREE_NIGHT_P2)
				{
					nightMin -= FREE_NIGHT_P2;
					nightCharge = nightMin * OVERAGE_NIGHT_P2;
				}

				if (dayMin < 0 || nightMin < 0)
					System.out.println("\nERROR: Minutes < 0");

				else
				{
					billAmount = dayCharge + nightCharge + BASE_FEE_P2;
					System.out.println("\nBill Amount: " + money.format(billAmount));
				}
				break;

			case 3:
				System.out.println("\nBill Amount: " + money.format(BASE_FEE_P3));
				break;

			default:
				System.out.println("\nERROR:  Invalid Type");
		}
	}
}

/******************************************************************************
Run 1

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  3

Bill Amount: $70.00

------------------------------------------------------------------------------
Run 2

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  2

Number of daytime minutes used: 120
Number of nighttime minutes used: 75

Bill Amount: $31.75

------------------------------------------------------------------------------
Run 3

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  2

Number of daytime minutes used: 75
Number of nighttime minutes used: 125

Bill Amount: $26.25

------------------------------------------------------------------------------

Run 4

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  1

Number of daytime minutes used:  45
Number of nighttime minutes used:  30

Bill Amount: $13.00

------------------------------------------------------------------------------

Run 5

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  1

Number of daytime minutes used:  30
Number of nighttime minutes used:  20

Bill Amount: $10.00

-----------------------------------------------------------------------------

Run 6

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  4

ERROR:  Invalid Type

----------------------------------------------------------------------------

Run 7

Bridgette Stranko

Enter your Service Plan 1, 2 or 3:  2

Number of daytime minutes used: -50
Number of nighttime minutes used: 25

ERROR: Minutes < 0


******************************************************************************/