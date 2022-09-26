package com.capstone.caledonia.card;

public class CardBuilt implements ICard{
    private int dmg;
    private EffectType type;
    private int effect;
    private int cost;

    public CardBuilt(int dmg, int effect, int cost, EffectType type) {
        this.dmg = dmg;
        this.effect = effect;
        this.cost = cost;
        this.type = type;
    }

    public int getDmg() {
        return dmg;
    }

    public int getEffect() {
        return effect;
    }

    public EffectType getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public void useCard(/*Enemy enemy, Hand hand, Deck deck */) {
        //attack enemy w/ card damage affected by the effect of the card
        //reduce the player energy by the cost of the card
    }

    public void discardCard(/* Hand hand, Deck deck */) {
        //add the card to the discard pile and remove it from the players hand

    }

    public void useEffect() {
        if (this.type == EffectType.ARMOUR) {
            //add armour to the player, equal to effect
        } else if (this.type == EffectType.DAMAGE) {
            this.dmg += this.effect;
            this.dealDamage(dmg);
        } else {
            //heal the player equal to the effect
        }
    }

    public void dealDamage(int dmg /*Enemy enemy*/) {

    }
}

