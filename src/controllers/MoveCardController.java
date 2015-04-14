package controllers;

import models.CardStack;
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
}
