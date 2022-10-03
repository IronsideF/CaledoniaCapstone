package com.capstone.caledonia;

import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.scene.Node;

public class Fades {
    public static FadeTransition fadeIn(Node node){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        return fadeTransition;
    }
    public static FadeTransition fadeOut(Node node){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), node);
        fadeTransition.setToValue(0);
        fadeTransition.setFromValue(1);
        return fadeTransition;
    }
}
