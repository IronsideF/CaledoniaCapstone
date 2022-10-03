package com.capstone.caledonia;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
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
//    @FXML private ImageView bagButton;
    private AnchorPane parent;
    private DeckScreenViewModel viewModel = new DeckScreenViewModel();
    private BagScreen bagScreen = new BagScreen(this);

    public DeckScreen(AnchorPane parent)throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeckScreen.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        if (parent instanceof TreasureScreen){
            getChildren().add(bagScreen);
        }
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
        int i = 0;
        ArrayList<CardComponent> cardList = viewModel.generateGridCards();
        for (CardComponent card: cardList){
            card.setId(String.valueOf(i));
            card.setOnMouseClicked(evt -> {
                try {
                    handleCardClick(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            i++;
            if (cardRow.getChildren().size()<4){
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
        cardBox.getChildren().clear();
        cardBox.getChildren().addAll(cardRows);
    }
//    @FXML public void onBagClick()throws Exception{
//        bagScreen.setVisible(true);
//    }
    public void handleCardClick(Event event)throws Exception{
        if (parent instanceof TreasureScreen){
        int cardId = Integer.parseInt(((CardComponent)event.getSource()).getId());
        viewModel.moveCardToBag(cardId);
        populateCardGrid();
        bagScreen.populateBag();}
    }

}
