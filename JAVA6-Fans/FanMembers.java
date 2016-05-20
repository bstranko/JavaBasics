import java.io.*;
import java.util.Scanner;

/*
	@author Bridgette Stranko
	Java A-6
	This program sorts and searches Mr. Rogers' Fans.
*/

public class FanMembers
{
	//Create a Scanner object for keyboard input.
	private static Scanner keyboard = new Scanner(System.in);

	public static void main (String [] args) throws IOException
	{
		final int MAX_SIZE = 100;					//The maximum array size for the Fan array
		int numFans;									//The total number of fans in the array
		Fan[] rogersFans = new Fan[MAX_SIZE];  //Create an array of Fan objects
															//with the max number of arrays

		System.out.println("Bridgette Stranko\n");

		//Call the fillArray method and return the number of
		//array elements that have been filled.
		numFans = fillArray(rogersFans, MAX_SIZE);

		//Call the listFanData method and pass it the
		//array and the number of array elements that have been filled.
		listFanData(rogersFans, numFans);

		//Call the bubbleSortByAge method and pass it the
		//array and the number of array elements that have been filled.
		bubbleSortByAge(rogersFans, numFans);

		//Call the bubbleSortByFan method and pass it the
		//array and the number of array elements that have been filled.
		bubbleSortByFan(rogersFans, numFans);

		//Call the searchByAge method and pass it the
		//array and the number of array elements that have been filled.
		searchByAge(rogersFans, numFans);

		//Call the searchByFan method and pass it the
		//array and the number of array elements that have been filled.
		searchByFan(rogersFans, numFans);
	}

	/*
		The fillArray method creates a Fan object for each fan.
		The fan's name and age is read from a file.
		@param array The array to reference the fans.
		@param MAX_FAN_SIZE The maximum number of fan elements.
		@return The number of fans in the file.
	*/
	public static int fillArray(Fan[] array, final int MAX_FAN_SIZE) throws IOException
	{
		int counter = 0;  //A counter for the number of fans in the file.
		int fanAge;			//To hold the fan's age until it is passed to the array element.
		String fanName; 	//To hold the fan's name until it is passed to the array element.
		String fileName;  //The file name entered by the user.

		//Get the file name from the user.
		System.out.print("Enter the filename: ");
		fileName = keyboard.nextLine();


		//Make sure the file exists.
		File fanFile = new File(fileName);
		if(!fanFile.exists())
		{
			System.out.println("File " + fileName + " not found");
			System.exit(0);
		}

		//Open the file for reading.
		Scanner inputFile = new Scanner(fanFile);

		System.out.println("Read names and ages of Mr. Rogers' fans");

		//Read the data from the file unless is is greater
		//than the maximum array size.
		while (inputFile.hasNext() && counter < MAX_FAN_SIZE)
		{
			fanName = inputFile.nextLine();
		   fanAge = inputFile.nextInt();
		  	inputFile.nextLine();

			//Create the Fans
		   array[counter] = new Fan(fanName, fanAge);

			//Count the number of elements that have been filled.
		   counter++;
		}

		//Close the file
		inputFile.close();

		//Display the number of fans found in the file.
		System.out.println("There are " + counter + " fans.\n");

		//If there was no data in the file, end program.
		if(counter == 0)
		{
			System.exit(0);
		}

		//Return the number of fans found in the file.
		return counter;
	}


	/*
		The listFanData method list the fan's names and ages.
		@param array The array to reference the fans.
		@param size The number of filled fan elements.
	*/
	public static void listFanData(Fan[] array, int size)
	{
		//Display the name and age of each fan.
		System.out.println("List all Mr. Rogers' fans");

		for(int index = 0; index < size; index++)
		{
			System.out.printf("%-17s %3d %n", array[index].getName(), array[index].getAge());
		}

	}

	/*
		The bubbleSortByFan method sorts the fans by name and displays
		the name and age to the screen.
		@param array The array to reference the fans.
		@param size The number of filled fan elements.
	*/
	public static void bubbleSortByFan(Fan[] array, int size)
	{
		boolean swap;					//true if swaps were made in this iteration.
		Fan [] temp = new Fan[1];  //used to swap fans in this array
		int last = size - 1;			//controls number of iterations

		//Loop through the array until all elements have been inspected
		do
		{
			//Presume no swaps are made
			swap = false;

			//Loop from the beginning to end.
			//This is one less element on each iteration
			for(int count = 0; count < last; count++)
			{
				//Doing an ascending order sort.
				if(array[count].getName().compareTo(array[count + 1].getName())  >  0)
				{
					//Swap elements and set swap to true.
					temp[0] = array[count];
					array[count] = array[count + 1];
					array[count + 1] = temp[0];
					swap = true;
				}
			}

			//Next iteration will stop one element sooner.
			last--;

		}while(swap);

		//Display the name and age of each fan which has been sorted by name.
		System.out.println("\nSort Mr. Rogers' fans by name");

		for(int index = 0; index < size; index++)
		{
			System.out.printf("%-17s %3d %n", array[index].getName(), array[index].getAge());
		}

	}

	/*
		The bubbleSortByAge method sorts the fans by age and displays
		the name and age to the screen.
		@param array The array to reference the fans.
		@param size The number of filled fan elements.
	*/
	public static void bubbleSortByAge(Fan[] array, int size)
	{
		boolean swap;					//true if swaps were made in this iteration.
		Fan [] temp = new Fan[1];  //used to swap fans in this array
		int last = size - 1;			//controls number of iterations

		//Loop through the array until all elements have been inspected
		do
		{
			//Presume no swaps are made
			swap = false;

			//Loop from the beginning to end.
			//This is one less element on each iteration
			for(int count = 0; count < last; count++)
			{
				//Doing a descending order sort.
				if(array[count].getAge() < array[count + 1].getAge())
				{
					temp[0] = array[count];
					array[count] = array[count + 1];
					array[count + 1] = temp[0];
					swap = true;
				}
			}

			//Next iteration will stop one element sooner.
			last--;

		}while(swap);

		//Display the name and age of each fan which has been sorted by age.
		System.out.println("\nSort Mr. Rogers' fans by descending age");

		for(int index = 0; index < size; index++)
		{
			System.out.printf("%-17s %3d %n", array[index].getName(), array[index].getAge());
		}

	}

	/*
		The searchByAge method allows the user to search the
		fans by age and displays results to the screen.
		@param array The array to reference the fans.
		@param size The number of filled fan elements.
	*/
	public static void searchByAge(Fan[] array, int size)
	{
		int userInput;		//To hold the user's input
		int count;			//Used to determine if there were any
								//fans of that age.

		System.out.println("\n\nLook up Mr. Rogers' fans by age\n");

		//Get the age from the user.
		System.out.print("\nAge to find (0 to quit): ");
		userInput = keyboard.nextInt();

		//Search for the age, while it is not 0.
		while(userInput != 0)
		{
			count = 0; //Initialize count to zero.

			//If the age is less than zero display an error message.
			//Get another age from the user.
			if(userInput <0)
			{
				System.out.println(userInput + " is not a valid age");
				System.out.print("Age to find (0 to quit): ");
				userInput = keyboard.nextInt();
			}

			//If the age is valid, search for the the age.
			else
			{
				for(int index = 0; index < size; index++)
				{
					//If the array element's age field matches the
					//users input, display the user's name and age,
					//and add one to the counter.
					if(array[index].getAge() == userInput)
					{
						System.out.println(array[index].toString());

						count++;
					}
				}
			}

			//If count equals 0, then there were no fans of that age.
			if(count == 0)
			{
				System.out.println("No fans of age " + userInput);
			}

			//Get the age from the user.
			System.out.print("\nAge to find (0 to quit): ");
			userInput = keyboard.nextInt();
		}

	}

	/*
		The searchByName method allows the user to search the
		fans by name and displays results to the screen.
		@param array The array to reference the fans.
		@param size The number of filled fan elements.
	*/
	public static void searchByFan(Fan[] array, int size)
	{
		String userInput;		//To hold the user's input
		int count;				//Used to determine if there were any
									//fans of that age.

		//Consume the next line.
		keyboard.nextLine();

		System.out.println("\n\nLook up Mr. Rogers' fans by name\n");

		//Get the name from the user.
		System.out.print("\nFan to find (Q to quit): ");
		userInput = keyboard.nextLine();

		//Search for the name while it is not Q or q.
		while(!userInput.equalsIgnoreCase("Q"))
		{
			count = 0;  //Initialize count to zero.

			for(int index = 0; index < size; index++)
			{
				//If the array element's name field matches the users input
				//(ignoring the case) display the user's name and age,
				//and add one to the counter.
				if(array[index].getName().equalsIgnoreCase(userInput))
				{
					System.out.println(array[index].toString());

					count++;
				}
			}

			//If count equals 0, then there were no fans by that name.
			if(count == 0)
			{
				System.out.println("No fan named " + userInput);
			}

			//Get the name from the user.
			System.out.print("\nFan to find (Q to quit): ");
			userInput = keyboard.nextLine();
		}

		System.out.println();

	}
}
/*
	RUN #1:

	Bridgette Stranko

	Enter the filename: FanData.txt
	Read names and ages of Mr. Rogers' fans
	There are 14 fans.

	List all Mr. Rogers' fans
	Chris P. Cream      5
	Scott Free          9
	Lou Tenant          3
	Trish Fish         12
	Ella Mentry         4
	Holly Day           3
	Robyn DeCradle     12
	Annette Funicello   4
	Elmo                7
	Grover              3
	Big Bird            9
	Bert                7
	Ernie               3
	Grover              9

	Sort Mr. Rogers' fans by descending age
	Trish Fish         12
	Robyn DeCradle     12
	Scott Free          9
	Big Bird            9
	Grover              9
	Elmo                7
	Bert                7
	Chris P. Cream      5
	Ella Mentry         4
	Annette Funicello   4
	Lou Tenant          3
	Holly Day           3
	Grover              3
	Ernie               3

	Sort Mr. Rogers' fans by name
	Annette Funicello   4
	Bert                7
	Big Bird            9
	Chris P. Cream      5
	Ella Mentry         4
	Elmo                7
	Ernie               3
	Grover              9
	Grover              3
	Holly Day           3
	Lou Tenant          3
	Robyn DeCradle     12
	Scott Free          9
	Trish Fish         12


	Look up Mr. Rogers' fans by age


	Age to find (0 to quit): 3
	Fan: Ernie is 3 years old
	Fan: Grover is 3 years old
	Fan: Holly Day is 3 years old
	Fan: Lou Tenant is 3 years old

	Age to find (0 to quit): 12
	Fan: Robyn DeCradle is 12 years old
	Fan: Trish Fish is 12 years old

	Age to find (0 to quit): 11
	No fans of age 11

	Age to find (0 to quit): 0


	Look up Mr. Rogers' fans by name


	Fan to find (Q to quit): Trish Fish
	Fan: Trish Fish is 12 years old

	Fan to find (Q to quit): grover
	Fan: Grover is 9 years old
	Fan: Grover is 3 years old

	Fan to find (Q to quit): Mary Contrary
	No fan named Mary Contrary

	Fan to find (Q to quit): elmo
	Fan: Elmo is 7 years old

	Fan to find (Q to quit): q

	Press any key to continue . . .
*/

/*
	RUN #2:
	Bridgette Stranko

	Enter the filename: noFile.txt
	File noFile.txt not found
	Press any key to continue . . .
*/

/*
	RUN #3
	Bridgette Stranko

	Enter the filename: fandata.txt
	Read names and ages of Mr. Rogers' fans
	There are 5 fans.

	List all Mr. Rogers' fans
	Chris P. Cream      5
	Scott Free          9
	Lou Tenant          3
	Trish Fish         12
	Ella Mentry         4

	Sort Mr. Rogers' fans by descending age
	Trish Fish         12
	Scott Free          9
	Chris P. Cream      5
	Ella Mentry         4
	Lou Tenant          3

	Sort Mr. Rogers' fans by name
	Chris P. Cream      5
	Ella Mentry         4
	Lou Tenant          3
	Scott Free          9
	Trish Fish         12


	Look up Mr. Rogers' fans by age


	Age to find (0 to quit): 7
	No fans of age 7

	Age to find (0 to quit): 0


	Look up Mr. Rogers' fans by name


	Fan to find (Q to quit): q

	Press any key to continue . . .
*/