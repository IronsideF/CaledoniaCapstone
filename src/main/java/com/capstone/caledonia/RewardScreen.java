package com.capstone.caledonia;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class RewardScreen extends AnchorPane {
    @FXML private ImageView treasureIcon;
    @FXML private Text treasureRewardAmount;
    @FXML private VBox cardRewardHolder;
    @FXML private Button onwardsButton;
    private CardComponent rewardCard;
    private final RewardScreenViewModel viewModel = new RewardScreenViewModel();

    RewardScreen()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RewardScreen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        bindViewModel();
        addRewardCard();
    }

    private void bindViewModel(){
        Bindings.bindBidirectional(treasureRewardAmount.textProperty(), viewModel.treasureCountProperty(), new NumberStringConverter());
    }
    private void addRewardCard()throws Exception{
        CardComponent rewardCard = viewModel.getRewardCard();
        rewardCard.setOnMouseClicked(evt -> {
            handleCardClick();
        });
        cardRewardHolder.getChildren().add(rewardCard);
    }
    @FXML private void handleTreasureCollect(){
        viewModel.collectTreasure();
        treasureIcon.setVisible(false);
        treasureRewardAmount.setVisible(false);
    }
    private void handleCardClick(){
        viewModel.collectRewardCard();
        cardRewardHolder.setVisible(false);
    }
    @FXML
    private void handleOnwardsClick()throws Exception{
        getScene().setRoot(viewModel.handleNodeChange());
    }

}
