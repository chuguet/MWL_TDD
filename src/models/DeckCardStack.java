package models;

public class DeckCardStack extends CardStack{

	@Override
	public boolean pushAllowed(Card card) {
		return false;
	}

}
