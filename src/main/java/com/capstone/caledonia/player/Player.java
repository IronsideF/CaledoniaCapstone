package com.capstone.caledonia.player;

import com.capstone.caledonia.card.ICard;

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

    public Player(int health, int energy, int treasure, int block, Deck deck) {
        this.health = health;
        this.maxHealth = health;
        this.energy = energy;
        this.maxEnergy = energy;
        this.treasure = treasure;
        this.block = block;
        this.deck = deck;
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
        int deckRemaining =  7 - this.deck.getCards().size();
        if (deckRemaining > 0 && deckRemaining < 7) {
            for (int i = 0; i < deckRemaining; i++) {
                this.hand.addCard(this.deck.drawCard());
            }
            this.resetDeckAndDiscard();
        } else if (deckRemaining == 0) {
            this.resetDeckAndDiscard();
        }
        this.hand.drawHand(this.deck);
    }

    public void addToDiscard(ICard card) {
        this.discard.addCard(card);
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
        this.deck.setDeck(this.discard.getDiscard());
        this.discard.emptyDiscard();
    }
}
