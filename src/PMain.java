/* Programmer: Curtis Chippeway
 * The purpose of this class is to run the Main program.
 * The sources used were the class notes from Kenward Chin and 
 * http://www.tutorialspoint.com/java/java_string_split.htm
 * http://stackoverflow.com/questions/11171445/how-matcher-find-works
 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class PMain {

	public static void main(String[] args) {
		
		String userInput = "";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		BagInterface<Variable> varBag = new ArrayBag<>();
		
		while (!userInput.equals("quit"))
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
				String output;
				PostToInfix theTrans = new PostToInfix(userInput);
				output = theTrans.doTrans();
				System.out.println("In postfix notation this is: " + output + "\n");
			}
			
		}
		

	}
}
