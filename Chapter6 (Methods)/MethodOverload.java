package Chapter6;

public class MethodOverload {

	public static void main(String[] args) {
		// Test overloaded square methods
		System.out.println("Square of integer 7 is " + square(7));
		System.out.println("Square of integer 7.5 is " + square(7.5));
		
	}
	
	// square method with integer argument
	public static int square(int value) {
		System.out.println("Called square with int argument " + value);
		return value * value;
	}
	
	// square method with double argument
	public static double square(double value) {
		System.out.println("Called square with double argument " + value);
		return value * value;
	}
}
