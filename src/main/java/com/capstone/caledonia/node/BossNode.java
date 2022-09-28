package com.capstone.caledonia.node;

import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.card.CardGenerated;
import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Boss;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class BossNode implements INode{
    private Boss boss;
    private int treasure;
    private CardBuilder cardBuilder;
    private CardGenerated cardGenerated;

    public BossNode() {
        this.boss = new Boss();
        this.treasure = 500;
        this.cardBuilder = new CardBuilder();
        this.cardGenerated = cardBuilder.buildCard();
    }

    public Boss getBoss() {
        return boss;
    }

    public CardGenerated getCardGenerated() {
        return cardGenerated;
    }

    public Enemy getContents() {
        return null;
    }

    public AnchorPane buildView() throws Exception {
        return null;
    }

    public int getTreasure() {
        return this.treasure;
    }
    public ICard getRewardCard() {
        return this.cardGenerated;
    }
}
