package com.capstone.caledonia;

import com.capstone.caledonia.player.Player;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class StartUpScreen extends AnchorPane{
    @FXML
    private ImageView image;
    @FXML
    private Label title;
    @FXML
    private Button startButton;
    @FXML
    private Button endButton;
    @FXML
    private ImageView image2;

    public StartUpScreen()throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Caledonia.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        Fades.fadeIn(this).play();
    }

    @FXML
    protected void onStartButtonClick() throws Exception{
        FadeTransition fadeTransition = Fades.fadeOut(this);
        fadeTransition.setOnFinished(evt -> {
            try {
                getScene().setRoot(Game.getInstance().gameMap.getCurrentNode().buildView());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        fadeTransition.play();
    }
    @FXML
    protected void handleCloseButtonAction(ActionEvent event) {
        Platform.exit();
    }
}