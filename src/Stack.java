/* Programmer: Curtis Chippeway
 * The purpose of this class is to be able to create full functioning stacks from it
 * The Stack class was taken from
 * http://www.tutorialspoint.com/javaexamples/data_intopost.htm
 */
public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;
    public Stack(int max) {
       maxSize = max;
       stackArray = new char[maxSize];
       top = -1;
    }
    public void push(char j) {
       stackArray[++top] = j;
    }
    public char pop() {
       return stackArray[top--];
    }
    public char peek() {
       return stackArray[top];
    }
    public boolean isEmpty() {
       return (top == -1);
   }
}