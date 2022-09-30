package com.capstone.caledonia.card;

import javafx.scene.image.Image;

public class CardDmg {
    private int damage;
    private int cost;
    private Image icon;

    public CardDmg(int damage, int cost) {
        this.damage = damage;
        this.cost = cost;
        this.icon = new Image(getClass().getResource("/CardDamageTextIcon.png").toExternalForm());
    }

    public int getDamage() {
        return damage;
    }

    public int getCost() {
        return cost;
    }

    public Image getIcon() {
        return icon;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
