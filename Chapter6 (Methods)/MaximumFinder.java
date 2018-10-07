package Chapter6;

import java.util.Scanner;

public class MaximumFinder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three floating-point values separated by spaces: ");
		double n1 = input.nextDouble();
		double n2 = input.nextDouble();
		double n3 = input.nextDouble();
		
		double result = max(n1, n2, n3);
		
		System.out.println("Maximum is: " + result);
	}

	public static double max(double x, double y, double z) {
		double maxValue = x;
		
		if(y > maxValue) {
			maxValue = y;
		}
		
		if (z > maxValue) {
			maxValue = z;
		}
		
		return maxValue;
	}
}
