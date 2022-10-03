package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

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
        return new CardComponent(game.gameMap.getCurrentNode().createRewardCard(game.gameMap.getPlayerPosition()));
    }
    public void collectTreasure(){
        game.player.addTreasure(getTreasureCount());
    }
    public void collectRewardCard(){
        ArrayList<ICard> rewards = game.gameMap.getCurrentNode().createArrayOfRewardCards(game.gameMap.getPlayerPosition());
        for (ICard rewardCard : rewards) {
            game.player.getPermaDeck().addCard(rewardCard);
            game.player.getDrawPile().addCard(rewardCard);
        }
    }
    public AnchorPane handleNodeChange()throws Exception{
        return game.advanceToNextNode();
    }
}
