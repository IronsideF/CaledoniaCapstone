package com.capstone.caledonia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BagScreen extends AnchorPane{

    @FXML
    private VBox bagBox;
    @FXML private Button closeButton;
    private BagScreenViewModel viewModel = new BagScreenViewModel();
    private AnchorPane parent;

    public BagScreen(AnchorPane parent)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BagScreen.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        this.parent = parent;
        populateBag();
    }

    @FXML public void onCloseClick(){
        parent.getChildren().remove(this);
    }
    public void populateBag()throws Exception{
        ArrayList<HBox> cardRows = new ArrayList<>();
        HBox cardRow = new HBox();
        cardRow.setAlignment(Pos.CENTER);
        ArrayList<CardComponent> cardList = viewModel.generateBagContents();
        for (CardComponent card: cardList){
            if (cardRow.getChildren().size()<2){
                cardRow.getChildren().add(card);
            } else {
                cardRows.add(cardRow);
                cardRow = new HBox();
                cardRow.setAlignment(Pos.CENTER);
                cardRow.getChildren().add(card);
            }
            if (cardList.indexOf(card)==cardList.size()-1){
                cardRows.add(cardRow);
            }
        }
        bagBox.getChildren().addAll(cardRows);
    }

}
