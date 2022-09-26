package com.capstone.caledonia.player;

import com.capstone.caledonia.card.ICard;

import java.util.ArrayList;

public class Discard {
    private ArrayList<ICard> discard;

    public Discard() {
        this.discard = new ArrayList<>();
    }

    public ArrayList<ICard> getDiscard() {
        return discard;
    }

    public void addCard(ICard card) {
        this.discard.add(card);
    }

    public void emptyDiscard() {
        this.discard.clear();
    }

    public void emptyDiscard(Deck deck) {
        deck.setDeck(this.discard);
        this.emptyDiscard();
    }
}
