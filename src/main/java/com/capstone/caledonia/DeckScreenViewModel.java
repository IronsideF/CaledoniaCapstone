package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class DeckScreenViewModel {
    private final Game game = Game.getInstance();

    public ArrayList<CardComponent> generateGridCards() throws Exception{
        ArrayList<CardComponent> result = new ArrayList<>();
        for (ICard card:game.player.getPermaDeck().getCards()){
            CardComponent cardComponent = new CardComponent(card);
            HBox.setMargin(cardComponent, new Insets(10,10,10, 10));
            result.add(cardComponent);
        }
        return result;
    }
    public void moveCardToBag(int cardId){
        if (game.player.getBag().getCards().size()<3){
        game.moveCardFromDeckToBag(cardId);}
    }
}
