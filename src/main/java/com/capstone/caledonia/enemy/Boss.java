package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Boss extends Enemy{
    private int health;
    private int maxHealth;
    private int block;
//    private Image enemySprite;
    private ArrayList<Attack> attacks;
    private Boolean isDead;

    public Boss() {
        this.health = 70;
        this.maxHealth = this.health;
        this.block = 0;
        this.attacks = generateAttacks();
        this.isDead = false;
    }

    public ArrayList<Attack> generateAttacks() {
        Attack attack1 = new Attack(15, EffectType.DAMAGE, 0);
        Attack attack2 = new Attack(7, EffectType.HEAL, 10);
        Attack attack3 = new Attack(10, EffectType.ARMOUR, 7);
        ArrayList result = new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
        return result;
    }
    public void attackPlayer(Player  player) {
        int i = (int)(Math.random() * this.attacks.size());
        this.attacks.get(i).useAttack(this, player);
        int j = (int)(Math.random() * this.attacks.size());
        this.attacks.get(j).useAttack(this, player);
    }
}
