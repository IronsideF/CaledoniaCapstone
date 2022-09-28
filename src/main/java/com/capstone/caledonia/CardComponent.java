package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class CardComponent extends AnchorPane {
    @FXML
    private ImageView cardBackground;
    @FXML private ImageView cardBorder;
    @FXML private ImageView cardArtBorder;
    @FXML private ImageView cardTextBackground;
    @FXML private HBox cardTextBox;
    @FXML private ImageView cardCostHolder;
    @FXML private Text cardCost;
    @FXML private ImageView cardIcon;
    private Text cardDamage;
    private Text cardEffect;
    private ImageView textIcon1;
    private ImageView textIcon2;
    private CardComponentViewModel viewModel;


    public CardComponent(ICard card) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CardComponent.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        generateCardText();
        this.viewModel = new CardComponentViewModel(card);
        bindViewModel();
    }

    private void bindViewModel(){
        Bindings.bindBidirectional(cardCost.textProperty(), viewModel.cardCostProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(cardDamage.textProperty(), viewModel.cardDamageProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(cardEffect.textProperty(), viewModel.cardEffectProperty());
        textIcon1.imageProperty().bindBidirectional(viewModel.cardTextIcon1Property());
        textIcon2.imageProperty().bindBidirectional(viewModel.cardTextIcon2Property());
        cardIcon.imageProperty().bindBidirectional(viewModel.cardIconProperty());
        cardBackground.imageProperty().bindBidirectional(viewModel.cardBackgroundProperty());
    }

    private void generateCardText (){
        cardDamage = new Text();
        cardEffect = new Text();
        textIcon1 = new ImageView();
        textIcon2 = new ImageView();
        cardTextBox.getChildren().add(cardDamage);
        cardTextBox.getChildren().add(textIcon1);
        cardTextBox.getChildren().add(cardEffect);
        cardTextBox.getChildren().add(textIcon2);
    }


}
