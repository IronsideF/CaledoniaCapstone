package com.capstone.caledonia.card;

import java.security.SecureRandom;
import java.util.ArrayList;

public class CardBuilder {
    private ArrayList<CardDmg> cardDmgs;
    private ArrayList<CardEff> cardEffs;
    private static final SecureRandom random = new SecureRandom();

    public CardBuilder() {
        this.cardDmgs = generateCardDamages();
        this.cardEffs = generateCardEffects();
    }

    public ArrayList<CardDmg> generateCardDamages() {
        ArrayList<CardDmg> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int cost;
            int damage = (int)(Math.random() * 10);
            if (damage <= 3) {
                cost = 0;
            } else if (damage >= 7) {
                cost = 2;
            } else {
                cost = 1;
            }
            CardDmg cardDmg = new CardDmg(damage, cost);
            result.add(cardDmg);
        }
        return result;
    }

    public ArrayList<CardEff> generateCardEffects() {
        ArrayList<CardEff> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int cost;
            int effect = (int)(Math.random() * 7);
            EffectType type = randomEnum(EffectType.class);
            if (effect >= 5) {
                cost = 2;
            } else if (effect <= 2) {
                cost = 0;
            } else {
                cost = 1;
            }
            if (type == EffectType.HEAL) {
                cost += 1;
            } else if (type == EffectType.DAMAGE) {
                effect *= 2;
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
