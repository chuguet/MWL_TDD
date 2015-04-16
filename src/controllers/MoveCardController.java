package controllers;

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
			WasteCardStack targetCardStack) {
		
	}
}
