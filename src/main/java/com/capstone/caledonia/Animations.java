package com.capstone.caledonia;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import javafx.scene.Node;

public class Animations {
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
    public static ScaleTransition continuousPulse(Node node){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), node);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        return scaleTransition;
    }
    public static ScaleTransition singlePulse(Node node){
        ScaleTransition scaleTransition = new ScaleTransition(new Duration(150), node);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        return scaleTransition;
    }
}
