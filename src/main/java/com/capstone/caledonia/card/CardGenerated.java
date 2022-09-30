package com.capstone.caledonia.card;

import com.capstone.caledonia.enemy.Enemy;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

public class CardGenerated implements ICard{

    private CardDmg cardDmg;
    private CardEff cardEff;
    private Image background;
    private Image icon;
    private Image textIcon1;
    private Image textIcon2;
    private boolean doubleText;


    private int totalCost;

    public CardGenerated(CardDmg cardDmg, CardEff cardEff) {
        this.cardDmg = cardDmg;
        this.cardEff = cardEff;
        this.totalCost = this.findTotalCost();
        findImages();
    }

    public CardDmg getCardDmg() {
        return cardDmg;
    }

    public CardEff getCardEff() {
        return cardEff;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int findTotalCost() {
        return this.cardDmg.getCost() + this.cardEff.getCost();
    }
    private void findImages(){
        this.background = cardEff.getType().getBackground();
        this.icon = cardEff.getType().getIcon();
        this.textIcon1 = cardDmg.getIcon();
        this.textIcon2 = cardEff.getType().getTextIcon();
        this.doubleText = cardEff.getType()!=EffectType.DAMAGE;
    }

    public void useEffect(Player player, Enemy enemy) {
        int dmg = this.cardDmg.getDamage();
        if (this.cardEff.getType() == EffectType.ARMOUR) {
            player.addArmour(this.cardEff.getEffect());
        } else if (this.cardEff.getType() == EffectType.DAMAGE) {
            dmg += this.cardEff.getEffect();
        } else if (this.cardEff.getType() == EffectType.HEAL) {
            player.healHealth(this.cardEff.getEffect());
        } else {
            player.drawCards(this.cardEff.getEffect());
        }
            this.dealDamage(dmg, enemy);
    }

    public void dealDamage(int dmg, Enemy enemy) {
        enemy.takeDamage(dmg);
    }

    public int getDamage() {
        if (this.cardEff.getType() == EffectType.DAMAGE) {
            return this.cardDmg.getDamage() + this.cardEff.getEffect();
        }
        return this.cardDmg.getDamage();
    }

    public int getCost() {
        return this.totalCost;
    }

    public EffectType getEffectType() {
        return this.cardEff.getType();
    }


    @Override
    public Image getBackground() {
        return background;
    }

    @Override
    public Image getTextIcon1() {
        return textIcon1;
    }

    @Override
    public Image getTextIcon2() {
        return textIcon2;
    }

    @Override
    public Image getIcon() {
        return icon;
    }

    @Override
    public Integer getEffect() {
        if(doubleText){
        return cardEff.getEffect();}
        return null;
    }
}
