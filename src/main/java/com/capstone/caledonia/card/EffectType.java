package com.capstone.caledonia.card;

import javafx.scene.image.Image;

public enum EffectType {
    HEAL("/CardHealArtIcon.png", "/CardHealTextIcon.png", "/CardBackgroundGreen.png"),
    ARMOUR("/CardBlockArtIcon.png", "/CardBlockTextIcon.png", "/CardBackgroundBlue.png"),
    DAMAGE("/CardDamageArtIcon.png", "/CardDamageTextIcon.png", "/CardBackgroundRed.png");

    private Image icon;
    private Image textIcon;
    private Image background;

    EffectType(String icon, String textIcon, String background) {
        this.icon = new Image(getDeclaringClass().getResource(icon).toExternalForm());
        this.textIcon = new Image(getDeclaringClass().getResource(textIcon).toExternalForm());
        this.background = new Image(getDeclaringClass().getResource(background).toExternalForm());
    }

    public Image getIcon() {
        return icon;
    }
    public Image getTextIcon(){
        return textIcon;
    }
    public Image getBackground(){
        return background;
    }
}
