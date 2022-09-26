package com.capstone.caledonia.card;

import com.capstone.caledonia.player.Deck;
import com.capstone.caledonia.player.Hand;
import com.capstone.caledonia.player.Player;

public class CardBuilt implements ICard{
    private int dmg;
    private EffectType type;
    private int effect;
    private int cost;

    public CardBuilt(int dmg, int effect, int cost, EffectType type) {
        this.dmg = dmg;
        this.effect = effect;
        this.cost = cost;
        this.type = type;
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

    public void useEffect(Player player) {
        if (this.type == EffectType.ARMOUR) {
            player.addArmour(this.effect);
        } else if (this.type == EffectType.DAMAGE) {
            this.dmg += this.effect;
            this.dealDamage(dmg);
        } else {
            player.healHealth(this.effect);
        }
    }

    public void dealDamage(int dmg /*Enemy enemy*/) {

    }

    public int getDamage() {
        if (this.type == EffectType.DAMAGE) {
            return this.dmg + this.effect;
        }
        return this.dmg;
    }
}

