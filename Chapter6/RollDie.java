package Chapter6;

import java.security.SecureRandom;

public class RollDie {

	public static void main(String[] args) {
		SecureRandom randomNumbers = new SecureRandom();
		
		int f1 = 0;
		int f2 = 0;
		int f3 = 0;
		int f4 = 0;
		int f5 = 0;
		int f6 = 0;
		
		for(int roll = 1; roll <= 60_000_000; roll++) {
			int face = 1 + randomNumbers.nextInt(6);
			
			switch(face) {
			case 1:
				++f1;
				break;
			case 2:
				++f2;
				break;
			case 3:
				++f3;
				break;
			case 4:
				++f4;
				break;
			case 5:
				++f5;
				break;
			case 6:
				++f6;
				break;
			}
		}
		
		System.out.println("Face\tFrequence");
		System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n", f1, f2, f3, f4, f5, f6);
	}

}
