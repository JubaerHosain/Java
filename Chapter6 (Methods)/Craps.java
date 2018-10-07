package Chapter6;

import java.security.SecureRandom;

public class Craps {
	// Create secure random number generator for use in method rollDice
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	// enum type with constants that represent the game status
	private enum Status {CONTINUE, WON, LOST};
	
	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	// plays the game of craps
	public static void main(String[] args) {
		int myPoint = 0;
		Status gameStatus;
		
		int sumOfDice = rollDice();
		switch (sumOfDice) {
			// win with 7 on first roll
			case SEVEN:
			// win with 11 on first roll
			case YO_LEVEN:
				gameStatus = Status.WON;
				break;
			// lost with 2 on first roll
			case SNAKE_EYES: 
			// lose with 3 on first roll
			case TREY: 
			// lose with 12 on first roll
			case BOX_CARS:
				gameStatus = Status.LOST;
				break;
			// did not win or lose so remember
			default:
				gameStatus = Status.CONTINUE;
				// remember the point
				myPoint = sumOfDice;
				System.out.printf("Point is %d%n", myPoint);
				break;
		}
		
		// while game is not complete
		while (gameStatus == Status.CONTINUE) { // not WON or LOST
			// roll dice again
			sumOfDice = rollDice();
			
			//determine game status
			if(sumOfDice == myPoint) {
				// win by making point
				gameStatus = Status.WON;
			}
			else {
				// lost by rolling 7 before point
				if(sumOfDice == SEVEN) {
					gameStatus = Status.LOST;
				}
			}
		}
		
		// Display won or lost message
		if(gameStatus == Status.WON) {
			System.out.println("Player wins");
		}
		else 
			System.out.println("Player loses");
	}
	
	// roll dice, calculate sum and display results
	public static int rollDice() {
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // First die roll
		int die2 = 1 + randomNumbers.nextInt(6); // Second die roll
		
		// Sum of the die values
		int sum = die1 + die2; 
		
		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
		
		return sum;
	}

}
