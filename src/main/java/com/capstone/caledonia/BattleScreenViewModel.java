package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import converters.HPConverter;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.ArrayList;


public class BattleScreenViewModel {
    private DoubleProperty playerHealth = new SimpleDoubleProperty();
    private IntegerProperty playerHealthInt = new SimpleIntegerProperty();
    private IntegerProperty playerMaxHealthInt = new SimpleIntegerProperty();
    private IntegerProperty playerBlock = new SimpleIntegerProperty();
    private DoubleProperty enemyHealth = new SimpleDoubleProperty();
    private IntegerProperty enemyHealthInt = new SimpleIntegerProperty();
    private IntegerProperty enemyMaxHealthInt = new SimpleIntegerProperty();
    private IntegerProperty enemyBlock = new SimpleIntegerProperty();
    private Game game = Game.getInstance();
    private ObjectProperty<Image> playerSprite = new SimpleObjectProperty<>();
    private ObjectProperty<Image> enemySprite = new SimpleObjectProperty<>();
    private IntegerProperty deckCount = new SimpleIntegerProperty();
    private IntegerProperty discardCount = new SimpleIntegerProperty();
    private IntegerProperty handCount = new SimpleIntegerProperty();
    private IntegerProperty energy = new SimpleIntegerProperty();
    private IntegerProperty maxEnergy = new SimpleIntegerProperty();

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

    public int getPlayerHealthInt() {
        return playerHealthInt.get();
    }

    public IntegerProperty playerHealthIntProperty() {
        return playerHealthInt;
    }

    public void setPlayerHealthInt(int playerHealthInt) {
        this.playerHealthInt.set(playerHealthInt);
    }

    public int getPlayerMaxHealthInt() {
        return playerMaxHealthInt.get();
    }

    public IntegerProperty playerMaxHealthIntProperty() {
        return playerMaxHealthInt;
    }

    public void setPlayerMaxHealthInt(int playerMaxHealthInt) {
        this.playerMaxHealthInt.set(playerMaxHealthInt);
    }

    public int getPlayerBlock() {
        return playerBlock.get();
    }

    public IntegerProperty playerBlockProperty() {
        return playerBlock;
    }

    public void setPlayerBlock(int playerBlock) {
        this.playerBlock.set(playerBlock);
    }

    public int getEnemyHealthInt() {
        return enemyHealthInt.get();
    }

    public IntegerProperty enemyHealthIntProperty() {
        return enemyHealthInt;
    }

    public void setEnemyHealthInt(int enemyHealthInt) {
        this.enemyHealthInt.set(enemyHealthInt);
    }

    public int getEnemyMaxHealthInt() {
        return enemyMaxHealthInt.get();
    }

    public IntegerProperty enemyMaxHealthIntProperty() {
        return enemyMaxHealthInt;
    }

    public void setEnemyMaxHealthInt(int enemyMaxHealthInt) {
        this.enemyMaxHealthInt.set(enemyMaxHealthInt);
    }

    public int getEnemyBlock() {
        return enemyBlock.get();
    }

    public IntegerProperty enemyBlockProperty() {
        return enemyBlock;
    }

    public void setEnemyBlock(int enemyBlock) {
        this.enemyBlock.set(enemyBlock);
    }

    public int getMaxEnergy() {
        return maxEnergy.get();
    }

    public IntegerProperty maxEnergyProperty() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy.set(maxEnergy);
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
        setPlayerHealthInt(game.player.getHealth());
        setPlayerMaxHealthInt(game.player.getMaxHealth());
        setEnemyHealthInt(enemy.getHealth());
        setEnemyMaxHealthInt(enemy.getMaxHealth());
        setEnemyHealth(HPConverter.convertHPtoProgress(getEnemyHealthInt(), getEnemyMaxHealthInt()));
        setPlayerHealth(HPConverter.convertHPtoProgress(getPlayerHealthInt(), getPlayerMaxHealthInt()));
        setEnemyBlock(enemy.getBlock());

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
    public void updateEnergyAndBlock(){
        setEnergy(game.player.getEnergy());
        setMaxEnergy(game.player.getMaxEnergy());
        setPlayerBlock(game.player.getBlock());
    }
    public void updateUI(){
        updateHP();
        updateEnergyAndBlock();
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
