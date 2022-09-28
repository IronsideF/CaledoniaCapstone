package com.capstone.caledonia.node;

import com.capstone.caledonia.card.CardBuilder;
import com.capstone.caledonia.enemy.Boss;




public class BossNode extends EnemyNode{

    public BossNode() {
        this.enemy = new Boss();
        this.treasure = 500;
        this.cardBuilder = new CardBuilder();
        this.cardGenerated = cardBuilder.buildCard();
    }
}
