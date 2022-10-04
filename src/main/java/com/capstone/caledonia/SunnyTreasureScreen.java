package com.capstone.caledonia;

import javafx.fxml.FXMLLoader;

public class SunnyTreasureScreen extends TreasureScreen{
    public SunnyTreasureScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SunnyTreasureScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        bindViewModel();
        Animations.fadeIn(this).play();
    }
}
