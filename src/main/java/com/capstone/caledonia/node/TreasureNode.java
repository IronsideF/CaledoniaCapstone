package com.capstone.caledonia.node;

import com.almasb.fxgl.core.collection.Array;
import com.capstone.caledonia.TreasureScreen;
import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.card.CardGenerated;
import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TreasureNode implements INode{
    private int treasure;
    private CardBuilder cardBuilder;
    private ICard cardGenerated;
    private CardGenerated cardGenerated2;
    private CardGenerated cardGenerated3;
    private ArrayList<CardGenerated> cardGenerateds;
    public TreasureNode() {
        Random rand = new Random();
        this.treasure = rand.nextInt(100, 250);
//        this.cardGenerated2 = cardBuilder.buildCard();
//        this.cardGenerated3 = cardBuilder.buildCard();
//        this.cardGenerateds = new ArrayList<>();
//        cardGenerateds.add(cardGenerated1);
//        cardGenerateds.add(cardGenerated2);
//        cardGenerateds.add(cardGenerated3);
    }

    public ICard getRewardCard() {
        return this.cardGenerated;
    }
    public Enemy getContents(){
        return null;
    }

    public int getTreasure() {
        return treasure;
    }
    public AnchorPane buildView() throws Exception{
        return new TreasureScreen();
    }

    public ICard createRewardCard(int bonus) {
        this.cardBuilder = new CardBuilder(bonus);
        this.cardGenerated = cardBuilder.buildCard();
        return this.cardGenerated;
    }

    public ArrayList<CardGenerated> getCardGenerateds() {
        return this.cardGenerateds;
    }
}
