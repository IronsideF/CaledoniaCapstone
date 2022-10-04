package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.map.GameMap;
import com.capstone.caledonia.node.BossNode;
import com.capstone.caledonia.node.EnemyNode;
import com.capstone.caledonia.node.TreasureNode;
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

    public void useCard(int index){
        EnemyNode node = (EnemyNode) gameMap.getCurrentNode();
        player.useCard(index, node.getEnemy());
    }
    public void startBattle(){
        player.reset();
        player.drawCards(player.getCardsDrawnPerTurn());
        ((EnemyNode)gameMap.getCurrentNode()).getEnemy().setIntent();
    }

    public void moveCardFromDeckToBag(int index) {
        player.getBag().addCard(player.getPermaDeck().removeCard(index));
    }

    public void moveCardFromBagToDeck(int index) {
        player.getPermaDeck().addCard(player.getBag().removeCard(index));
    }

    public AnchorPane advanceToNextNode()throws Exception{
        if (gameMap.getPlayerPosition()+1< gameMap.getNodes().size()){
            gameMap.advance();
            if (gameMap.getCurrentNode() instanceof TreasureNode){
                player.setMaxEnergy(player.getMaxEnergy()+1);
                player.incrementCardsDrawnPerTurn();
                if (gameMap.getPlayerPosition()<6){
                    return new SunnyTreasureScreen();
                }
            }
            return gameMap.getCurrentNode().buildView();
        }
        return new VictoryScreen("Congratulations!");
    }

    public void resetInstance(){
        this.player = new Player();
        this.gameMap = new GameMap();
    }

    public void nextGame(){
        this.player.setMaxHealth(this.player.getMaxHealth() + 100);
        this.player.healHealth(200);
        this.gameMap.generateNextMap();
        this.startBattle();
    }


    public boolean endTurn(){
        EnemyNode node = (EnemyNode) gameMap.getCurrentNode();
        node.getEnemy().resetBlock();
        node.getEnemy().attackPlayer(player);
        player.endTurn();
        node.getEnemy().clearIntent();
        node.getEnemy().setIntent();
        return player.getDead();
    }


    public void handleVictory(){

    }

}
