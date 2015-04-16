package models;

public class Card {
	
	private int number;
	private CardSuit suit;
	private boolean uncovered;

	public Card(CardSuit hearts, int i, boolean uncovered) {
		this.number = i;
		this.suit = hearts;
		this.uncovered = uncovered;
	}
	
	public void setUncovered (boolean uncovered){
		this.uncovered = uncovered;
	}

	public boolean uncovered() {
		return uncovered;
	}

	public CardSuit getSuit() {
		return this.suit;
	}

	public int getNumber() {
		return this.number;
	}

}
