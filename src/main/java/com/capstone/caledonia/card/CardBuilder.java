package com.capstone.caledonia.card;

import java.util.ArrayList;

public class CardBuilder {
    private ArrayList<CardDmg> cardDmgs;
    private ArrayList<CardEff> cardEffs;

    public CardBuilder() {
        this.cardDmgs = new ArrayList<>();
        this.cardEffs = new ArrayList<>();
    }

    public ArrayList<CardDmg> getCardDmgs() {
        return cardDmgs;
    }

    public ArrayList<CardEff> getCardEffs() {
        return cardEffs;
    }

    public void addCardDmg(CardDmg cardDmg) {
        this.cardDmgs.add(cardDmg);
    }

    public void addCardEff(CardEff cardEff) {
        this.cardEffs.add(cardEff);
    }

    public CardDmg getRandomDmg() {
        int i = (int)(Math.random() * this.cardDmgs.size());
        return this.cardDmgs.get(i);
    }

    public CardEff getRandomEff() {
        int i = (int)(Math.random() * this.cardEffs.size());
        return this.cardEffs.get(i);
    }

    public CardGenerated buildCard() {
        return new CardGenerated(this.getRandomDmg(), this.getRandomEff());
    }
}
