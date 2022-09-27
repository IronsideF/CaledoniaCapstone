package com.capstone.caledonia;

public class VictoryScreenViewModel {
    private Game game = Game.getInstance();

    public void restartGame(){
        game.resetInstance();
    }
}
