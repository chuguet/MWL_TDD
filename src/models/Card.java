package models;

public class Card {
	
	private int number;
	private CardSuit suit;

	public Card(CardSuit hearts, int i, boolean covered) {
		this.number = i;
		this.suit = hearts;
	}

	public boolean uncovered() {
		return true;
	}

	public CardSuit getSuit() {
		return this.suit;
	}

	public int getNumber() {
		return this.number;
	}

}
