package com.capstone.caledonia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoadScene extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(LoadScene.class.getResource("Caledonia.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Caledonia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
