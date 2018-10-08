package Chapter7.DeckofCard;

public class DeckOfCardTest {

	public static void main(String[] args) {
		// execute application
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		
		// print all 52 Cards in the order in which they are dealt
		for (int i=1; i<52; i++) {
			//deal and display a Card
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			// output a newline after every fourth card
			if(i%4 == 0) {
				System.out.println();
			}
		}
	}

}
