package com.capstone.caledonia;

import javafx.scene.layout.AnchorPane;

public class VictoryScreenViewModel {
    private Game game = Game.getInstance();

    public AnchorPane restartGame()throws Exception{
        game.resetInstance();
        return game.gameMap.getCurrentNode().buildView();
    }
}
