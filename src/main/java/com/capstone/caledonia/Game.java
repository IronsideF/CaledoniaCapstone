package com.capstone.caledonia;

import com.capstone.caledonia.enemy.Enemy;
import com.capstone.caledonia.map.GameMap;
import com.capstone.caledonia.node.EnemyNode;
import com.capstone.caledonia.player.Player;
import javafx.scene.layout.AnchorPane;

public class Game {
    private static Game single_instance = null;
    public GameMap gameMap;
    public Player player;

    private Game() {
        this.gameMap = new GameMap();
        this.player = new Player();
    }
    public static Game getInstance(){
        if (single_instance==null){
            single_instance = new Game();
        }
        return single_instance;
    }

    public boolean useCard(int index){
        EnemyNode node = (EnemyNode) gameMap.getCurrentNode();
        player.useCard(index, node.getEnemy());
        if (node.getEnemy().getIsDead()){
            player.addTreasure(node.getTreasure());
            player.getDeck().addCard(node.getRewardCard());
            return true;
        }
        return false;
    }
    public void startBattle(){
        player.reset();
        player.drawCards(4);
    }

    public AnchorPane advanceToNextNode()throws Exception{
        if (gameMap.getPlayerPosition()+1< gameMap.getNodes().size()){
            gameMap.advance();
            return gameMap.getCurrentNode().buildView();
        }
        return new VictoryScreen("Congratulations!");
    }

    public void resetInstance(){
        this.player = new Player();
        this.gameMap = new GameMap();
    }

    public boolean endTurn(){
        EnemyNode node = (EnemyNode) gameMap.getCurrentNode();
        node.getEnemy().resetBlock();
        node.getEnemy().attackPlayer(player);
        player.endTurn();
        return player.getDead();
    }


    public void handleVictory(){

    }

}
