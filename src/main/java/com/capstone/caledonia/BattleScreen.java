package com.capstone.caledonia;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;

public class BattleScreen extends AnchorPane{
    @FXML
    private Button mapButton;
    @FXML
    private Button deckButton;
    @FXML
    private Button quitButton;
    @FXML
    private ImageView playerSprite;
    @FXML
    private ProgressBar playerHealth;
    @FXML
    private ProgressBar enemyHealth;
    @FXML
    private HBox enemyBox;
    @FXML
    private ImageView enemySprite;
    @FXML
    private HBox cardBox;
    @FXML
    private Button confirmButton;
    @FXML
    private ImageView background;
    @FXML
    private Text deckCount;
    @FXML
    private Text discardCount;
    @FXML
    private Text handCount;
    @FXML
    private Text energy;
    @FXML private Text maxEnergy;
    @FXML private Text playerHealthInt;
    @FXML private Text playerMaxHealthInt;
    @FXML private Text enemyHealthInt;
    @FXML private Text enemyMaxHealthInt;
    @FXML private Text playerBlock;
    @FXML private Text enemyBlock;

    private final BattleScreenViewModel viewModel = new BattleScreenViewModel();
    public BattleScreen()throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleScreen.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        bindViewModel();
        cardBox.getChildren().addAll(generateHandImageViews());
    }

    private void bindViewModel(){
        playerHealth.progressProperty().bindBidirectional(viewModel.playerHealthProperty());
        enemyHealth.progressProperty().bindBidirectional(viewModel.enemyHealthProperty());
        playerSprite.imageProperty().bindBidirectional(viewModel.playerSpriteProperty());
        enemySprite.imageProperty().bindBidirectional(viewModel.enemySpriteProperty());
        Bindings.bindBidirectional(enemyBlock.textProperty(), viewModel.enemyBlockProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(playerBlock.textProperty(), viewModel.playerBlockProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(playerHealthInt.textProperty(), viewModel.playerHealthIntProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(playerMaxHealthInt.textProperty(), viewModel.playerMaxHealthIntProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(enemyMaxHealthInt.textProperty(), viewModel.enemyMaxHealthIntProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(enemyHealthInt.textProperty(), viewModel.enemyHealthIntProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(maxEnergy.textProperty(), viewModel.maxEnergyProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(handCount.textProperty(), viewModel.handCountProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(deckCount.textProperty(), viewModel.deckCountProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(discardCount.textProperty(), viewModel.discardCountProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(
                energy.textProperty(),
                viewModel.energyProperty(),
                new NumberStringConverter());
    }

    @FXML
    protected void onQuitButtonClick(){
        Platform.exit();
    }
    private ArrayList<ImageView> generateHandImageViews(){
        ArrayList<ImageView> result = new ArrayList<>();
        int i = 0;
        for (Image cardImage: viewModel.generateHandImages()){
            ImageView cardDisplay = new ImageView(cardImage);
            cardDisplay.setId(String.valueOf(i));
            cardDisplay.setOnMouseClicked(event -> {
                try {
                    handleCardClick(event);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            i++;
            result.add(cardDisplay);
        }
        return result;
    }

    private void handleCardClick(Event event) throws Exception{
        String imageID = ((ImageView)event.getSource()).getId();
        AnchorPane newScreen = viewModel.useCard(Integer.parseInt(imageID));
        rebuildHand();
        if (newScreen!=null){
        getScene().setRoot(newScreen);
        }

    }
    @FXML
    private void handleConfirmClick()throws Exception{
        if(viewModel.endTurn()){
            VictoryScreen vicScreen = new VictoryScreen("Defeat!");
            getScene().setRoot(vicScreen);
        } else {
            rebuildHand();
        }

    }
    public void rebuildHand(){
        cardBox.getChildren().clear();
        cardBox.getChildren().addAll(generateHandImageViews());
    }
}
