package com.capstone.caledonia;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;


public class TreasureScreenViewModel {

    private Game game = Game.getInstance();
    private ObjectProperty<Image> playerSprite = new SimpleObjectProperty<>();

    TreasureScreenViewModel(){
        setPlayerSprite(game.player.getPlayerSprite());
    }

    public Image getPlayerSprite() {
        return playerSprite.get();
    }

    public ObjectProperty<Image> playerSpriteProperty() {
        return playerSprite;
    }

    public void setPlayerSprite(Image playerSprite) {
        this.playerSprite.set(playerSprite);
    }
    public void collectTreasure(){
        game.player.addTreasure(game.gameMap.getCurrentNode().getTreasure());
    }
}
