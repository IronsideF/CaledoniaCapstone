package com.capstone.caledonia.node;

import com.capstone.caledonia.card.ICard;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public interface INode {
    AnchorPane buildView() throws Exception;
    int getTreasure();
    ICard getRewardCard();

    ICard createRewardCard(int bonus);

    public ArrayList<ICard> createArrayOfRewardCards(int bonus);
    Image getIcon();


}
