package com.capstone.caledonia.card;

import org.w3c.dom.ls.LSOutput;

import java.security.SecureRandom;
import java.util.ArrayList;

public class CardBuilder {
    private ArrayList<CardDmg> cardDmgs;
    private ArrayList<CardEff> cardEffs;
    private static final SecureRandom random = new SecureRandom();
    private int enumIndex;

    public CardBuilder(int bonus) {
        this.cardEffs = generateCardEffects(bonus);
        this.cardDmgs = generateCardDamages(bonus);
        this.enumIndex = 0;
    }

    public ArrayList<CardDmg> generateCardDamages(int bonus) {
        ArrayList<CardDmg> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int cost;
            int damage = ((int)(Math.random() * 4) + 1 + bonus);
            damage -= (int)(Math.random()) * 3;
            if (damage <= 0) {
                damage = 1;
            }
            if (damage <= 1) {
                cost = 0;
            } else if (damage > 1 && damage < 7) {
                cost = 1;
            } else if (damage >= 7 && damage <= 10){
                cost = 2;
            } else {
                cost = 3;
            }
            CardDmg cardDmg = new CardDmg(damage, cost);
            result.add(cardDmg);
        }
        return result;
    }

    public ArrayList<CardEff> generateCardEffects(int bonus) {
        ArrayList<CardEff> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int cost;
            int effect;
            EffectType type = randomEnum(EffectType.class);
            if (type == EffectType.DRAW) {
                effect = ((int)(Math.random() * 2) + 1 + (bonus / 3));
                cost = effect;
            } else {
                effect = ((int)(Math.random() * 6) + 1 + bonus);
                effect -= (int)(Math.random()) * 3;
                if (effect <= 0) {
                    effect = 1;
                }
                if (effect <= 1) {
                    cost = 0;
                } else if (effect > 1 && effect < 7) {
                    cost = 1;
                } else if (effect >= 7 && effect <= 11){
                    cost = 2;
                } else {
                    cost = 3;
                }
            }
            if (type == EffectType.HEAL) {
                cost += 1;
            } else if (type == EffectType.DAMAGE) {
                effect *= 1.5;
            }
            CardEff cardEff = new CardEff(effect, cost, type);
            result.add(cardEff);
        }
        return result;
    }

    public <T extends Enum<EffectType>> T randomEnum(Class<T> clazz){
        this.enumIndex += 1;
        if (this.enumIndex > 3) {
            this.enumIndex = 0;
        }
        return clazz.getEnumConstants()[this.enumIndex];
    }

    public ArrayList<CardDmg> getCardDmgs() {
        return cardDmgs;
    }

    public ArrayList<CardEff> getCardEffs() {
        return cardEffs;
    }

    public void addCardDmg(CardDmg cardDmg) {
        this.cardDmgs.add(cardDmg);
    }

    public void addCardEff(CardEff cardEff) {
        this.cardEffs.add(cardEff);
    }

    public CardDmg getRandomDmg() {
        int i = (int)(Math.random() * this.cardDmgs.size());
        return this.cardDmgs.get(i);
    }

    public CardEff getRandomEff() {
        int i = (int)(Math.random() * this.cardEffs.size());
        return this.cardEffs.get(i);
    }

    public CardGenerated buildCard() {
        CardEff genEff = this.getRandomEff();
        if (genEff.getType() == EffectType.DRAW) {
            CardDmg dmg = new CardDmg(0,0);
            return new CardGenerated(dmg, genEff);
        } else {
            return new CardGenerated(this.getRandomDmg(), genEff);
        }
    }
}
