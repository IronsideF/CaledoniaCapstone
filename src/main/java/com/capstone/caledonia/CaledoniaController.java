package com.capstone.caledonia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CaledoniaController {
    @FXML
    private AnchorPane anchorPane;
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


    @FXML
    protected void onStartButtonClick() {
        startButton.setVisible(false);
        endButton.setVisible(false);
        image2.setVisible(true);
    }
    @FXML
    protected void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) endButton.getScene().getWindow();
        stage.close();
    }
}