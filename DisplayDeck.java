import java.util.*;


public class DisplayDeck {
	public static void main (String[] args){	
		Deck myDeck = new Deck();
       for (int suit = PlayingCard.DIAMONDS; suit <= PlayingCard.SPADES; suit++) {
            for (int face = PlayingCard.ACE; face <= PlayingCard.KING; face++) {
                PlayingCard card = myDeck.getCard(suit, face);
                System.out.format("%s of %s%n",
                    card.faceToString(card.returnFace()),
                    card.suitToString(card.returnSuit()));
				}
            }
        }
}