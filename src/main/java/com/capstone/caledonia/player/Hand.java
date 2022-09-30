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

    public void drawToHand(Deck deck) {
            if (this.hand.size() <=7) {
                this.hand.add(deck.drawCard());
            }
        }
}
