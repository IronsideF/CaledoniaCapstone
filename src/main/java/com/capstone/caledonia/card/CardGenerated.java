package com.capstone.caledonia.card;

import com.capstone.caledonia.enemy.Enemy;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

public class CardGenerated implements ICard{

    private CardDmg cardDmg;
    private CardEff cardEff;

    private int totalCost;

    public CardGenerated(CardDmg cardDmg, CardEff cardEff) {
        this.cardDmg = cardDmg;
        this.cardEff = cardEff;
        this.totalCost = this.findTotalCost();
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

    public void useEffect(Player player, Enemy enemy) {
        int dmg = this.cardDmg.getDamage();
        if (this.cardEff.getType() == EffectType.ARMOUR) {
            player.addArmour(this.cardEff.getEffect());
        } else if (this.cardEff.getType() == EffectType.DAMAGE) {
            dmg += this.cardEff.getEffect();
        } else {
            player.healHealth(this.cardEff.getEffect());
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

    public Image getCardImage() {
        return null;
    }

    @Override
    public Image getBackground() {
        return null;
    }

    @Override
    public Image getTextIcon1() {
        return null;
    }

    @Override
    public Image getTextIcon2() {
        return null;
    }

    @Override
    public Image getIcon() {
        return null;
    }

    @Override
    public int getEffect() {
        return 0;
    }
}
