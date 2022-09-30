package com.capstone.caledonia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class DeckScreen extends AnchorPane {
    @FXML private AnchorPane shadow;
    @FXML private ScrollPane cardScroller;
    @FXML private AnchorPane gridAnchor;
    @FXML private Button exit;
    @FXML private VBox cardBox;
    private AnchorPane parent;
    private DeckScreenViewModel viewModel = new DeckScreenViewModel();

    public DeckScreen(AnchorPane parent)throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeckScreen.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        this.parent = parent;
        populateCardGrid();
    }

    public void handleExitClick(){
        parent.getChildren().remove(this);
    }
    public void populateCardGrid() throws Exception{
        ArrayList<HBox> cardRows = new ArrayList<>();
        HBox cardRow = new HBox();
        cardRow.setAlignment(Pos.CENTER);
        ArrayList<CardComponent> cardList = viewModel.generateGridCards();
        for (CardComponent card: cardList){
            if (cardRow.getChildren().size()<5){
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
        cardBox.getChildren().addAll(cardRows);
    }

}
