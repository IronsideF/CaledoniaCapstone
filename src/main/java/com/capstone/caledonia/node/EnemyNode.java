package com.capstone.caledonia.node;


import com.capstone.caledonia.BattleScreen;
import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

public class EnemyNode implements INode {
    protected Enemy enemy;
    protected int treasure;
    protected CardBuilder cardBuilder;
    protected ICard cardGenerated;
    protected Image icon;


    public EnemyNode(int bonus) {
        Random rand = new Random();
        this.enemy = new Enemy(bonus);
        this.treasure = rand.nextInt(10, 50);
        this.icon = new Image(getClass().getResource("/EnemyIcon.png").toExternalForm());
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
    public Image getIcon(){
        return this.icon;
    }
    public AnchorPane buildView() throws Exception{
        return new BattleScreen();
    }

    public ICard createRewardCard(int bonus) {
        this.cardBuilder = new CardBuilder(bonus);
        this.cardGenerated = cardBuilder.buildCard();
        return cardGenerated;
    }

    public ArrayList<ICard> createArrayOfRewardCards(int bonus) {
        ArrayList<ICard> rewards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            rewards.add(createRewardCard(bonus));
        }
        return rewards;
    }

}
