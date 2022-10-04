package com.capstone.caledonia.map;

import com.capstone.caledonia.node.BossNode;
import com.capstone.caledonia.node.EnemyNode;
import com.capstone.caledonia.node.INode;
import com.capstone.caledonia.node.TreasureNode;

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
        for (int i = this.playerPosition; i < this.playerPosition+10; i++) {
            if (i>1&&i%3==0){nodes.add(new TreasureNode());}
            else {nodes.add(new EnemyNode(i));}
        }
        nodes.add(new BossNode(11));
    }

    public void generateNextMap(){
        nodes.add(new TreasureNode());
        for (int i = this.playerPosition; i < this.playerPosition+10; i++) {
            if (i>1&&i%3==0){nodes.add(new TreasureNode());}
            else {nodes.add(new EnemyNode(i));}
        }
        nodes.add(new BossNode(this.playerPosition + 11));
    }
    public INode getCurrentNode(){
        return nodes.get(playerPosition);
    }
    public void advance(){
        this.playerPosition++;
    }

}
