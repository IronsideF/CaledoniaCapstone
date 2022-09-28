package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy {

    protected int health;
    protected int maxHealth;
    protected int block;
    protected Image enemySprite;
    protected ArrayList<Attack> attacks;
    protected Boolean isDead;

    public Enemy(int health) {
        this.health = health;
        this.maxHealth = health;
        this.block = 0;
        this.isDead = false;
    }

    public ArrayList<Attack> generateAttacks() {
        Attack attack1 = new Attack(9, EffectType.ARMOUR, 6);
        Attack attack2 = new Attack(13, EffectType.DAMAGE, 0);
        Attack attack3 = new Attack(6, EffectType.HEAL, 7);
        return new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
    }

    public Enemy() {
        this.health = 37;
        this.maxHealth = health;
        this.block = 0;
        this.attacks = generateAttacks();
        this.isDead = false;
        this.enemySprite = new Image(getClass().getResource("/SquidSprite.png").toExternalForm());
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }


    public Image getEnemySprite() {
        return enemySprite;
    }

    public void setEnemySprite(Image enemySprite) {
        this.enemySprite = enemySprite;
    }

    public void attackPlayer(Player player) {
        int i = (int)(Math.random() * this.attacks.size());
        this.attacks.get(i).useAttack(this, player);
    }

    public void takeDamage(int dmg) {
        if (this.block >= dmg) {
            this.block -= dmg;
        } else {
            int damage = (dmg - this.block);
            this.block = 0;
            this.health -= damage;
            if (this.health <= 0 ) {
                this.handleDeath();
            }
        }
    }

    public void handleDeath() {
        this.isDead = true;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public void healHealth(int val) {
        if ((val + this.health) > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health += val;
        }
    }

    public void addArmour(int val) {
        this.block += val;
    }
    public void resetBlock(){
        this.block=0;
    }
}


