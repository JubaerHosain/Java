package Chapter6;

public class Scope {
	// field that is accessible to all methods of this class
	private static int x = 1;

	// method main creates and initializes local variable x
	// and calls methods useLocalVariable and useField
	public static void main(String[] args) {
		// method's local variable x shadows field x
		int x = 5;
		System.out.println("local x in main is " + x);
		
		// local x
		useLocalVariable();
		// scope x
		useField();
		// reinitializes local x
		useLocalVariable();
		// scope x retains its value
		useField();
	}
	
	// create and initialize local variable x during each call
	public static void useLocalVariable() {
		int x = 25;
		
		System.out.println("local x on entering mehtod usLocalVariable is " + x);
		
		// modifies this method's local variable x 
		++x;
		
		System.out.println("local x before exiting method useLocalVariable is " + x);
	}
	
	public static void useField() {
		System.out.println("Field x on entering method useField is " + x);
		
		// modifies class Scope field x
		x *= 10;
		
		System.out.println("Field x before exiting method useField is " + x);
	}

}
