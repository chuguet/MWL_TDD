package controllers;

import models.Card;
import models.CardStack;
import models.DeckCardStack;
import models.WasteCardStack;
import exceptions.NotAllowedMoveException;

public class MoveCardController {

	public void move(CardStack originCardStack, CardStack targetCardStack)
			throws NotAllowedMoveException {
		if (targetCardStack.pushAllowed(originCardStack.peek())) {
			targetCardStack.push(originCardStack.pop());
		} else {
			throw new NotAllowedMoveException();
		}
	}

	public void moveMulti(DeckCardStack originCardStack,
			WasteCardStack targetCardStack) throws NotAllowedMoveException {
		if (originCardStack.isEmpty()) {
			throw new NotAllowedMoveException();
		} else {
			int cardsNumberToMove = 3;
			while (cardsNumberToMove > 0 && !originCardStack.isEmpty()) {
				Card cardToMove = originCardStack.pop();
				cardToMove.setUncovered(true);
				targetCardStack.push(cardToMove);
				cardsNumberToMove--;
			}
		}
	}
}
