package com.capstone.caledonia;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.AnchorPane;

public class VictoryScreenViewModel {
    private final Game game = Game.getInstance();
    private StringProperty details = new SimpleStringProperty("");
    private StringProperty treasure = new SimpleStringProperty("");

    public VictoryScreenViewModel(){
        if (game.player.getDead()){
        setDetails("You have perished in your quest to slay the Fire Demon");
        setTreasure(String.format("%s gold coins are lost, along with your life", game.player.getTreasure()));
        } else {
            setDetails("You have conquered the Fire Demon");
            setTreasure(String.format("You carry home %s gold coins, good thing you brought a bag!", game.player.getTreasure()));
        }
    }

    public AnchorPane restartGame()throws Exception{
        if (game.player.getDead()) {
            game.resetInstance();
            return game.gameMap.getCurrentNode().buildView();
        } else {
            game.nextGame();
            game.advanceToNextNode();
            return game.gameMap.getCurrentNode().buildView();
        }
    }

//    public AnchorPane nextGame()throws Exception{
//        if(game.player.getDead()) {
//            setDetails("You have died, and you cannot carry on!");
//        } else {
//            game.nextGame();
//            game.advanceToNextNode();
//            return game.gameMap.getCurrentNode().buildView();
//        }
//    }

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }

    public void setDetails(String details) {
        this.details.set(details);
    }

    public String getTreasure() {
        return treasure.get();
    }

    public StringProperty treasureProperty() {
        return treasure;
    }

    public void setTreasure(String treasure) {
        this.treasure.set(treasure);
    }
}
