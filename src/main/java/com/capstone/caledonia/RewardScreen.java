package com.capstone.caledonia;

import javafx.animation.FadeTransition;
import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class RewardScreen extends AnchorPane {
    @FXML private ImageView treasureIcon;
    @FXML private Text treasureRewardAmount;
    @FXML private VBox cardRewardHolder;
    @FXML private Button onwardsButton;
    @FXML private Text treasureText;
    private final RewardScreenViewModel viewModel = new RewardScreenViewModel();
    private AnchorPane parent;

    RewardScreen(AnchorPane parent)throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RewardScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        bindViewModel();
        addRewardCards();
        this.parent = parent;
    }

    private void bindViewModel(){
        Bindings.bindBidirectional(treasureRewardAmount.textProperty(), viewModel.treasureCountProperty(), new NumberStringConverter());
    }
    private void addRewardCards()throws Exception{
        int i = 0;
        HBox cardRewards = new HBox();
        for (CardComponent rewardCard: viewModel.getCardRewards()){
            rewardCard.setId(String.valueOf(i));
            i++;
            rewardCard.setOnMouseClicked(this::handleCardClick);
            HBox.setMargin(rewardCard, new Insets(10,10,10,10));
            cardRewards.getChildren().add(rewardCard);
        }
        cardRewardHolder.getChildren().add(cardRewards);
    }
    @FXML private void handleTreasureCollect(){
        viewModel.collectTreasure();
        treasureIcon.setVisible(false);
        treasureRewardAmount.setVisible(false);
        treasureText.setVisible(false);
    }
    private void handleCardClick(Event event){
        int cardId = Integer.parseInt(((CardComponent)event.getSource()).getId());
        viewModel.collectRewardCard(cardId);
        cardRewardHolder.setVisible(false);
    }
    @FXML
    private void handleOnwardsClick()throws Exception{
        FadeTransition fadeTransition = Animations.fadeOut(parent);
        fadeTransition.setOnFinished(evt -> {
            try {
                getScene().setRoot(viewModel.handleNodeChange());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        MapScreen mapScreen = new MapScreen(this);
        getChildren().add(mapScreen);
        mapScreen.handleMapTransition(fadeTransition);
    }

}
