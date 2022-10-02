package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class BagScreenViewModel {
    private final Game game = Game.getInstance();

    public ArrayList<CardComponent> generateBagContents()throws Exception{
        ArrayList<CardComponent> result = new ArrayList<>();
        for (ICard card:game.player.getBag().getCards()){
            CardComponent cardComponent = new CardComponent(card);
            HBox.setMargin(cardComponent, new Insets(10,10,10, 10));
            result.add(cardComponent);
        }
        return result;
    }
}
