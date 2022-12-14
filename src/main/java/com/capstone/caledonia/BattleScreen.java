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
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    private Text energy;
    @FXML private Text maxEnergy;
    @FXML private Text playerHealthInt;
    @FXML private Text playerMaxHealthInt;
    @FXML private Text enemyHealthInt;
    @FXML private Text enemyMaxHealthInt;
    @FXML private Text playerBlock;
    @FXML private Text enemyBlock;
    @FXML private Button nextScreen;
    @FXML private Text treasureCount;
    @FXML private HBox enemyIntentBox;
    @FXML private VBox enemyContainer;
    @FXML private HBox healthNumbers;
    @FXML private Text energySlash;
    @FXML private HBox playerBlockBox;
    @FXML private HBox enemyBlockBox;

    private final BattleScreenViewModel viewModel = new BattleScreenViewModel();
    public BattleScreen()throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleScreen.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        bindViewModel();
        rebuildHand();
        buildEnemyIntent();
        Background enemyIntentBackground = new Background(new BackgroundImage(new Image(getClass().getResource("/EnemyIntentBackground.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        enemyIntentBox.setBackground(enemyIntentBackground);
        if (viewModel.checkIfNight()){
            setNightPositions();
        }
        if (viewModel.isBossNode()){
            enemyContainer.setLayoutY(29);
        }
        Animations.fadeIn(this).play();
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
        Bindings.bindBidirectional(deckCount.textProperty(), viewModel.deckCountProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(discardCount.textProperty(), viewModel.discardCountProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(
                energy.textProperty(),
                viewModel.energyProperty(),
                new NumberStringConverter());
        Bindings.bindBidirectional(treasureCount.textProperty(), viewModel.treasureCountProperty(), new NumberStringConverter());
    }

    @FXML
    protected void onQuitButtonClick(){
        Platform.exit();
    }

    private void handleCardClick(Event event) throws Exception{
        String cardID = ((CardComponent)event.getSource()).getId();
        System.out.println(((CardComponent)event.getSource()).getId());
        if(viewModel.useCard(Integer.parseInt(cardID))){
            getChildren().add(new RewardScreen(this));
        }
        rebuildHand();
    }
    @FXML
    private void handleConfirmClick()throws Exception{
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/UI_Click_1.wav").toExternalForm()));
        mediaPlayer.play();
        if(viewModel.endTurn()){
            VictoryScreen vicScreen = new VictoryScreen("Defeat!");
            getScene().setRoot(vicScreen);
        } else {
            rebuildHand();
            buildEnemyIntent();
        }

    }
    public void rebuildHand()throws Exception{
        cardBox.getChildren().clear();
        ArrayList<CardComponent> playerHand = viewModel.getPlayerHand();
        int i = 0;
        for (CardComponent card: playerHand) {
            card.setId(String.valueOf(i));
            card.setOnMouseClicked(event -> {
                        try {
                            handleCardClick(event);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    );
            cardBox.getChildren().add(card);
            i++;
        }
    }
    @FXML public void onNextScreenClick(){
            viewModel.setEnemyToOne();

    }
    public void buildEnemyIntent(){
        enemyIntentBox.getChildren().clear();
        enemyIntentBox.getChildren().addAll(viewModel.getEnemyIntent());
    }
    @FXML public void handleDeckClick()throws Exception{
        getChildren().add(new DeckScreen(this));
    }
    @FXML public void handleMapClick()throws Exception{
        getChildren().add(new MapScreen(this));
    }
    public void setNightPositions(){
        playerSprite.setLayoutX(101.0);
        playerSprite.setLayoutY(317.0);
        playerHealth.setLayoutX(45.0);
        playerHealth.setLayoutY(254.0);
        healthNumbers.setLayoutX(94);
        healthNumbers.setLayoutY(248);
        energy.setLayoutX(100);
        energy.setLayoutY(225);
        energySlash.setLayoutX(125);
        energySlash.setLayoutY(225);
        maxEnergy.setLayoutX(150);
        maxEnergy.setLayoutY(225);
        playerBlockBox.setLayoutX(254);
        playerBlockBox.setLayoutY(300);
        enemyBlockBox.setLayoutX(360);
        enemyBlockBox.setLayoutY(300);
        enemyContainer.setLayoutX(451);
        enemyContainer.setLayoutY(250);
        background.setImage(new Image(getClass().getResource("/BattleBackground800x600.png").toExternalForm()));
        background.setFitHeight(576);
    }
}
