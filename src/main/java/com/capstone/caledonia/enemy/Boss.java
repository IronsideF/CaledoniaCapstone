package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Boss extends Enemy{

    public Boss(int bonus) {
        super(bonus);
        this.attacks = generateAttacks(bonus);
        this.enemySprite = new Image(getClass().getResource("/BossIdle.gif").toExternalForm());
    }

    public ArrayList<Attack> generateAttacks(int bonus) {
        Attack attack1 = new Attack(15 + (int)(0.5*bonus), EffectType.DAMAGE, 0);
        Attack attack2 = new Attack(7 + (int) (0.5 * bonus), EffectType.HEAL, 10 + (int)(0.5 * bonus));
        Attack attack3 = new Attack(10 + (int)(0.5 * bonus), EffectType.ARMOUR, 7 + (int)(0.5*bonus));
        return new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
    }
//    public void attackPlayer(Player  player) {
//        int i = (int)(Math.random() * this.attacks.size());
//        this.attacks.get(i).useAttack(this, player);
//        int j = (int)(Math.random() * this.attacks.size());
//        this.attacks.get(j).useAttack(this, player);
//    }

    public void setIntent(){
        addToIntent(attacks.get((int)(Math.random() * this.attacks.size())));
        addToIntent(attacks.get((int)(Math.random() * this.attacks.size())));
    }

    public void clearIntent() {
        this.intent.clear();
    }
}
