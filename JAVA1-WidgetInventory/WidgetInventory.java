//Bridgette Stranko
//JAVA A1

/*
This program will provide information on the
Wicked Widgets Company's ("WWC") inventory for
its three main products: Type A, B & C Widgets.

Using the Widgets fixed prices($5.25, $7.50, and $9.00
respectively), as well as user input for the number of
each type of Widget currently in stock, and user input
for the percent markup that WWC intends to take, this
program will display the following:

	>The percent of stock the type of Widget represents
	>The selling price for that type of Widget
	>The total cost of that type of Widget
	>The total value of that type of Widget

The program will also display

	>The overall inventory cost
	>The overall inventory value
	>The gross profit margin

*/

import java.util.Scanner;

public class WidgetInventory
{
	public static void main(String[] args)
	{
		int stockTypeA, stockTypeB, stockTypeC; //how many in stock
		double costTypeA = 5.25, costTypeB = 7.5, costTypeC = 9.0;
		double stockPercentA, stockPercentB, stockPercentC;
		double sellingPriceA, sellingPriceB, sellingPriceC;
		double totalCostA, totalCostB, totalCostC;
		double totalValueA, totalValueB, totalValueC;
		double markupPercent, totalStock;
		double totalInventoryCost, totalInventoryValue, grossProfit;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Bridgette Stranko\n");

		System.out.print("How many Type A Widgets? ");
		stockTypeA = keyboard.nextInt();

		System.out.print("How many Type B Widgets? ");
		stockTypeB = keyboard.nextInt();

		System.out.print("How many Type C Widgets? ");
		stockTypeC = keyboard.nextInt();

		System.out.print("\nMarkup Percent: ");
		markupPercent = keyboard.nextDouble();

		//Calculations for total stock used for percent of Type A, B, & C
		totalStock = stockTypeA + stockTypeB + stockTypeC;

		//Calculation to format markupPercent
		//for multiplication as a percentage
		markupPercent /= 100;

		stockPercentA = (stockTypeA / totalStock) * 100;
		sellingPriceA = costTypeA + costTypeA * markupPercent;
		totalCostA = costTypeA * stockTypeA;
		totalValueA = sellingPriceA * stockTypeA;

		System.out.println("\nPercent Type A:   $" + stockPercentA + "%");
		System.out.println("Type A selling price:\t $" + sellingPriceA);
		System.out.println("Type A total cost:\t $" + totalCostA);
		System.out.println("Type A total value:\t $" + totalValueA);

		stockPercentB = (stockTypeB / totalStock) * 100;
		sellingPriceB = costTypeB + costTypeB * markupPercent;
		totalCostB = costTypeB * stockTypeB;
		totalValueB = sellingPriceB * stockTypeB;

		System.out.println("\nPercent Type B:   " + stockPercentB + "%");
		System.out.println("Type B selling price:\t $" + sellingPriceB);
		System.out.println("Type B total cost:\t $" + totalCostB);
		System.out.println("Type B total value:\t $" + totalValueB);

		stockPercentC = (stockTypeC / totalStock) * 100;
		sellingPriceC = costTypeC + costTypeC * markupPercent;
		totalCostC = costTypeC * stockTypeC;
		totalValueC = sellingPriceC * stockTypeC;

		System.out.println("\nPercent Type C:   " + stockPercentC + "%");
		System.out.println("Type C selling price:\t $" + sellingPriceC);
		System.out.println("Type C total cost:\t $" + totalCostC);
		System.out.println("Type C total value:\t $" + totalValueC);

		totalInventoryCost = totalCostA + totalCostB + totalCostC;
		totalInventoryValue = totalValueA + totalValueB + totalValueC;
		grossProfit = totalInventoryValue - totalInventoryCost;

		System.out.println("\nTotal Inventory Cost:\t $" + totalInventoryCost);
		System.out.println("Total Inventory Value:\t $" + totalInventoryValue);
		System.out.println("Gross Profit Margin:\t $" + grossProfit);
	}
}

/****************************************
Bridgette Stranko

How many Type A Widgets? 450
How many Type B Widgets? 1800
How many Type C Widgets? 1350

Markup Percent: 10.5

Percent Type A:   $12.5%
Type A selling price:    $5.80125
Type A total cost:       $2362.5
Type A total value:      $2610.5625

Percent Type B:   50.0%
Type B selling price:    $8.2875
Type B total cost:       $13500.0
Type B total value:      $14917.5

Percent Type C:   37.5%
Type C selling price:    $9.945
Type C total cost:       $12150.0
Type C total value:      $13425.75

Total Inventory Cost:    $28012.5
Total Inventory Value:   $30953.8125
Gross Profit Margin:     $2941.3125

***************************************/