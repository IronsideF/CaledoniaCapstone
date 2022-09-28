package com.capstone.caledonia;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TreasureScreen extends AnchorPane {

    @FXML private ImageView playerSprite;
    @FXML private ImageView background;
    @FXML private ImageView treasureChest;


    public TreasureScreen()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TreasureScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        bindViewModel();
    }

    TreasureScreenViewModel viewModel = new TreasureScreenViewModel();

    public void bindViewModel(){
        playerSprite.imageProperty().bindBidirectional(viewModel.playerSpriteProperty());
    }

    @FXML private void handleTreasureChestClick()throws Exception{
        getScene().setRoot(viewModel.collectTreasure());
    }
    @FXML private void onQuitButtonClick(){
        Platform.exit();
    }
}
