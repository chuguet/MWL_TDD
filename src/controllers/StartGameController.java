package controllers;

import java.util.ArrayList;
import java.util.Stack;

import models.Card;
import models.CardStack;
import models.CardSuit;
import models.DeckCardStack;
import models.FoundationCardStack;
import models.TableauCardStack;
import models.WasteCardStack;

public class StartGameController {

	private static final int FOUNDATIONS = 4;
	private static final int TABLEAUS = 7;

	private ArrayList<CardStack> foundationsList;
	private ArrayList<CardStack> tableausList;
	private CardStack deck;
	private CardStack waste;

	public StartGameController() {
		deck = new DeckCardStack();
		initDeck();
		waste = new WasteCardStack();

		tableausList = new ArrayList<CardStack>(TABLEAUS);
		foundationsList = new ArrayList<CardStack>(FOUNDATIONS);

		for (int i = 0; i < TABLEAUS; i++) {
			tableausList.add(initTableau(i));
		}

		for (int j = 0; j < FOUNDATIONS; j++) {
			foundationsList.add(new FoundationCardStack());
		}
	}

	public int sizeWaste() {
		return waste.size();
	}

	public int sizeDeck() {
		return deck.size();
	}

	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for (int i = 0; i < FOUNDATIONS; i++) {
			sizeFoundations.add(foundationsList.get(i).size());
		}

		return sizeFoundations;
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> tableaus = new ArrayList<Integer>();

		for (CardStack tableau : tableausList) {
			tableaus.add(tableau.size());
		}

		return tableaus;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
		ArrayList<Stack<Card>> uncoveredTableaus = new ArrayList<Stack<Card>>();
		for (CardStack tableau : tableausList) {
			Stack<Card> tableauUncovered = new Stack<Card>();
			tableauUncovered.add(tableau.peek());
			uncoveredTableaus.add(tableauUncovered);
		}

		return uncoveredTableaus;
	}

	private void initDeck() {
		ArrayList<Card> temporalDeck = new ArrayList<Card>();
		for (CardSuit suit : CardSuit.values()) {
			for (int i = 1; i <= 13; i++) {
				temporalDeck.add(new Card(suit, i, false));
			}
		}
		while (!temporalDeck.isEmpty()) {
			int randomIndex = (int) (Math.random() * (temporalDeck.size() - 1));
			deck.push(temporalDeck.get(randomIndex));
			temporalDeck.remove(randomIndex);
		}
	}

	private CardStack initTableau(int order) {
		CardStack tableau = new TableauCardStack();
		for (int i = 0; i <= order; i++) {
			Card card = deck.pop();
			if (i == order) {
				card.setUncovered(true);
			}
			tableau.push(card);
		}
		return tableau;
	}

}
