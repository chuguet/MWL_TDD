package models;

public class DeckCardStack extends CardStack {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean pushAllowed(Card card) {
		return false;
	}

}
