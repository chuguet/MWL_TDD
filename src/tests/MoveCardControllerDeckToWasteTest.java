package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import models.Card;
import models.CardSuit;
import models.DeckCardStack;
import models.WasteCardStack;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveCardController;
import exceptions.NotAllowedMoveException;

public class MoveCardControllerDeckToWasteTest {

	private MoveCardController moveCardController;
	private WasteCardStack wasteCardStack;
	private DeckCardStack deckCardStackMock;

	@Before
	public void before() {
		moveCardController = new MoveCardController();
		wasteCardStack = new WasteCardStack();
		deckCardStackMock = new DeckCardStack();
	}

	@Test
	public void moveCardFromDeckToWasteTest_hashThreeCards() throws NotAllowedMoveException {

		Card card1 = new Card(CardSuit.DIAMONDS, 6, false);
		Card card2 = new Card(CardSuit.SPADES, 11, false);
		Card card3 = new Card(CardSuit.SPADES, 5, false);
		deckCardStackMock.push(card1);
		deckCardStackMock.push(card2);
		deckCardStackMock.push(card3);

		int initialOriginStackSize = deckCardStackMock.size();
		int initialTargetStackSize = wasteCardStack.size();

		moveCardController.moveMulti(deckCardStackMock, wasteCardStack);

		assertEquals(initialOriginStackSize - 3, wasteCardStack.size());
		assertEquals(initialTargetStackSize + 3, wasteCardStack.size());

		Card fromWasteCard1 = wasteCardStack.pop();
		Card fromWasteCard2 = wasteCardStack.pop();
		Card fromWasteCard3 = wasteCardStack.pop();

		assertEquals(card1.getSuit(), fromWasteCard1.getSuit());
		assertEquals(card1.getNumber(), fromWasteCard1.getNumber());
		assertTrue(fromWasteCard1.uncovered());

		assertEquals(card2.getSuit(), fromWasteCard2.getSuit());
		assertEquals(card2.getNumber(), fromWasteCard2.getNumber());
		assertTrue(fromWasteCard2.uncovered());

		assertEquals(card3.getSuit(), fromWasteCard3.getSuit());
		assertEquals(card3.getNumber(), fromWasteCard3.getNumber());
		assertTrue(fromWasteCard3.uncovered());
	}

	@Test
	public void moveCardFromDeckToWasteTest_LessThanThreeCards() throws NotAllowedMoveException {
		Card card1 = new Card(CardSuit.DIAMONDS, 6, false);

		deckCardStackMock.push(card1);

		int initialOriginStackSize = deckCardStackMock.size();
		int initialTargetStackSize = wasteCardStack.size();

		moveCardController.moveMulti(deckCardStackMock, wasteCardStack);

		assertEquals(initialOriginStackSize - 1, wasteCardStack.size());
		assertEquals(initialTargetStackSize + 1, wasteCardStack.size());

		Card fromWasteCard1 = wasteCardStack.pop();

		assertEquals(card1.getSuit(), fromWasteCard1.getSuit());
		assertEquals(card1.getNumber(), fromWasteCard1.getNumber());
		assertTrue(fromWasteCard1.uncovered());

	}

	@Test(expected = NotAllowedMoveException.class)
	public void moveCardFromDeckToWasteTest_notAllowed_NoCards()throws NotAllowedMoveException {
		moveCardController.moveMulti(deckCardStackMock, wasteCardStack);
	}

}
