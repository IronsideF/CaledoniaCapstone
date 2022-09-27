package com.capstone.caledonia.map;

import com.capstone.caledonia.Game;
import com.capstone.caledonia.node.EnemyNode;
import com.capstone.caledonia.node.INode;
import com.capstone.caledonia.node.TreasureNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GameMap {
    private ArrayList<INode> nodes;
    private ArrayList<Integer> types;
    private int playerPosition;

    public GameMap() {
        this.nodes = new ArrayList<>();
        this.playerPosition = 0;
        generateGameMap();
        this.types = new ArrayList<>(Arrays.asList(0, 1));
    }

    public ArrayList<INode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<INode> nodes) {
        this.nodes = nodes;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
    private void generateGameMap(){
        for (int i = 0; i < 10; i++) {
            int index = (int)(Math.random() * 2);
            if (index == 1) {
                nodes.add(new EnemyNode());
            } else {
                nodes.add(new TreasureNode());
            }
            System.out.println(nodes.get(i));
        }
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
//        this.nodes.add(new EnemyNode());
    }
    public INode getCurrentNode(){
        return nodes.get(playerPosition);
    }
    public void advance(){
        this.playerPosition++;
    }

}
