//package com.capstone.caledonia.testing;
//
//import com.capstone.caledonia.card.*;
//import com.capstone.caledonia.enemy.Enemy;
//import com.capstone.caledonia.player.Deck;
//import com.capstone.caledonia.player.Discard;
//import com.capstone.caledonia.player.Hand;
//import com.capstone.caledonia.player.Player;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class PlayerTesting {
//
//        Player player;
//        Deck deck;
//        CardDmg cardDmg1;
//        CardDmg cardDmg2;
//        CardDmg cardDmg3;
//        CardEff cardEff1;
//        CardEff cardEff2;
//        CardEff cardEff3;
//
//        CardGenerated cardGenerated1;
//        CardGenerated cardGenerated2;
//        CardGenerated cardGenerated3;
//        CardGenerated cardGenerated4;
//        CardGenerated cardGenerated5;
//        CardGenerated cardGenerated6;
//        CardGenerated cardGenerated7;
//        CardGenerated cardGenerated8;
//        CardGenerated cardGenerated9;
//        CardGenerated cardGenerated10;
//
//        CardBuilder cardBuilder;
//        ArrayList<ICard> cards;
//        Enemy enemy;
//
//    @Before
//    public void before() {
//        cardBuilder = new CardBuilder();
//        cardDmg1 = new CardDmg(20,1);
//        cardDmg2 = new CardDmg(20,2);
//        cardDmg3 = new CardDmg(30,2);
//        cardEff1 = new CardEff(10,1, EffectType.HEAL);
//        cardEff2 = new CardEff(20,2, EffectType.DAMAGE);
//        cardEff3 = new CardEff(30,2, EffectType.ARMOUR);
//
//        cardBuilder.addCardDmg(cardDmg1);
//        cardBuilder.addCardDmg(cardDmg2);
//        cardBuilder.addCardDmg(cardDmg3);
//        cardBuilder.addCardEff(cardEff1);
//        cardBuilder.addCardEff(cardEff2);
//        cardBuilder.addCardEff(cardEff3);
//
//        cardGenerated1 = cardBuilder.buildCard();
//        cardGenerated2 = cardBuilder.buildCard();
//        cardGenerated3 = cardBuilder.buildCard();
//        cardGenerated4 = cardBuilder.buildCard();
//        cardGenerated5 = cardBuilder.buildCard();
//        cardGenerated6 = cardBuilder.buildCard();
//        cardGenerated7 = cardBuilder.buildCard();
//        cardGenerated8 = cardBuilder.buildCard();
//        cardGenerated9 = cardBuilder.buildCard();
//        cardGenerated10 = cardBuilder.buildCard();
//
//        cards = new ArrayList();
//        cards.add(cardGenerated1);
//        cards.add(cardGenerated2);
//        cards.add(cardGenerated3);
//        cards.add(cardGenerated4);
//        cards.add(cardGenerated5);
//        cards.add(cardGenerated6);
//        cards.add(cardGenerated7);
//        cards.add(cardGenerated8);
//        cards.add(cardGenerated9);
//        cards.add(cardGenerated10);
//
//        deck = new Deck(cards);
//
//        player = new Player(100, 100, deck);
//
//        enemy = new Enemy();
//
//    }
//    @Test
//    public void playerHasCards() {
//        assertEquals(10, player.getDeck().getCards().size());
//    }
//
//    @Test
//    public void playerCanDrawCards() {
//        player.drawCards();
//        assertEquals(7,player.getHand().getHand().size());
//    }
//
//    @Test
//    public void playerCanRemoveCardFromHand() {
//        player.drawCards();
//        player.addToDiscard(cardGenerated1);
//        assertEquals(6, player.getHand().getHand().size());
//    }
//
//    @Test
//    public void playerCanEmptyHand() {
//        player.drawCards();
//        player.emptyHand();
//        assertEquals(0, player.getHand().getHand().size());
//        assertEquals(3, player.getDeck().getCards().size());
//        assertEquals(7, player.getDiscard().getDiscard().size());
//    }
//
//    @Test
//    public void playerCanResetDiscardAndDeck() {
//        player.drawCards();
//        player.emptyHand();
//        player.drawCards();
//        assertEquals(7, player.getHand().getHand().size());
//    }
//
//    @Test
//    public void playerCanDealDamage() {
//        player.drawCards();
//        player.useCard(cardGenerated1, enemy);
//        assertNotEquals(100, enemy.getHealth());
//    }
//
//    @Test
//    public void playerCanTakeDamage() {
//        enemy.attackPlayer(player);
//        assertNotEquals(100, player.getHealth());
//    }
//
//    @Test
//    public void playerCanDie() {
//        while (player.getHealth() > 0) {
//            enemy.attackPlayer(player);
//        }
//        assertTrue(player.getDead());
//    }
//
//    @Test
//    public void enemyCanDie() {
//        player.drawCards();
//        while (enemy.getHealth() > 0) {
//            player.useCard(player.getHand().getHand().get(0), enemy);
//        }
//        assertTrue(enemy.getIsDead());
//    }
//
//    @Test
//    public void playerCanGetBlock() {
//        CardBuilt block = new CardBuilt(1, 10, 1, EffectType.ARMOUR);
//        player.getHand().addCard(block);
//        player.useCard(block, enemy);
//        assertEquals(10, player.getBlock());
//    }
//
//    @Test
//    public void playerCanHeal() {
//        CardBuilt heal = new CardBuilt(1, 10, 1, EffectType.HEAL);
//        player.getHand().addCard(heal);
//        enemy.attackPlayer(player);
//        int health = player.getHealth();
//        player.useCard(heal, enemy);
//        assertNotEquals(health, player.getHealth());
//    }
//
//    @Test
//    public void blockWorks() {
//        CardBuilt block = new CardBuilt(1, 10, 1, EffectType.ARMOUR);
//        player.getHand().addCard(block);
//        player.useCard(block, enemy);
//        enemy.attackPlayer(player);
//        assertEquals(0, player.getBlock());
//        assertEquals(90, player.getHealth());
//    }
//}
