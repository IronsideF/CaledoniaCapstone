package com.capstone.caledonia.node;

import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.enemy.Boss;
import javafx.scene.image.Image;


public class BossNode extends EnemyNode{

    public BossNode() {
        super(0);
        this.enemy = new Boss();
        this.treasure = 500;
        this.cardBuilder = new CardBuilder(1);
        this.cardGenerated = cardBuilder.buildCard();
        this.icon = new Image(getClass().getResource("/BossIcon.png").toExternalForm());
    }
}
