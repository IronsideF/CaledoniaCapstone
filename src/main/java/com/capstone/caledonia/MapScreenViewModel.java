package com.capstone.caledonia;

import com.capstone.caledonia.node.INode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MapScreenViewModel {
    private final Game game = Game.getInstance();

    public ArrayList<ImageView> generateMap(){
        ArrayList<ImageView> result = new ArrayList<>();
        ArrayList<INode> nodes = game.gameMap.getNodes();
        for (INode node: nodes){
            ImageView nodeIcon = new ImageView(node.getIcon());
            if(node == game.gameMap.getCurrentNode()){
                nodeIcon.setScaleX(1.3);
                nodeIcon.setScaleY(1.3);
            }
            result.add(nodeIcon);
            if(nodes.indexOf(node)!=nodes.size()-1){
            result.add(new ImageView(new Image(getClass().getResource("/MapConnector.png").toExternalForm())));
            }
        }
        return result;
    }
}
