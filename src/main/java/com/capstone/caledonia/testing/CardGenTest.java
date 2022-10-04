//package com.capstone.caledonia.testing;
//import com.capstone.caledonia.card.CardBuilder;
//import com.capstone.caledonia.card.CardGenerated;
//import com.capstone.caledonia.node.EnemyNode;
//import com.capstone.caledonia.node.TreasureNode;
//import org.junit.Test;
//import org.junit.Before;
//
//import static org.junit.Assert.*;
//
//public class CardGenTest {
//    CardBuilder cardBuilder;
//
//    CardGenerated card1;
//    CardGenerated card2;
//    CardGenerated card3;
//
////    TreasureNode treasureNode;
////    EnemyNode enemyNode;
//
//    @Before
//    public void before() {
//        cardBuilder = new CardBuilder();
//        card1 = cardBuilder.buildCard();
//        card2 = cardBuilder.buildCard();
//        card3 = cardBuilder.buildCard();
////        enemyNode = new EnemyNode();
////        treasureNode = new TreasureNode();
//    }
//
//    @Test
//    public void cardsHaveProperties() {
//        assertNotNull(card1.getCardDmg());
//        assertNotNull(card1.getCardEff());
//        System.out.printf("card1 has %s damage, %s cost, %s effect, and %s type%n", card1.getDamage(), card1.getCost(), card1.getCardEff().getEffect(), card1.getEffectType());
//        System.out.printf("card2 has %s damage, %s cost, %s effect, and %s type%n", card2.getDamage(), card2.getCost(), card2.getCardEff().getEffect(), card2.getEffectType());
//        System.out.printf("card3 has %s damage, %s cost, %s effect, and %s type%n", card3.getDamage(), card3.getCost(), card3.getCardEff().getEffect(), card3.getEffectType());
//    }
//
////    @Test
////    public void nodesHaveCards() {
////        assertNotNull(enemyNode.getRewardCard());
////        assertNotNull(treasureNode.getCardGenerateds());
////    }
//}
