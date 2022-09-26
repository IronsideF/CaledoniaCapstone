package com.capstone.caledonia.card;

import com.capstone.caledonia.player.Player;

public interface ICard {
    public void useEffect(Player player);

    public int getCost();

    public int getDamage();
}
