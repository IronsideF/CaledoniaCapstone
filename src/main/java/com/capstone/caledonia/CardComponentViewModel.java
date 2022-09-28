package com.capstone.caledonia;

import com.capstone.caledonia.card.ICard;
import javafx.beans.property.*;
import javafx.scene.image.Image;

public class CardComponentViewModel {
    private IntegerProperty cardCost = new SimpleIntegerProperty();
    private IntegerProperty cardDamage = new SimpleIntegerProperty();
    private ObjectProperty<Image> cardIcon = new SimpleObjectProperty<>();
    private ObjectProperty<Image> cardBackground = new SimpleObjectProperty<>();
    private ObjectProperty<Image> cardTextIcon1 = new SimpleObjectProperty<>();
    private ObjectProperty<Image> cardTextIcon2 = new SimpleObjectProperty<>();
    private StringProperty cardEffect = new SimpleStringProperty();


    CardComponentViewModel(ICard card){
        setCardCost(card.getCost());
        setCardBackground(card.getBackground());
        setCardDamage(card.getDamage());
        setCardIcon(card.getIcon());
        setCardTextIcon1(card.getTextIcon1());
        setCardTextIcon2(card.getTextIcon2());
        if (card.getEffect()!=null){
            setCardEffect(String.valueOf(card.getEffect()));
        } else {setCardEffect("");}
    }

    public int getCardCost() {
        return cardCost.get();
    }

    public IntegerProperty cardCostProperty() {
        return cardCost;
    }

    public void setCardCost(int cardCost) {
        this.cardCost.set(cardCost);
    }

    public int getCardDamage() {
        return cardDamage.get();
    }

    public IntegerProperty cardDamageProperty() {
        return cardDamage;
    }

    public void setCardDamage(int cardDamage) {
        this.cardDamage.set(cardDamage);
    }

    public Image getCardIcon() {
        return cardIcon.get();
    }

    public ObjectProperty<Image> cardIconProperty() {
        return cardIcon;
    }

    public void setCardIcon(Image cardIcon) {
        this.cardIcon.set(cardIcon);
    }

    public Image getCardBackground() {
        return cardBackground.get();
    }

    public ObjectProperty<Image> cardBackgroundProperty() {
        return cardBackground;
    }

    public void setCardBackground(Image cardBackground) {
        this.cardBackground.set(cardBackground);
    }

    public Image getCardTextIcon1() {
        return cardTextIcon1.get();
    }

    public ObjectProperty<Image> cardTextIcon1Property() {
        return cardTextIcon1;
    }

    public void setCardTextIcon1(Image cardTextIcon1) {
        this.cardTextIcon1.set(cardTextIcon1);
    }

    public Image getCardTextIcon2() {
        return cardTextIcon2.get();
    }

    public ObjectProperty<Image> cardTextIcon2Property() {
        return cardTextIcon2;
    }

    public void setCardTextIcon2(Image cardTextIcon2) {
        this.cardTextIcon2.set(cardTextIcon2);
    }

    public String getCardEffect() {
        return cardEffect.get();
    }

    public StringProperty cardEffectProperty() {
        return cardEffect;
    }

    public void setCardEffect(String cardEffect) {
        this.cardEffect.set(cardEffect);
    }
}
