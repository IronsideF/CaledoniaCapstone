package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import converters.HPConverter;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.ArrayList;


public class BattleScreenViewModel {
    private SimpleDoubleProperty playerHealth = new SimpleDoubleProperty();
    private SimpleDoubleProperty enemyHealth = new SimpleDoubleProperty();
   private Game game = Game.getInstance();
    private ObjectProperty<Image> playerSprite = new SimpleObjectProperty<>();
    private ObjectProperty<Image> enemySprite = new SimpleObjectProperty<>();
    private StringProperty deckCount = new SimpleStringProperty("");
    private StringProperty discardCount = new SimpleStringProperty("");
    private StringProperty handCount = new SimpleStringProperty("");
    private IntegerProperty energy = new SimpleIntegerProperty();

    public BattleScreenViewModel() {
        game.player.drawCards();
        Enemy enemy = game.gameMap.getCurrentNode().getContents();
        setDeckCount(String.valueOf(game.player.getDeck().getCards().size()));
        setDiscardCount(String.valueOf(game.player.getDiscard().getDiscard().size()));
        setHandCount(String.valueOf(game.player.getHand().getHand().size()));
        setEnemyHealth(HPConverter.convertHPtoProgress(enemy.getHealth(), enemy.getMaxHealth()));
        setPlayerHealth(HPConverter.convertHPtoProgress(game.player.getHealth(), game.player.getMaxHealth()));
        setPlayerSprite(game.player.getPlayerSprite());
        setEnemySprite(game.gameMap.getCurrentNode().getContents().getEnemySprite());
        setEnergy(game.player.getEnergy());
    }

    public double getPlayerHealth() {
        return playerHealth.get();
    }

    public void setPlayerHealth(double playerHealth) {
        this.playerHealth.set(playerHealth);
    }

    public DoubleProperty playerHealthProperty(){
        return playerHealth;
    }

    public int getEnergy() {
        return energy.get();
    }

    public IntegerProperty energyProperty() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy.set(energy);
    }

    public double getEnemyHealth() {
        return enemyHealth.get();
    }

    public void setEnemyHealth(double enemyHealth) {
        this.enemyHealth.set(enemyHealth);
    }

    public DoubleProperty enemyHealthProperty(){
        return enemyHealth;
    }

    public Image getPlayerSprite() {
        return playerSprite.get();
    }

    public void setPlayerSprite(Image playerSprite) {
        this.playerSprite.set(playerSprite);
    }
    public ObjectProperty<Image> playerSpriteProperty(){
        return playerSprite;
    }

    public Image getEnemySprite() {
        return enemySprite.get();
    }

    public void setEnemySprite(Image enemySprite) {
        this.enemySprite.set(enemySprite);
    }
    public ObjectProperty<Image> enemySpriteProperty(){
        return enemySprite;
    }

    public String getDeckCount() {
        return deckCount.get();
    }

    public StringProperty deckCountProperty() {
        return deckCount;
    }

    public void setDeckCount(String deckCount) {
        this.deckCount.set(deckCount);
    }

    public String getDiscardCount() {
        return discardCount.get();
    }

    public StringProperty discardCountProperty() {
        return discardCount;
    }

    public void setDiscardCount(String discardCount) {
        this.discardCount.set(discardCount);
    }

    public String getHandCount() {
        return handCount.get();
    }

    public StringProperty handCountProperty() {
        return handCount;
    }

    public void setHandCount(String handCount) {
        this.handCount.set(handCount);
    }
    public ArrayList<Image> generateHandImages(){
        ArrayList<Image> result = new ArrayList<>();
        for (ICard card : game.player.getHand().getHand()){
            result.add(card.getCardImage());
        }
        return result;
    }
    public void useCard(int index){
        boolean enemyDead = game.useCard(index);
        Enemy enemy = game.gameMap.getCurrentNode().getContents();
        setEnemyHealth(HPConverter.convertHPtoProgress(enemy.getHealth(), enemy.getMaxHealth()));
        setPlayerHealth(HPConverter.convertHPtoProgress(game.player.getHealth(), game.player.getMaxHealth()));
        setEnergy(game.player.getEnergy());
        if (enemyDead){
            handleNodeChange();
        }
    }
    public void handleNodeChange(){
        game.gameMap.advance();
        Enemy enemy = game.gameMap.getCurrentNode().getContents();
        setEnemyHealth(HPConverter.convertHPtoProgress(enemy.getHealth(), enemy.getMaxHealth()));
        setEnemySprite(enemy.getEnemySprite());
        game.startBattle();
        setEnergy(game.player.getEnergy());
    }
}
