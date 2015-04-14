package controllers;

import exceptions.NotAllowedMoveException;
import models.Card;
import models.FoundationCardStack;
import models.TableauCardStack;
import models.WasteCardStack;

public class MoveCardController {

	public void move(WasteCardStack originMoveStack,
			FoundationCardStack targetMoveStack) throws NotAllowedMoveException {
		if (targetMoveStack.size() > 0) {
			if ((originMoveStack.peek().getSuit() == targetMoveStack.peek()
					.getSuit())
					&& (originMoveStack.peek().getNumber() == targetMoveStack
							.peek().getNumber() + 1)) {
				Card cardToMove = originMoveStack.pop();
				targetMoveStack.push(cardToMove);
			} else {
				throw new NotAllowedMoveException();
			}
		} else if (originMoveStack.peek().getNumber() == 1) {
			Card cardToMove = originMoveStack.pop();
			targetMoveStack.push(cardToMove);
		} else {
			throw new NotAllowedMoveException();
		}
	}

	public void move(WasteCardStack wasteGameStackMock,
			TableauCardStack foundationTargetStack)
			throws NotAllowedMoveException {
		if (foundationTargetStack.isEmpty()) {
			if (wasteGameStackMock.peek().getNumber() == 13) {
				Card cardToMove = wasteGameStackMock.pop();
				foundationTargetStack.push(cardToMove);
			} else {
				throw new NotAllowedMoveException();
			}
		} else if (wasteGameStackMock.peek().getSuit()
				.isAlternativeColor(foundationTargetStack.peek().getSuit())
				&& (wasteGameStackMock.peek().getNumber() == foundationTargetStack
						.peek().getNumber() - 1)) {
			Card cardToMove = wasteGameStackMock.pop();
			foundationTargetStack.push(cardToMove);
		} else {
			throw new NotAllowedMoveException();
		}

	}
}
