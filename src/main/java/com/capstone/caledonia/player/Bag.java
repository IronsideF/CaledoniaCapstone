package com.capstone.caledonia.player;

import com.capstone.caledonia.card.ICard;

import java.util.ArrayList;

public class Bag {
    private ArrayList<ICard> cards;

    public Bag() {
        cards = new ArrayList<>();
    }

    public ArrayList<ICard> getCards() {
        return cards;
    }

    public void addCard(ICard card) {
        this.cards.add(card);
    }

    public ICard removeCard(ICard card) {
        this.cards.remove(card);
        return card;
    }
}
