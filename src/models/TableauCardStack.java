package models;

public class TableauCardStack extends CardStack {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean pushAllowed(Card card) {

		if (this.isEmpty() && card.getNumber() == 13) {
			return true;
		}
		if (!this.isEmpty()
				&& card.getSuit().isAlternativeColor(this.peek().getSuit())
				&& card.getNumber() == this.peek().getNumber() - 1) {
			return true;
		}

		return false;
	}
}
