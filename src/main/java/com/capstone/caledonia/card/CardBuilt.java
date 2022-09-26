package com.capstone.caledonia.card;

public class CardBuilt implements ICard{
    private int dmg;
    private String effect;
    private int cost;

    public CardBuilt(int dmg, String effect, int cost) {
        this.dmg = dmg;
        this.effect = effect;
        this.cost = cost;
    }

    public int getDmg() {
        return dmg;
    }

    public String getEffect() {
        return effect;
    }

    public int getCost() {
        return cost;
    }

    public void useCard(/*Enemy enemy */) {
        //attack enemy w/ card damage affected by the effect of the card
        //reduce the player energy by the cost of the card
    }

    public void discardCard() {
        //add the card to the discard pile and remove it from the players hand

    }
}

