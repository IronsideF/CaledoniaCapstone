package com.capstone.caledonia.enemy;

import com.capstone.caledonia.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy {

    private int health;
    private int block;
    private ArrayList<Integer> attacks;
    private Boolean isDead;

    public Enemy(int health, int block, ArrayList<Integer> attacks) {
        this.health = health;
        this.block = block;
        this.attacks = attacks;
        this.isDead = false;
    }

    public Enemy() {
        this.health = 100;
        this.block = 0;
        this.attacks = new ArrayList<>((Arrays.asList(10, 20, 50)));
        this.isDead = false;
    }

    public int getHealth() {
        return health;
    }

    public Enemy(int health, int block, ArrayList<Integer> attacks, Boolean isDead) {
        this.health = health;
        this.block = block;
        this.attacks = attacks;
        this.isDead = isDead;
    }

    public int getBlock() {
        return block;
    }

    public ArrayList<Integer> getAttacks() {
        return attacks;
    }

    public void attackPlayer(Player player) {
        int i = (int)(Math.random() * this.attacks.size());
        int attack = this.attacks.get(i);
        player.takeDamage(attack);
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
}
