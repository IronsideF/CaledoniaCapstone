package com.capstone.caledonia.player;

import com.capstone.caledonia.card.ICard;

import java.util.ArrayList;

public class Deck {
    private ArrayList<ICard> deck;

    public Deck(ArrayList<ICard> deck) {
        this.deck = deck;
    }

    public ArrayList<ICard> getCards() {
        return deck;
    }

    public void setDeck(ArrayList<ICard> deck) {
        this.deck = deck;
    }

    public ICard drawCard() {
        ICard card = this.deck.get(0);
        this.deck.remove(0);
        return card;
    }

    public void addCard(ICard card) {
        this.deck.add(card);
    }


}
