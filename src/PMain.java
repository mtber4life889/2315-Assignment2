import java.util.Scanner;
import java.util.regex.Pattern;

public class PMain {

	public static void main(String[] args) {
		
		String userInput = null;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		BagInterface<Variable> varBag = new ArrayBag<>();
		
		while (userInput != "quit")
		{
			System.out.println("Please either enter an infix expression to be evaluated");
			System.out.println("or define a variable to be used with the format of:  define  variable name  integer value");
			System.out.println("or type quit to exit the program.");
			System.out.println("\n" + "Input: ");
			userInput = input.nextLine();
			
			Pattern pattern = Pattern.compile("define ");
			if(pattern.matcher(userInput).find())
			{
				String [] parts = userInput.split(" ");
				String varName = parts[1];
				String varStringValue = parts[2];
				int varIntValue = Integer.parseInt(varStringValue);
				Variable newVar = new Variable(varName, varIntValue);
				varBag.add(newVar);
				System.out.println(newVar.getName() + " = " + newVar.getValue()+ "\n");
			}
			else
			{
				String[] parts = userInput.split(" ");
				int[] intParts = new int[parts.length];
				
				for(int i = 0; i < parts.length; i++)
				{
					intParts[i] = Integer.parseInt(parts[i]);
				}
				
				String output;
				PostToInfix theTrans = new PostToInfix(userInput);
				output = theTrans.doTrans();
				System.out.println("postfix: " + output);
			}
			
		}
		

	}
	/*private static String menu()
	{
		String selection;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please either enter an infix expression to be evaluated ");
		System.out.println("or define a variable to be used with the format of:  define  variable name  integer value");
		System.out.println("2) Remove a Baseball Card and duplicates if specified." + "\n");
        System.out.println("3) Find the total value of a Baseball card including duplicates." + "\n");
		System.out.println("4) Change the price of a Baseball Card." + "\n");
	    System.out.println("5) Find all cards in the bag and how many duplicates you have." + "\n");
		System.out.println("Please Input the number for the option you wish to use: ");
		   
		selection = input.nextLine();
		return selection;
	}*/

}
