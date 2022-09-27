package com.capstone.caledonia.enemy;

import com.capstone.caledonia.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy {

    private int health;
    private int block;
    private ArrayList<Integer> attacks;

    public Enemy(int health, int block, ArrayList<Integer> attacks) {
        this.health = health;
        this.block = block;
        this.attacks = attacks;
    }

    public Enemy() {
        this.health = 100;
        this.block = 0;
        this.attacks = new ArrayList<>((Arrays.asList(10, 20, 50)));
    }

    public int getHealth() {
        return health;
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
        System.out.println(attack);
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
        //update the node and
    }
}
