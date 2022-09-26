package com.capstone.caledonia.card;

public class CardGenerated implements ICard{

    private CardDmg cardDmg;
    private CardEff cardEff;

    private int totalCost;

    public CardGenerated(CardDmg cardDmg, CardEff cardEff) {
        this.cardDmg = cardDmg;
        this.cardEff = cardEff;
        this.totalCost = this.findTotalCost();
    }

    public CardDmg getCardDmg() {
        return cardDmg;
    }

    public CardEff getCardEff() {
        return cardEff;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int findTotalCost() {
        return this.cardDmg.getCost() + this.cardEff.getCost();
    }

    public void useCard() {
        //attack enemy w/ card damage
        //use the effect of the card
        //reduce the player energy by the cost of the card
    }

    public void discardCard() {
        //add the card to the discard pile and remove it from the players hand

    }

    public void useEffect() {
        if (this.cardEff.getType() == EffectType.ARMOUR) {
            //add armour to the player, equal to effect
        } else if (this.cardEff.getType() == EffectType.DAMAGE) {
            int dmg = this.cardDmg.getDamage() + this.cardEff.getEffect();
            this.dealDamage(dmg);
        } else {
            //heal the player equal to the effect
        }
    }

    public void dealDamage(int dmg) {

    }

    public int getDamage() {
        if (this.cardEff.getType() == EffectType.DAMAGE) {
            return this.cardDmg.getDamage() + this.cardEff.getEffect();
        }
        return this.cardDmg.getDamage();
    }

    public int getCost() {
        return this.totalCost;
    }
}
