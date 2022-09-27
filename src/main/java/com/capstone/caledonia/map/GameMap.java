package com.capstone.caledonia.map;

import com.capstone.caledonia.node.EnemyNode;
import com.capstone.caledonia.node.INode;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<INode> nodes;
    private int playerPosition;

    public GameMap() {
        this.nodes = new ArrayList<>();
        this.playerPosition = 0;
        generateGameMap();
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
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
        this.nodes.add(new EnemyNode());
    }
    public INode getCurrentNode(){
        return nodes.get(playerPosition);
    }
    public void advance(){
        this.playerPosition++;
    }

}
