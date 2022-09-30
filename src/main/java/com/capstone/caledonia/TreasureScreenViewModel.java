package com.capstone.caledonia;

import com.capstone.caledonia.node.TreasureNode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class TreasureScreenViewModel {

    private Game game = Game.getInstance();
    private ObjectProperty<Image> playerSprite = new SimpleObjectProperty<>();
    private TreasureNode node = (TreasureNode) game.gameMap.getCurrentNode();
    private int bonus = game.gameMap.getPlayerPosition();

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
}
