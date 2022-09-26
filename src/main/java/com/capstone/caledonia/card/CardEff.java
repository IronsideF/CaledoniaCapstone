package com.capstone.caledonia.card;

public class CardEff {
    private String effect;
    private int cost;

    public CardEff(String effect, int cost) {
        this.effect = effect;
        this.cost = cost;
    }

    public String getEffect() {
        return effect;
    }

    public int getCost() {
        return cost;
    }
}
