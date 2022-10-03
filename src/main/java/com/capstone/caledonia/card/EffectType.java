package com.capstone.caledonia.card;

import javafx.scene.image.Image;

import javafx.scene.media.Media;


public enum EffectType {
    HEAL("/CardHealArtIcon.png", "/CardHealTextIcon.png", "/CardBackgroundGreen.png", "/GP_Heal_1.wav"),
    ARMOUR("/CardBlockArtIcon.png", "/CardBlockTextIcon.png", "/CardBackgroundBlue.png", "/GP_Armor_Up_4.wav"),
    DAMAGE("/CardDamageArtIcon.png", "/CardDamageTextIcon.png", "/CardBackgroundRed.png", "/GP_Damage_4.wav"),
    DRAW("/CardDrawArtIcon.png", "/CardDrawTextIcon.png", "/CardBackgroundYellow.png", "/GP_Turbo_Select_1.wav");

    private Image icon;
    private Image textIcon;
    private Image background;
    private Media soundFile;

    EffectType(String icon, String textIcon, String background, String soundFile) {
        this.icon = new Image(getDeclaringClass().getResource(icon).toExternalForm());
        this.textIcon = new Image(getDeclaringClass().getResource(textIcon).toExternalForm());
        this.background = new Image(getDeclaringClass().getResource(background).toExternalForm());
        this.soundFile = new Media(getDeclaringClass().getResource(soundFile).toExternalForm());
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
    public Media getSoundFile(){
        return soundFile;
    }
}
