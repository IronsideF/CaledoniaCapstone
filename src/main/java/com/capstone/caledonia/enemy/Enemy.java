package com.capstone.caledonia.enemy;

import com.capstone.caledonia.card.EffectType;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Enemy {

    protected int health;
    protected int maxHealth;
    protected int block;
    protected Image enemySprite;
    protected ArrayList<Attack> attacks;
    protected Boolean isDead;
    protected ArrayList<Attack> intent;
    protected ArrayList<Image> sprites = new ArrayList<>();

    public ArrayList<Attack> generateAttacks() {
        Attack attack1 = new Attack(9, EffectType.ARMOUR, 6);
        Attack attack2 = new Attack(13, EffectType.DAMAGE, 0);
        Attack attack3 = new Attack(6, EffectType.HEAL, 7);
        return new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
    }

    public ArrayList<Attack> generateAttacks(int bonus) {
        Attack attack1 = new Attack((int)(Math.random() * 6 + 3 + bonus), EffectType.ARMOUR, (int)(Math.random() * 3 + 3 + bonus));
        Attack attack2 = new Attack((int)(Math.random() * 10 + 3 + bonus) , EffectType.DAMAGE, 0);
        Attack attack3 = new Attack((int)(Math.random() * 6 + 3 + bonus), EffectType.HEAL, (int)(Math.random() * 4 + 3 + bonus));
        return new ArrayList<>(Arrays.asList(attack1, attack2, attack3));
    }

    public Enemy() {
        this.health = 37;
        this.maxHealth = health;
        this.block = 0;
        this.attacks = generateAttacks();
        this.isDead = false;
        this.enemySprite = new Image(getClass().getResource("/RedWormIdle.gif").toExternalForm());
        this.intent = new ArrayList<>();
    }


    public Enemy(int bonus) {
        this.health = (int)((Math.random() * ((bonus + 1) * 10) + ((bonus + 1) * 5)));
        this.maxHealth = health;
        this.block = 0;
        this.attacks = generateAttacks(bonus);
        this.isDead = false;
        this.sprites.add(new Image(getClass().getResource("/SkeletonIdle.gif").toExternalForm()));
        this.sprites.add(new Image(getClass().getResource("/MushroomIdle.gif").toExternalForm()));
        this.sprites.add(new Image(getClass().getResource("/GoblinIdle.gif").toExternalForm()));
        this.sprites.add(new Image(getClass().getResource("/RedWormIdle.gif").toExternalForm()));
        Random rand = new Random();
        this.enemySprite = sprites.get(rand.nextInt(4));
        this.intent = new ArrayList<>();
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
        for (Attack attack: intent){
            attack.useAttack(this, player);
        }
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

    public ArrayList<Attack> getIntent() {
        return intent;
    }

    public void addToIntent(Attack attack){
        intent.add(attack);
    }
    public void clearIntent(){
        intent.clear();
    }

    public void setIntent(){
        int i = (int)(Math.random() * this.attacks.size());
        addToIntent(attacks.get(i));
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


