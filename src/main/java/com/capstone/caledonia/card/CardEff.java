package com.capstone.caledonia.card;

public class CardEff {
    private int effect;
    private int cost;
    private EffectType type;

    public CardEff(int effect, int cost, EffectType type) {
        this.effect = effect;
        this.cost = cost;
        this.type = type;
    }

    public int getEffect() {
        return effect;
    }

    public int getCost() {
        return cost;
    }

    public EffectType getType() {
        return type;
    }
}
