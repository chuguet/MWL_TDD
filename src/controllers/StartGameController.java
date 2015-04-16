package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import models.Card;

public class StartGameController {
    public int sizeWaste() {
        // TODO Auto-generated method stub
        return 0;
    }

    public ArrayList<Integer> sizeFoundations() {
        ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            sizeFoundations.add(0);
        }

        return sizeFoundations;
    }

    public int sizeDeck() {
        return 24;
    }

    public ArrayList<Integer> sizeCoveredCardsTableaus() {
    	ArrayList <Integer> tableaus = new ArrayList<Integer> ();
    	for(int i = 0; i<7;i++){
    		tableaus.add(new Integer(i+1));
    	}
        return tableaus;
    }

    public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
    	ArrayList <Stack<Card>> uncoveredTableaus = new ArrayList<Stack<Card>> ();
    	for(int i = 0; i<7;i++){
    		Stack<Card> tableauUncovered = new Stack<Card>();
    		Card uncoveredCard = new Card();
    		uncoveredCard.setUncovered(true);
    		tableauUncovered.add(uncoveredCard);
    		uncoveredTableaus.add(tableauUncovered);
    	}
        return uncoveredTableaus;
    }
    
    
}
