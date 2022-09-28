package com.capstone.caledonia.node;


import com.capstone.caledonia.enemy.Enemy;
import javafx.scene.layout.AnchorPane;

public interface INode {
    AnchorPane buildView() throws Exception;
}
