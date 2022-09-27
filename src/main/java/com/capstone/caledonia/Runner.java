package com.capstone.caledonia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StartUpScreen startScreen = new StartUpScreen();
        Scene scene = new Scene(startScreen);
        stage.setTitle("Caledonia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
