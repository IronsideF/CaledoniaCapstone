package com.capstone.caledonia.player;

import com.capstone.caledonia.card.ICard;

import java.util.ArrayList;

public class Hand {

    private ArrayList<ICard> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public ArrayList<ICard> getHand() {
        return hand;
    }

    public void addCard(ICard card) {
        if (this.hand.size() <= 7 ) {
            this.hand.add(card);
        }
    }

    public void removeCard(int index) {
            this.hand.remove(index);
    }

    public void clearHand() {
        this.hand.clear();
    }

    public void drawHand(Deck deck) {
        for (int i = 0; i < 7; i ++) {
            if (this.hand.size() < 7) {
                this.hand.add(deck.drawCard());
            }
        }
    }
}
