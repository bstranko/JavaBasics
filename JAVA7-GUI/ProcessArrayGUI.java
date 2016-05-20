import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;

/**
	Bridgette Stranko
	Assignment Java A-7
	The ProcessArrayGUI creates an array of numbers,
	and processes the numbers according to the users choice.
*/
public class ProcessArrayGUI extends JFrame
{

	private JPanel radioButtonJPanel; // To hold the radio buttons
   private JPanel optionJPanel;		 // To hold the JLabel, JButton & radioButtonJPanel
   private JPanel mainPanel;			 // To hold optionJPanel & JTextField

   private JButton processButton;	 	// To process the chosen action
   private JLabel optionLabel;			// For the optionJPanel
   private JTextField messageTxtField;	// Displays a message about the action processed

	// For the radioButtonJPanel
   private JRadioButton newArray;		// To create a new array
   private JRadioButton displayArray;	// To display the array
   private JRadioButton sortArray;		// To sort the array
   private JRadioButton showArrayAvg;	// To display the average value
   private JRadioButton showArrayMax;	// To display the maximum value
   private JRadioButton showArrayMin;	// To display the minimum value
   private ButtonGroup arrayBg;			// Radio button group

   private int[] numbers;	// The array of numbers

	//Create a Random class object
	private Random randomNumbers = new Random();

	//Create a DecimalFormat object
	private DecimalFormat numberFormat =
							new DecimalFormat("#0.0");

	private final int WINDOW_WIDTH = 300;		//Width of the window
	private final int WINDOW_HEIGHT = 200;		//Height of the window

   /**
      Constructor
   */

   public ProcessArrayGUI()
   {
      // Display a title.
      setTitle("Bridgette Stranko");

		//Set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the main panel.
      buildMainPanel();

      // Add the main panel to the content pane.
      add(mainPanel);

      // display the window
      setVisible(true);
   }

   /**
      The buildRadioButtonJPanel method builds the radio button panel.
   */
   private void buildRadioButtonJPanel()
   {
		radioButtonJPanel = new JPanel();
      radioButtonJPanel.setLayout(new GridLayout(3, 2));

      // Create the radio buttons.
      newArray = new JRadioButton("New Array", true);
      displayArray = new JRadioButton("Display Array");
      sortArray = new JRadioButton("Sort Array");
      showArrayAvg = new JRadioButton("Show Array Average");
      showArrayMax = new JRadioButton("Show Array Max");
      showArrayMin = new JRadioButton("Show Array Min");

      // Group the radio buttons.
      arrayBg = new ButtonGroup();
      arrayBg.add(newArray);
      arrayBg.add(displayArray);
      arrayBg.add(sortArray);
      arrayBg.add(showArrayAvg);
      arrayBg.add(showArrayMax);
      arrayBg.add(showArrayMin);

      // Add the radio buttons to the panel.
      radioButtonJPanel.add(newArray);
      radioButtonJPanel.add(displayArray);
      radioButtonJPanel.add(sortArray);
      radioButtonJPanel.add(showArrayAvg);
      radioButtonJPanel.add(showArrayMax);
      radioButtonJPanel.add(showArrayMin);

   }

   /**
      The buildMainPanel method builds the main panel.
   */
	private void buildMainPanel()
	{
		// Create the main panel
		mainPanel = new JPanel();

		//Set the layout as Border Layout
		mainPanel.setLayout(new BorderLayout());

		//Call the buildOptionJPanel method
      buildOptionJPanel();

		// Create the text field
		messageTxtField = new JTextField(20);

		//Add the components to the main panel
		mainPanel.add(optionJPanel, BorderLayout.CENTER);
		mainPanel.add(messageTxtField, BorderLayout.SOUTH);
	}

	/**
		The buildOptionJPanel method builds the option panel
	*/
	private void buildOptionJPanel()
	{
		//Call the buildRadioButtonJpanel method.
	   buildRadioButtonJPanel();

		// Create a panel for the button
		// and set the layout as a FlowLayout.
		optionJPanel = new JPanel();
		optionJPanel.setLayout(new FlowLayout());

      // Create the label.
      optionLabel = new JLabel("CHOOSE AN ACTION");

		// Create the button.
		processButton = new JButton("PROCESS ACTION");

		// Register the action listener.
		processButton.addActionListener(new ProcessButtonListener());

		// Add the components to the option panel.
      optionJPanel.add(optionLabel);
      optionJPanel.add(radioButtonJPanel);
      optionJPanel.add(processButton);

	}

   /**
      Private inner class that handles the event when
      the user clicks the process button.
   */
   private class ProcessButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
			//If New Array radio button is selected, create a new array.
			if (newArray.isSelected())
			{
				getNewArray();
			}

			//If the array exists, and the
			//Display Array radio button is selected, display the array.
			else if (displayArray.isSelected())
			{
				if(arrayExists())
				{
					displayNumbers();
				}
			}

			//If the array exists, and the
			//Sort Array radio button is selected, sort the array,
			//but do not display it.
			else if (sortArray.isSelected())
			{
				if(arrayExists())
				{
					bubbleSortArray();
				}
			}

			//If the array exists, and the
			//Show Array Average radio button is selected,
			//Display the average in the text field.
			else if (showArrayAvg.isSelected())
			{
				if(arrayExists())
				{
					getAverage();
				}
			}

			//If the array exists, and the
			//Show Array Max radio button is selected,
			//Display the highest number in the text field.
			else if (showArrayMax.isSelected())
			{
				if(arrayExists())
				{
					getMaximum();
				}
			}

			//If the array exists, and the
			//Show Array Min radio button is selected,
			//Display the lowest number in the text field.
			else if (showArrayMin.isSelected())
			{
				if(arrayExists())
				{
					getMinimum();
				}
			}
      }
   }

	/**
		The arrayExists method. Determines whether or not the array exists.
		@return true if the array exists, false if it does not exists.
	*/

   public boolean arrayExists()
   {
		boolean status;  //true = exists, false = does not exists

		//Check to see if the array is null
		//If null, display a message and set status to false.
		if(numbers == null)
		{
			JOptionPane.showMessageDialog(null, "No further processing");
			status = false;
		}

		//If not null, set status to true.
		else
		{
			status = true;
		}

		return status;
	}

	/**
		The getNewArray method creates a new array filled with random numbers.
	*/
   public void getNewArray()
   {
		int arraySize;		//The size of the array
		String input;		//User input for arraySize

		//Get the size of the array from the user
		input = JOptionPane.showInputDialog("How many numbers would "
														+ "you like me to generate?");
		arraySize = Integer.parseInt(input);

		//If the user enters anything less than one.  Display message
		if(arraySize < 1)
		{
			JOptionPane.showMessageDialog(null, "No further processing");
		}

		//Create the array filled with random numbers.
		else
		{
			numbers = new int[arraySize];
			for(int index=0; index < numbers.length; index++)
			{
				numbers[index] = randomNumbers.nextInt(99)+1;
			}
			messageTxtField.setText("NEW ARRAY: SIZE = " + arraySize);
		}
	}

	/**
		The displayNumbers method displays the numbers in the array.
	*/
   public void displayNumbers()
   {
		//Send a message to the text field.
		messageTxtField.setText("ARRAY DISPLAYED");

		//Get the string getArrayList
		//and display the numbers in the array in a message dialog.
		JOptionPane.showMessageDialog(null, getArrayList(numbers));
	}

	/**
		The bubbleSortArray sorts the numbers of the array in ascending order.
	*/
	public void bubbleSortArray()
	{
		boolean swap; 						//True if swaps were made in this iteration.
		int temp;							//used to swap the array.
		int last = numbers.length - 1; // controls number of iterations.

		do
		{
			swap = false; //Presume no swaps are made

			//Loop from beginning to last place necessary.
			for(int count = 0; count < last; count++)
			{
				//Do an ascending order sort.
				if(numbers[count] > numbers[count+1])
				{
					//swap elements and set swap to true.
					temp = numbers[count];
					numbers[count] = numbers[count + 1];
					numbers[count+1] = temp;
					swap = true;
				}
			}
			last--; //next iteration will stop one element sooner.
		}while(swap);

		messageTxtField.setText("ARRAY IS SORTED");
	}

	/**
		The getAverage method calculates the average of the array, and
		displays the value in the message text field.
	*/
	public void getAverage()
	{
		int total = 0;	// Initialize accumulator
		double average;	// Will hold the average

		//Add all of the numbers in the array together.
		for(int index = 0; index < numbers.length; index++)
		{
			total += numbers[index];
		}

		//Divide the total by the number of elements in the array.
		average = (double)total/numbers.length;

		//Display the average in the message text field
		messageTxtField.setText("AVERAGE = " + numberFormat.format(average));

	}

	/**
		The getMaximum method finds the highest number in the array,
		and displays it in the message text field.
	*/
	public void getMaximum()
	{
		int maximum; 				//To hold the highest number in the array.
		maximum = numbers[0]; 	//Get the first number in the array

		//Step through the rest of the array
		//when a number greater than maximum is found
		//assign it to maximum.
		for(int index = 1; index < numbers.length; index++)
		{
			if(numbers[index] > maximum)
			{
				maximum = numbers[index];
			}
		}

		//Display the maximum in the message text field
		messageTxtField.setText("MAX = " + maximum);

	}

	/**
		The getMinimum method finds the lowest number in the array,
		and displays it in the message text field.
	*/
	public void getMinimum()
	{

		int minimum; 				//To hold the lowest number in the array.
		minimum = numbers[0];	//Get the first number in the array.

		//Step through the rest of the array
		//when a number less than minimum is found
		//assign it to minimum.
		for(int index = 1; index < numbers.length; index++)
		{
			if(numbers[index] < minimum)
			{
				minimum = numbers[index];
			}
		}
		messageTxtField.setText("MIN = " + minimum);
	}

	/**
		The getArrayList gets the numbers in the array
		@param array An array of numbers.
		@return The formatted list of numbers in the array
	*/
	public String getArrayList(int [] array)
	{
		int count = 0;			//used to format the spacing.
		String arrayString;  //The String to be returned

		//Initialize the string.
		arrayString = "ARRAY CONTAINS:\n";

		//Add the numbers in the array to the string.
		for(int index = 0; index < array.length; index++)
		{

			//Go to the next line after ten numbers have been added
			//Add spaces to line up the numbers.
			if(count < 10)
			{
				if(array[index] < 10)
				{
					arrayString += "   " + array[index] + "  ";
				}

				else if(array[index] < 100)
				{
					arrayString += " " + array[index] + "  ";
				}

				else
				{
					arrayString += array[index] + "  ";
				}
				count++;
			}

			else
			{
				if(array[index] < 10)
				{
					arrayString += "\n   " + array[index] + "   ";
				}

				else if(array[index] < 100)
				{
					arrayString += "\n " + array[index] + "  ";
				}

				else
				{
					arrayString += "\n" + array[index] + "   ";
				}
				count = 1;
			}

		}

		return arrayString;
	}


   /**
	   This method creates an instance of the ProcessArrayGUI class
	   which displays the GUI for the Process Array application.
	*/

	public static void main(String[] args)
	{
		ProcessArrayGUI processArray = new ProcessArrayGUI();
	}

}