package Ch18;

// Recursive factorial
public class FactorialCalculator {
	
	public static void main(String[] args) {
		// calculate the factorial of 0 through 21
		for(int counter = 0; counter <=21; counter ++) {
			System.out.printf("%d! = %d%n", counter, factorial(counter));
		}
	}
	
	// recursive method factorial (assumes its parameter is >= 0)
	public static long factorial(long number) {
		if(number <=1) {	// test for base case
			return 1;	// base case: 0! = 1 and 1! = 1
		}
		else	// recursion step
			return number * factorial(number-1);
	}
}
