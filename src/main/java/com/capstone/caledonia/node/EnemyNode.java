package com.capstone.caledonia.node;


import com.capstone.caledonia.BattleScreen;
import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.card.CardGenerated;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class EnemyNode implements INode {
    private Enemy enemy;
    private int treasure;
    private CardBuilder cardBuilder;
    private CardGenerated cardGenerated;

    public EnemyNode() {
        Random rand = new Random();
        this.enemy = new Enemy();
        this.treasure = rand.nextInt(10, 50);
        this.cardBuilder = new CardBuilder();
        this.cardGenerated = cardBuilder.buildCard();
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getTreasure() {
        return treasure;
    }

    public CardGenerated getRewardCard() {
        return this.cardGenerated;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }
    public Enemy getContents(){
        return getEnemy();
    }
    public AnchorPane buildView() throws Exception{
        return new BattleScreen();
    }

}
