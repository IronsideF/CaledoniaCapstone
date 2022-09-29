package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Boss extends Enemy{

    public Boss() {
        super(70);
        this.attacks = generateAttacks();
    }

    public ArrayList<Attack> generateAttacks() {
        Attack attack1 = new Attack(15, EffectType.DAMAGE, 0);
        Attack attack2 = new Attack(7, EffectType.HEAL, 10);
        Attack attack3 = new Attack(10, EffectType.ARMOUR, 7);
        return new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
    }
    public void attackPlayer(Player  player) {
        int i = (int)(Math.random() * this.attacks.size());
        this.attacks.get(i).useAttack(this, player);
        int j = (int)(Math.random() * this.attacks.size());
        this.attacks.get(j).useAttack(this, player);
    }

    public void setIntent(){
        addToIntent(attacks.get((int)(Math.random() * this.attacks.size())));
        addToIntent(attacks.get((int)(Math.random() * this.attacks.size())));
    }
}
