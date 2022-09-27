package com.capstone.caledonia.node;

import com.capstone.caledonia.enemy.Enemy;

import java.util.Random;

public class TreasureNode implements INode{
    private int treasure;
    public TreasureNode() {
        Random rand = new Random();
        this.treasure = rand.nextInt(100, 250);
    }

    public Enemy getContents(){
        return null;
    }

    public int getTreasure() {
        return treasure;
    }
}
