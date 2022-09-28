package com.capstone.caledonia.card;

import com.capstone.caledonia.enemy.Enemy;
import com.capstone.caledonia.player.Player;
import javafx.scene.image.Image;

public interface ICard {
    public void useEffect(Player player, Enemy enemy);

    public int getCost();

    public int getDamage();
    public Image getCardImage();
    public Image getBackground();
    public Image getTextIcon1();
    public Image getTextIcon2();
    public Image getIcon();
    public int getEffect();
}
