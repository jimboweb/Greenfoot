import java.util.*;


public class PlayingCard {
	private final int face;
	private final int suit;
	
	//Kinds of suits
	public static final int DIAMONDS = 1;
	public static final int CLUBS = 2;
	public static final int HEARTS = 3;
	public static final int SPADES = 4;
	
	//kinds of faces
	public static final int ACE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public PlayingCard(int suit, int face){
		assert isValidFace(face);
		assert isValidSuit(suit);
		this.suit = suit;
		this.face = face;
	}
	
	public int returnFace() {
		return this.face;
	}
	
	public int returnSuit(){
		return this.suit;
	}
	
	private boolean isValidFace(int face){
		return ACE <= face && face <=KING;
	}
	
	private boolean isValidSuit(int suit){
		//return true;
		return DIAMONDS<=suit && suit <=SPADES;
	}
	
	public static String suitToString(int suit){
		switch(suit){
			case DIAMONDS:
				return "Diamonds";
			case CLUBS:
				return "Clubs";
			case HEARTS:
				return "Hearts";
			case SPADES:
				return "Spades";
			default:
				return null;
		}
	}
	public static String faceToString(int suit){
		switch(suit){
			case ACE:
				return "Ace";
			case TWO:
				return "Two";
			case THREE:
				return "Three";
			case FOUR:
				return "Four";
			case FIVE:
				return "Five";
			case SIX:
				return "Six";
			case SEVEN:
				return "Seven";
			case EIGHT:
				return "Eight";
			case NINE:
				return "Nine";
			case TEN:
				return "Ten";
			case JACK:
				return "Jack";
			case QUEEN:
				return "Queen";
			case KING:
				return "King";
			default:
				return null;
		}
		
	}
	public static void main (String[] args) {
		assert faceToString(ACE) == "Ace";
		assert faceToString(TWO) == "Two";
		assert faceToString(THREE) == "Three";
		assert faceToString(FOUR) == "Four";
		assert faceToString(FIVE) == "Five";
		assert faceToString(SIX) == "Six";
		assert faceToString(SEVEN) == "Seven";
		assert faceToString(EIGHT) == "Eight";
		assert faceToString(NINE) == "Nine";
		assert faceToString(TEN) == "Ten";
		assert faceToString(JACK) == "Jack";
		assert faceToString(QUEEN) == "Queen";
		assert faceToString(KING) == "King";
	
		assert suitToString(DIAMONDS) == "Diamonds";
		assert suitToString(CLUBS) == "Clubs";
		assert suitToString(HEARTS) == "Hearts";
		assert suitToString(SPADES) == "Spades";
	}

}