package com.capstone.caledonia.node;


import com.capstone.caledonia.card.ICard;
import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.layout.AnchorPane;

public interface INode {
    Enemy getContents();

    AnchorPane buildView() throws Exception;

    int getTreasure();

    ICard getRewardCard();
}
