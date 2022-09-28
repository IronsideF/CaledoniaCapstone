package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CardComponent extends AnchorPane {
    @FXML
    private ImageView background;
    @FXML private ImageView cardBorder;
    @FXML private ImageView cardArtBorder;
    @FXML private ImageView cardTextBackground;
    @FXML private HBox cardTextBox;
    @FXML private ImageView cardCostHolder;
    @FXML private Text cardCost;
    @FXML private ImageView cardIcon;
    private CardComponentViewModel viewModel;


    public CardComponent(ICard card) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CardComponent.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        this.viewModel = new CardComponentViewModel(card);
        bindViewModel();
    }


}
