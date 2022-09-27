package com.capstone.caledonia.player;

import com.capstone.caledonia.card.CardBuilt;
import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.card.ICard;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    public Player() {
        this.health = 100;
        this.maxHealth = health;
        this.energy = 3;
        this.maxEnergy = energy;
        this.treasure = 0;
        this.block = 0;
        this.deck = generateStarterDeck();
        this.discard = new Discard();
        this.hand = new Hand();
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

    public int getBlock() {
        return block;
    }

    public Deck getDeck() {
        return deck;
    }

    public Discard getDiscard() {
        return discard;
    }

    public Hand getHand() {
        return hand;
    }

    public void takeDamage(int dmg) {
        if (this.block >= dmg) {
            this.block -= dmg;
        } else {
            dmg -= this.block;
            this.block = 0;
            this.health -= dmg;
            if (this.health <= 0 ) {
                this.handleDeath();
            }
        }
    }

    private Deck generateStarterDeck(){
        Random rand = new Random();
        ArrayList<ICard> result = new ArrayList<>();
        ICard dmgCard = new CardBuilt(5, 0, 1, EffectType.DAMAGE, new Image(getClass().getResource("/BasicDamageCard.png").toExternalForm()));
        ICard blockCard = new CardBuilt(0, 4, 1, EffectType.ARMOUR, new Image(getClass().getResource("/BasicBlockCard.png").toExternalForm()));
        ICard healCard = new CardBuilt(3, 7, 2, EffectType.HEAL, new Image(getClass().getResource("/BasicHealCard.png").toExternalForm()));
        result.add(dmgCard);
        result.add(dmgCard);
        result.add(dmgCard);
        result.add(dmgCard);
        result.add(dmgCard);
        result.add(blockCard);
        result.add(blockCard);
        result.add(blockCard);
        result.add(blockCard);
        result.add(healCard);
        Collections.shuffle(result);
        return new Deck(result);
    }

    public void useCard(ICard card/*, Enemy enemy*/) {
        if (this.hand.getHand().contains(card)) {
            if (this.energy > card.getCost()) {
//            if (card.getDamage() > enemy.getHealth()) {
//                enemy.handleDeath
//            } else {
//              enemy.takeDamage(card.getDamage());
//            }
            this.hand.removeCard(card);
            this.addToDiscard(card);
            this.energy -= card.getCost();
            }
        }
    }

    public void drawCards() {
        int deckSize = this.deck.getCards().size();
        if (deckSize > 7) {
            this.hand.drawHand(this.deck);
        } else {
            this.resetDeckAndDiscard();
            this.hand.drawHand(this.deck);
        }
    }

    public void addToDiscard(ICard card) {
        this.discard.addCard(card);
        this.hand.removeCard(card);
    }

    public void handleDeath() {
        //do something
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
            {
                this.addToDiscard(this.hand.getHand().get(0));
            }
        }
        this.hand.clearHand();
    }
}
