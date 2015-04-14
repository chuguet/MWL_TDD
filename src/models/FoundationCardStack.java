package models;

public class FoundationCardStack extends CardStack {

	private static final long serialVersionUID = 1L;

	public boolean pushAllowed(Card card) {

		if (this.isEmpty() && card.getNumber() == 1) {
			return true;
		}
		if (!this.isEmpty() && card.getNumber() == this.peek().getNumber() + 1
				&& card.getSuit().equals(this.peek().getSuit())) {
			return true;
		}
		return false;
	}

}
