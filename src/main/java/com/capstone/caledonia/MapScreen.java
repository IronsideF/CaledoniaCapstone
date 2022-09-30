package com.capstone.caledonia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

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

}
