package com.capstone.caledonia.card;

public class CardDmg {
    private int damage;
    private int cost;

    public CardDmg(int damage, int cost) {
        this.damage = damage;
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getCost() {
        return cost;
    }
}
