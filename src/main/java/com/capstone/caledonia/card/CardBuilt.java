package com.capstone.caledonia.card;

import com.capstone.caledonia.enemy.Enemy;
import com.capstone.caledonia.player.Deck;
import com.capstone.caledonia.player.Hand;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

public class CardBuilt implements ICard{
    private int dmg;
    private EffectType type;
    private int effect;
    private int cost;
    private Image cardImage;

    public CardBuilt(int dmg, int effect, int cost, EffectType type/*, Image cardImage*/) {
        this.dmg = dmg;
        this.effect = effect;
        this.cost = cost;
        this.type = type;
//        this.cardImage = cardImage;
    }

    public int getDmg() {
        return dmg;
    }

    public int getEffect() {
        return effect;
    }

    public EffectType getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public void useEffect(Player player, Enemy enemy) {
        if (this.type == EffectType.ARMOUR) {
            player.addArmour(this.effect);
        } else if (this.type == EffectType.DAMAGE) {
            this.dmg += this.effect;
        } else {
            player.healHealth(this.effect);
        }
            this.dealDamage(this.dmg, enemy);
    }

    public void dealDamage(int dmg, Enemy enemy) {
        enemy.takeDamage(dmg);
    }

    public int getDamage() {
        if (this.type == EffectType.DAMAGE) {
            return this.dmg + this.effect;
        }
        return this.dmg;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }
}

