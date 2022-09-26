package com.capstone.caledonia.card;

public interface ICard {
    public void useCard();

    public void discardCard();

    public void useEffect();

    public void dealDamage(int dmg);

    public int getCost();

    public int getDamage();
}
