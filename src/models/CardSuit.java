package models;

import java.awt.Color;

public enum CardSuit {

	HEARTS(Color.RED), DIAMONDS(Color.RED), CLUBS(Color.BLACK), SPADES(
			Color.BLACK);

	Color color;

	CardSuit(Color color) {
		this.color = color;
	}

	public boolean isAlternativeColor(CardSuit suit) {
		return this.color != suit.color;
	}
}
