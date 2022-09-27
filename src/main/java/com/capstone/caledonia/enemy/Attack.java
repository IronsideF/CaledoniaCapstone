package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;

public class Attack {
    private int damage;
    private EffectType type;
    private int effect;

    public Attack(int damage, EffectType type, int effect) {
        this.damage = damage;
        this.type = type;
        this.effect = effect;
    }

    public int getDamage() {
        return damage;
    }

    public int getEffect() {
        return this.effect;
    }

    public EffectType getType() {
        return type;
    }

    public void useAttack(Enemy enemy, Player player) {
        if (this.type == EffectType.ARMOUR) {
            enemy.addArmour(this.effect);
        } else if (this.type == EffectType.DAMAGE) {
            this.damage += this.effect;
        } else {
            enemy.healHealth(this.effect);
        }
        this.dealDamage(this.damage, player);
    }

    public void dealDamage(int damage, Player player) {
        player.takeDamage(damage);
    }
}
