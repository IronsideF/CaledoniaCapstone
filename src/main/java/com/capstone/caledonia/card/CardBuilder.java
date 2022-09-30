package com.capstone.caledonia.card;

import org.w3c.dom.ls.LSOutput;

import java.security.SecureRandom;
import java.util.ArrayList;

public class CardBuilder {
    private ArrayList<CardDmg> cardDmgs;
    private ArrayList<CardEff> cardEffs;
    private static final SecureRandom random = new SecureRandom();

    public CardBuilder(int bonus) {
        this.cardEffs = generateCardEffects(bonus);
        this.cardDmgs = generateCardDamages(bonus);
    }

    public ArrayList<CardDmg> generateCardDamages(int bonus) {
        ArrayList<CardDmg> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int cost;
            int damage = ((int)(Math.random() * 6) + 1 + bonus);
            if (damage <= 2) {
                cost = 0;
            } else if (damage > 2 && damage <= 5) {
                cost = 1;
            } else if (damage > 5 && damage <= 8){
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
        for (int i = 0; i < 6; i++) {
            int cost;
            int effect = ((int)(Math.random() * 7) + 1 + bonus);
            EffectType type = randomEnum(EffectType.class);
            if (effect > 2 && effect <= 5) {
                cost = 1;
            } else if (effect <= 2) {
                cost = 0;
            } else if (effect > 5 && effect <= 8){
                cost = 2;
            } else {
                cost = 3;
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

    public static <T extends Enum<EffectType>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
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
        return new CardGenerated(this.getRandomDmg(), this.getRandomEff());
    }
}
