import java.util.*;

public class Deck {
	public static int numSuits = 4;
	public static int numFaces = 13;
	public static int numCards = numSuits * numFaces;
	
	private PlayingCard[][] cards;
	
	public Deck() {
		cards = new PlayingCard[numSuits][numFaces];
		for (int suit = PlayingCard.DIAMONDS; suit<=PlayingCard.SPADES; suit++){
			for(int face = PlayingCard.ACE; face<=PlayingCard.KING; face++){
				cards[suit-1][face-1] = new PlayingCard (suit, face);
			}
		}
		
	}
	public PlayingCard getCard(int suit, int face){
		return cards[suit-1][face-1];
	}

}