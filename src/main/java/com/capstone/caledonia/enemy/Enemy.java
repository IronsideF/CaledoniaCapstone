package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy {

    private int health;
    private int block;
    private ArrayList<Attack> attacks;
    private Boolean isDead;
    private int maxHealth;

    public Enemy(int health, int block, ArrayList<Attack> attacks, Boolean isDead) {
        this.health = health;
        this.maxHealth = health;
        this.block = block;
        this.attacks = attacks;
        this.isDead = isDead;
    }

    private ArrayList<Attack> generateAttacks() {
        Attack attack1 = new Attack(10, EffectType.DAMAGE, 10);
        Attack attack2 = new Attack(20, EffectType.DAMAGE, 5);
        Attack attack3 = new Attack(30, EffectType.HEAL, 10);
        ArrayList<Attack> attacks = new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
        return attacks;
    }

    public Enemy() {
        this.health = 100;
        this.block = 0;
        this.attacks = generateAttacks();
        this.isDead = false;
    }

    public int getHealth() {
        return health;
    }

    public int getBlock() {
        return block;
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public void attackPlayer(Player player) {
        int i = (int)(Math.random() * this.attacks.size());
        this.attacks.get(i).useAttack(this, player);
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

    public void handleDeath() {
        this.isDead = true;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public void healHealth(int val) {
        if ((val + this.health) > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health += val;
        }
    }

    public void addArmour(int val) {
        this.block += val;
    }
}


