package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.player.Player;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.ArrayList;


public class BattleScreenViewModel {
    private SimpleDoubleProperty playerHealth = new SimpleDoubleProperty(0.66);
    private SimpleDoubleProperty enemyHealth = new SimpleDoubleProperty(0.5);
    private Player player;
    private ObjectProperty<Image> playerSprite = new SimpleObjectProperty<>();
    private ObjectProperty<Image> enemySprite = new SimpleObjectProperty<>();
    private StringProperty deckCount = new SimpleStringProperty("");
    private StringProperty discardCount = new SimpleStringProperty("");
    private StringProperty handCount = new SimpleStringProperty("");

    public BattleScreenViewModel() {
        this.player = new Player();
        player.drawCards();
        setDeckCount(String.valueOf(player.getDeck().getCards().size()));
        setDiscardCount(String.valueOf(player.getDiscard().getDiscard().size()));
        setHandCount(String.valueOf(player.getHand().getHand().size()));
        setPlayerSprite(new Image((getClass().getResource("/IdleFrame1.png").toExternalForm())));
        setEnemySprite(new Image(getClass().getResource("/SquidSprite.png").toExternalForm()));
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
        for (ICard card : player.getHand().getHand()){
            result.add(card.getCardImage());
        }
        return result;
    }
}
