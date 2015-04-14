package controllers;

import java.util.ArrayList;
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
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
