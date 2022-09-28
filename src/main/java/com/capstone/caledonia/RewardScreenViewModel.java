package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.AnchorPane;

public class RewardScreenViewModel {
    private IntegerProperty treasureCount = new SimpleIntegerProperty();
    private final Game game = Game.getInstance();

    RewardScreenViewModel(){
        setTreasureCount(game.gameMap.getCurrentNode().getTreasure());
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
        return new CardComponent(game.gameMap.getCurrentNode().getRewardCard());
    }
    public void collectTreasure(){
        game.player.addTreasure(getTreasureCount());
    }
    public void collectRewardCard(){
        game.player.getDeck().addCard(game.gameMap.getCurrentNode().getRewardCard());
    }
    public AnchorPane handleNodeChange()throws Exception{
        return game.advanceToNextNode();
    }
}
