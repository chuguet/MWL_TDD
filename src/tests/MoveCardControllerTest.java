package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import models.Card;
import models.CardSuit;
import models.FoundationCardStack;
import models.TableauCardStack;
import models.WasteCardStack;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveCardController;
import exceptions.NotAllowedMoveException;

public class MoveCardControllerTest {

	private MoveCardController moveCardController;
	private WasteCardStack wasteGameStackMock;
	private List<FoundationCardStack> foundationsListMock;
	private List<TableauCardStack> TableauListMock;

	@Before
	public void before() {
		moveCardController = new MoveCardController();
		wasteGameStackMock = new WasteCardStack();
		foundationsListMock = new ArrayList<FoundationCardStack>(4);

		foundationsListMock.add(new FoundationCardStack());
		foundationsListMock.add(new FoundationCardStack());
		foundationsListMock.add(new FoundationCardStack());
		foundationsListMock.add(new FoundationCardStack());
		
		TableauListMock = new ArrayList<TableauCardStack>(7);

		TableauListMock.add(new TableauCardStack());
		TableauListMock.add(new TableauCardStack());
		TableauListMock.add(new TableauCardStack());
		TableauListMock.add(new TableauCardStack());
		TableauListMock.add(new TableauCardStack());
		TableauListMock.add(new TableauCardStack());
		TableauListMock.add(new TableauCardStack());
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
	
	@Test
	public void moveCardFromWasteToTableausTest()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 2, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		TableauCardStack tableauTargetStack = TableauListMock.get(0);
		tableauTargetStack.push(new Card(CardSuit.CLUBS, 3, true));

		int initialOriginStackSize = wasteGameStackMock.size();
		int initialTargetStackSize = tableauTargetStack.size();

		moveCardController.move(wasteGameStackMock, tableauTargetStack);

		assertEquals(initialOriginStackSize - 1, wasteGameStackMock.size());
		assertEquals(initialTargetStackSize + 1, tableauTargetStack.size());
		assertEquals(cardToMove.getSuit(), tableauTargetStack.peek()
				.getSuit());
		assertEquals(cardToMove.getNumber(), tableauTargetStack.peek()
				.getNumber());
	}

	@Test
	public void moveCardFromWasteToTableausTest_KingCard()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 13, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		TableauCardStack tableauTargetStack = TableauListMock.get(0);

		int initialOriginStackSize = wasteGameStackMock.size();
		int initialTargetStackSize = tableauTargetStack.size();

		moveCardController.move(wasteGameStackMock, tableauTargetStack);

		assertEquals(initialOriginStackSize - 1, wasteGameStackMock.size());
		assertEquals(initialTargetStackSize + 1, tableauTargetStack.size());
		assertEquals(cardToMove.getSuit(), tableauTargetStack.peek()
				.getSuit());
		assertEquals(cardToMove.getNumber(), tableauTargetStack.peek()
				.getNumber());
	}

	@Test(expected = NotAllowedMoveException.class)
	public void moveCardFromWasteToTableausTest_notAllowed_notAlternativeColor()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 2, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		TableauCardStack tableauTargetStack = TableauListMock.get(0);
		tableauTargetStack.push(new Card(CardSuit.DIAMONDS, 3, true));

		moveCardController.move(wasteGameStackMock, tableauTargetStack);

	}

	@Test(expected = NotAllowedMoveException.class)
	public void moveCardFromWasteToTableausTest_notAllowed_nonConsecutiveCard()
			throws NotAllowedMoveException {

		Card cardToMove = new Card(CardSuit.HEARTS, 2, true);

		wasteGameStackMock.push(new Card(CardSuit.DIAMONDS, 6, true));
		wasteGameStackMock.push(new Card(CardSuit.SPADES, 11, true));
		wasteGameStackMock.push(cardToMove);

		TableauCardStack tableauTargetStack = TableauListMock.get(0);
		tableauTargetStack.push(new Card(CardSuit.CLUBS, 4, true));

		moveCardController.move(wasteGameStackMock, tableauTargetStack);

	}

}
