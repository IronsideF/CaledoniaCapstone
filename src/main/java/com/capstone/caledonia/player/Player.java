package com.capstone.caledonia.player;

import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private int health;
    private int maxHealth;
    private int energy;
    private int maxEnergy;
    private int treasure;
    private int block;
    private Deck deck;
    private Discard discard;
    private Hand hand;
    private Image playerSprite;
    private Boolean isDead;
    private Bag bag;
    private int cardsDrawnPerTurn;

    public Player() {
        this.health = 100;
        this.maxHealth = health;
        this.energy = 5;
        this.maxEnergy = energy;
        this.treasure = 0;
        this.block = 0;
        this.deck = generateStarterDeck();
        this.discard = new Discard();
        this.hand = new Hand();
        this.playerSprite = new Image(getClass().getResource("/IdleFrame1.png").toExternalForm());
        this.isDead = false;
        this.bag = new Bag();
        this.cardsDrawnPerTurn = 4;
    }

    public Player(int health, int energy, Deck deck) {
        this.health = health;
        this.maxHealth = health;
        this.energy = energy;
        this.maxEnergy = energy;
        this.deck = deck;
        this.treasure = 0;
        this.block = 0;
        this.discard = new Discard();
        this.hand = new Hand();
        this.isDead = false;
        this.bag = new Bag();
    }

    public int getHealth() {
        return health;
    }

    public int getEnergy() {
        return energy;
    }

    public int getTreasure() {
        return treasure;
    }
    public void addTreasure(int amount){
        this.treasure += amount;
    }

    public int getBlock() {
        return block;
    }

    public Deck getDeck() {
        return deck;
    }

    public Boolean getDead() {
        return isDead;
    }

    public Discard getDiscard() {
        return discard;
    }

    public Hand getHand() {
        return hand;
    }

    public Image getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(Image playerSprite) {
        this.playerSprite = playerSprite;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Bag getBag() {
        return this.bag;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public int getMaxEnergy(){
        return maxEnergy;
    }
    public void setMaxEnergy(int amount){
        this.maxEnergy = amount;
    }

    public int getCardsDrawnPerTurn() {
        return cardsDrawnPerTurn;
    }

    public void setCardsDrawnPerTurn(int cardsDrawnPerTurn) {
        this.cardsDrawnPerTurn = cardsDrawnPerTurn;
    }
    public void incrementCardsDrawnPerTurn(){
        this.cardsDrawnPerTurn++;
    }

    public void takeDamage(int dmg) {
        if (this.block >= dmg) {
            this.block -= dmg;
        } else {
            int damage = (dmg - this.block);
            this.block = 0;
            this.health -= damage;
            if (this.health <= 0 ) {
                this.handleDeath();
            }
        }
    }

    private Deck generateStarterDeck(){
        CardBuilder builder = new CardBuilder();
        ArrayList<ICard> result = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            result.add(builder.buildCard());
        }
        Collections.shuffle(result);
        return new Deck(result);
    }

    public void useCard(int index, Enemy enemy) {
        ICard card = this.hand.getHand().get(index);
            if (this.energy >= card.getCost()) {
               card.useEffect(this, enemy);
            this.addToDiscard(card);
            this.hand.removeCard(index);
            this.energy -= card.getCost();
            }

    }

    public void drawCards(int amount) {
        while (amount > 0) {
            int deckSize = this.deck.getCards().size();
            if (deckSize <= 0) {
                this.resetDeckAndDiscard();
            }
            this.hand.drawToHand(this.deck);
            amount--;
        }
    }

    public void addToDiscard(ICard card) {
        this.discard.addCard(card);
    }

    public void handleDeath() {
        this.isDead = true;
    }

    public void addArmour(int armour) {
        this.block += armour;
    }

    public void healHealth(int heal) {
        if ((this.health + heal) >= this.maxHealth) {
            this.health = this.maxHealth;
        } else {
        this.health += heal;
        }
    }

    public void resetDeckAndDiscard() {
        for (ICard card : this.discard.getDiscard()) {
            this.deck.addCard(card);
        }
        this.discard.emptyDiscard();

    }

    public void emptyHand() {
        int size = this.hand.getHand().size();
        for (int i = 0; i < size; i++) {
                this.addToDiscard(this.hand.getHand().get(i));
        }
        this.hand.clearHand();
    }
    public void reset(){
        emptyHand();
        resetDeckAndDiscard();
        resetBlockAndEnergy();
    }
    public void endTurn(){
        emptyHand();
        resetBlockAndEnergy();
        drawCards(cardsDrawnPerTurn);
    }

    public void resetBlockAndEnergy() {
        this.block = 0;
        this.energy = maxEnergy;
    }
}
