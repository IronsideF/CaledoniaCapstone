package com.capstone.caledonia.node;


import com.capstone.caledonia.enemy.Enemy;

import java.util.Random;

public class EnemyNode implements INode {
    private Enemy enemy;
    private int treasure;

    public EnemyNode() {
        Random rand = new Random();
        this.enemy = new Enemy();
        this.treasure = rand.nextInt(10, 50);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }
    public Enemy getContents(){
        return getEnemy();
    }

}
