package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.node.BossNode;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class RewardScreenViewModel {
    private IntegerProperty treasureCount = new SimpleIntegerProperty();
    private final Game game = Game.getInstance();
    private ArrayList<CardComponent> cardRewards = new ArrayList<>();
    private ArrayList<ICard> rawRewards = game.gameMap.getCurrentNode().createArrayOfRewardCards(game.gameMap.getPlayerPosition());

    RewardScreenViewModel()throws Exception{
        setTreasureCount(game.gameMap.getCurrentNode().getTreasure());
        generateRewardCards();
    }

    public int getTreasureCount() {
        return treasureCount.get();
    }

    public IntegerProperty treasureCountProperty() {
        return treasureCount;
    }

    public void setTreasureCount(int treasureCount) {
        this.treasureCount.set(treasureCount);
    }
    public CardComponent getRewardCard()throws Exception{
        return new CardComponent(game.gameMap.getCurrentNode().createRewardCard(game.gameMap.getPlayerPosition()));
    }
    public void collectTreasure(){
        game.player.addTreasure(getTreasureCount());
    }
    public ArrayList<CardComponent> getCardRewards(){
        return cardRewards;
    }

    public void generateRewardCards()throws Exception{
        for (ICard card: rawRewards){
            cardRewards.add(new CardComponent(card));
        }
    }
    public void collectRewardCard(int index){
            game.player.getPermaDeck().addCard(rawRewards.get(index));
    }
    public AnchorPane handleNodeChange()throws Exception{
        return game.advanceToNextNode();
    }
    public boolean isBossNode(){
        return game.gameMap.getCurrentNode() instanceof BossNode;
    }
}
