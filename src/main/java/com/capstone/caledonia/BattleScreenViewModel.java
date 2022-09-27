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
    private IntegerProperty deckCount = new SimpleIntegerProperty();
    private IntegerProperty discardCount = new SimpleIntegerProperty();
    private IntegerProperty handCount = new SimpleIntegerProperty();
    private IntegerProperty energy = new SimpleIntegerProperty();

    public BattleScreenViewModel() {
        game.startBattle();
        updateUI();
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

    public Integer getDeckCount() {
        return deckCount.get();
    }

    public IntegerProperty deckCountProperty() {
        return deckCount;
    }

    public void setDeckCount(Integer deckCount) {
        this.deckCount.set(deckCount);
    }

    public Integer getDiscardCount() {
        return discardCount.get();
    }

    public IntegerProperty discardCountProperty() {
        return discardCount;
    }

    public void setDiscardCount(Integer discardCount) {
        this.discardCount.set(discardCount);
    }

    public Integer getHandCount() {
        return handCount.get();
    }

    public IntegerProperty handCountProperty() {
        return handCount;
    }

    public void setHandCount(Integer handCount) {
        this.handCount.set(handCount);
    }
    public ArrayList<Image> generateHandImages(){
        ArrayList<Image> result = new ArrayList<>();
        for (ICard card : game.player.getHand().getHand()){
            result.add(card.getCardImage());
        }
        return result;
    }


    public void updateHP(){
        Enemy enemy = game.gameMap.getCurrentNode().getContents();
        setEnemyHealth(HPConverter.convertHPtoProgress(enemy.getHealth(), enemy.getMaxHealth()));
        setPlayerHealth(HPConverter.convertHPtoProgress(game.player.getHealth(), game.player.getMaxHealth()));
    }
    public void updateCardInfo(){
        setDeckCount(game.player.getDeck().getCards().size());
        setDiscardCount(game.player.getDiscard().getDiscard().size());
        setHandCount(game.player.getHand().getHand().size());

    }
    public void updateSprites(){
        setPlayerSprite(game.player.getPlayerSprite());
        setEnemySprite(game.gameMap.getCurrentNode().getContents().getEnemySprite());
    }
    public void updateEnergy(){
        setEnergy(game.player.getEnergy());
    }
    public void updateUI(){
        updateHP();
        updateEnergy();
        updateCardInfo();
        updateSprites();
    }
    public boolean useCard(int index){
        boolean enemyDead = game.useCard(index);
        updateUI();
        if (enemyDead){
            return handleNodeChange();
        }
        else return false;
    }
    public boolean handleNodeChange(){
        if(!game.advanceToNextNode()){
        updateUI();
        return false;}
        game.handleVictory();
        return true;
    }
    public boolean endTurn(){
        boolean gameOver = game.endTurn();
        updateUI();
        return gameOver;
    }
}
