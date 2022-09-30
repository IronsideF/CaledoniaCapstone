package com.capstone.caledonia.node;


import com.capstone.caledonia.BattleScreen;
import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.card.CardGenerated;
import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class EnemyNode implements INode {
    protected Enemy enemy;
    protected int treasure;
    protected CardBuilder cardBuilder;
    protected ICard cardGenerated;

    public EnemyNode() {
        Random rand = new Random();
        this.enemy = new Enemy();
        this.treasure = rand.nextInt(10, 50);
//        this.cardBuilder = new CardBuilder();
//        this.cardGenerated = cardBuilder.buildCard();
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

    public ICard getRewardCard() {
        return cardGenerated;
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

    public ICard createRewardCard(int bonus) {
        this.cardBuilder = new CardBuilder(bonus);
        this.cardGenerated = cardBuilder.buildCard();
        return cardGenerated;
    }

}
