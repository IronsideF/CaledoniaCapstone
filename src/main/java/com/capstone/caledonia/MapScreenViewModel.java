package com.capstone.caledonia;

import com.capstone.caledonia.node.INode;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MapScreenViewModel {
    private final Game game = Game.getInstance();
    private ScaleTransition mapPulse;

    public ArrayList<ImageView> generateMap(){
        ArrayList<ImageView> result = new ArrayList<>();
        ArrayList<INode> nodes = game.gameMap.getNodes();
        for (INode node: nodes){
            ImageView nodeIcon = new ImageView(node.getIcon());
            if(node == game.gameMap.getCurrentNode()){
                mapPulse = Animations.continuousPulse(nodeIcon);
                mapPulse.play();
            }
            result.add(nodeIcon);
            if(nodes.indexOf(node)!=nodes.size()-1){
            result.add(new ImageView(new Image(getClass().getResource("/MapConnectorSingle.png").toExternalForm())));
            result.add(new ImageView(new Image(getClass().getResource("/MapConnectorSingle.png").toExternalForm())));
            result.add(new ImageView(new Image(getClass().getResource("/MapConnectorSingle.png").toExternalForm())));
            }
        }
        return result;
    }
    public void stopMapPulse(){
        mapPulse.stop();
    }
    public int findCurrentPosition(){
       if(game.gameMap.getPlayerPosition()>0){
           return game.gameMap.getPlayerPosition()+game.gameMap.getPlayerPosition()*3;
       } else {return 0;}
    }
    public ArrayList<ImageView> generateCurrentMap(){
        ArrayList<ImageView> result = new ArrayList<>();
        for (int i = game.gameMap.getPlayerPosition(); i<game.gameMap.getNodes().size();i++){
            INode node = game.gameMap.getNodes().get(i);
            ImageView nodeIcon = new ImageView(node.getIcon());
            result.add(nodeIcon);
            if(game.gameMap.getNodes().indexOf(node)!=game.gameMap.getNodes().size()-1){
                result.add(new ImageView(new Image(getClass().getResource("/MapConnectorSingle.png").toExternalForm())));
                result.add(new ImageView(new Image(getClass().getResource("/MapConnectorSingle.png").toExternalForm())));
                result.add(new ImageView(new Image(getClass().getResource("/MapConnectorSingle.png").toExternalForm())));
            }
        }
        return result;
    }

}
