package com.capstone.caledonia;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class VictoryScreen extends AnchorPane {

    @FXML private ImageView background;
    @FXML private Text victoryMessage;
    @FXML private Button quit;
    @FXML private Button playAgain;
    @FXML private Button nextGame;
    @FXML private Text detailsMessage;
    @FXML private Text treasureMessage;


    VictoryScreen(String message)throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VictoryScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        victoryMessage.textProperty().set(message);
        bindViewModel();
        Animations.fadeIn(this).play();
    }

    VictoryScreenViewModel viewModel = new VictoryScreenViewModel();

    @FXML
    protected void handleQuitButtonClick(){
        Platform.exit();
    }
    @FXML
    protected void handlePlayAgainClick()throws Exception{
        FadeTransition fadeTransition = Animations.fadeOut(this);
        fadeTransition.setOnFinished(evt -> {
            try {
                getScene().setRoot(viewModel.restartGame());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        fadeTransition.play();
    }

    private void bindViewModel(){
        detailsMessage.textProperty().bindBidirectional(viewModel.detailsProperty());
        treasureMessage.textProperty().bindBidirectional(viewModel.treasureProperty());
    }

}
