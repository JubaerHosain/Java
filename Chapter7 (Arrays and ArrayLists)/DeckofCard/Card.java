package Chapter7.DeckofCard;

public class Card {
	// face of card ("Ace", Duce", ...)
	private final String face;
	// suit of card ("Hearts", "Diamonds", ...)
	private final String suit;
	
	
	// tow-arug constructorinitializes card's face and suit
	public Card(String cardFace, String cardSuit) {
		this.face = cardFace;
		this.suit = cardSuit;
	}
	
	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}
	
	
}
