package com.capstone.caledonia;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MapScreen extends AnchorPane{
    @FXML
    private Button exitButton;
    @FXML private HBox mapBox;
    @FXML private AnchorPane mapAnchor;
    private AnchorPane parent;
    private MapScreenViewModel viewModel = new MapScreenViewModel();

    public MapScreen(AnchorPane parent)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MapScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        populateMap();
        Background mapBackground = new Background(new BackgroundImage(new Image(getClass().getResource("/MapBackground.png").toExternalForm()), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        mapAnchor.setBackground(mapBackground);
        this.parent=parent;
    }
    @FXML public void onExitClick(){
        parent.getChildren().remove(this);
    }
    public void populateMap(){
        mapBox.getChildren().addAll(viewModel.generateMap());
    }

    public void handleMapTransition(FadeTransition fadeOut){
        viewModel.stopMapPulse();
        getChildren().remove(exitButton);
        mapBox.getChildren().clear();
        mapBox.getChildren().addAll(viewModel.generateCurrentMap());
        ScaleTransition scale1 = Animations.singlePulse(mapBox.getChildren().get(0));
        ScaleTransition scale2 = Animations.singlePulse(mapBox.getChildren().get(1));
        ScaleTransition scale3 = Animations.singlePulse(mapBox.getChildren().get(2));
        ScaleTransition scale4 = Animations.singlePulse(mapBox.getChildren().get(3));
        ScaleTransition scale5 = Animations.singlePulse(mapBox.getChildren().get(4));
        scale1.setOnFinished(evt -> scale2.play());
        scale2.setOnFinished(evt->scale3.play());
        scale3.setOnFinished(evt->scale4.play());
        scale4.setOnFinished(evt->scale5.play());
        scale5.setOnFinished(evt->fadeOut.play());
        scale1.play();
    }
}

