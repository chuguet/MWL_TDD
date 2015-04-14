package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import models.Card;
import models.CardSuit;
import models.FoundationCardStack;
import models.WasteCardStack;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveCardController;
import exceptions.NotAllowedMoveException;

public class MoveCardControllerTest {

	private MoveCardController moveCardController;
	private WasteCardStack wasteGameStackMock;
	private List<FoundationCardStack> foundationsListMock;

	@Before
	public void before() {
		moveCardController = new MoveCardController();
		wasteGameStackMock = new WasteCardStack();
		foundationsListMock = new ArrayList<FoundationCardStack>(4);

		foundationsListMock.add(new FoundationCardStack());
		foundationsListMock.add(new FoundationCardStack());
		foundationsListMock.add(new FoundationCardStack());
		foundationsListMock.add(new FoundationCardStack());
	}

	@Test
	public void moveCardFromWasteToFoundationsTest()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 2, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		FoundationCardStack foundationTargetStack = foundationsListMock.get(0);
		foundationTargetStack.push(new Card(CardSuit.HEARTS, 1, true));

		int initialOriginStackSize = wasteGameStackMock.size();
		int initialTargetStackSize = foundationTargetStack.size();

		moveCardController.move(wasteGameStackMock, foundationTargetStack);

		assertEquals(initialOriginStackSize - 1, wasteGameStackMock.size());
		assertEquals(initialTargetStackSize + 1, foundationTargetStack.size());
		assertEquals(cardToMove.getSuit(), foundationTargetStack.peek()
				.getSuit());
		assertEquals(cardToMove.getNumber(), foundationTargetStack.peek()
				.getNumber());
	}

	@Test
	public void moveCardFromWasteToFoundationsTest_AceCard()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 1, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		FoundationCardStack foundationTargetStack = foundationsListMock.get(0);

		int initialOriginStackSize = wasteGameStackMock.size();
		int initialTargetStackSize = foundationTargetStack.size();

		moveCardController.move(wasteGameStackMock, foundationTargetStack);

		assertEquals(initialOriginStackSize - 1, wasteGameStackMock.size());
		assertEquals(initialTargetStackSize + 1, foundationTargetStack.size());
		assertEquals(cardToMove.getSuit(), foundationTargetStack.peek()
				.getSuit());
		assertEquals(cardToMove.getNumber(), foundationTargetStack.peek()
				.getNumber());
	}

	@Test(expected = NotAllowedMoveException.class)
	public void moveCardFromWasteToFoundationsTest_notAllowed_notEqualSuit()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 2, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		FoundationCardStack foundationTargetStack = foundationsListMock.get(0);
		foundationTargetStack.push(new Card(CardSuit.DIAMONDS, 1, true));

		moveCardController.move(wasteGameStackMock, foundationTargetStack);

	}

	@Test(expected = NotAllowedMoveException.class)
	public void moveCardFromWasteToFoundationsTest_notAllowed_nonConsecutiveCard()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 3, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		FoundationCardStack foundationTargetStack = foundationsListMock.get(0);
		foundationTargetStack.push(new Card(CardSuit.HEARTS, 1, true));

		moveCardController.move(wasteGameStackMock, foundationTargetStack);

	}

}
