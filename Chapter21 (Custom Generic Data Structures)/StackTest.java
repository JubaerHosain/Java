import java.util.NoSuchElementException;

// Stack manipulation program
public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		// use push method 
		stack.push(-1);
		stack.print();
		stack.push(0);
		stack.print();
		stack.push(1);
		stack.print();
		stack.push(5);
		stack.print();
		
		// remove items from stack
		boolean continueLoop = true;
		
		while(continueLoop) {
			try {
				int removedItem = stack.pop(); // remove top element
				System.out.printf("%n%d popped%n", removedItem);
				stack.print();
			}
			catch (NoSuchElementException noSuchElementException) {
				continueLoop = false;
				noSuchElementException.printStackTrace();
			}
		}
	}

}
