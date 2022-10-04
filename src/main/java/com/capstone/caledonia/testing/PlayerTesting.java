package com.capstone.caledonia.testing;

import com.capstone.caledonia.card.*;
import com.capstone.caledonia.enemy.Enemy;
import com.capstone.caledonia.player.Deck;
import com.capstone.caledonia.player.Discard;
import com.capstone.caledonia.player.Hand;
import com.capstone.caledonia.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTesting {

        Player player;
        Deck deck;
        CardDmg cardDmg1;
        CardDmg cardDmg2;
        CardDmg cardDmg3;
        CardEff cardEff1;
        CardEff cardEff2;
        CardEff cardEff3;

        CardGenerated cardGenerated1;
        CardGenerated cardGenerated2;
        CardGenerated cardGenerated3;
        CardGenerated cardGenerated4;
        CardGenerated cardGenerated5;
        CardGenerated cardGenerated6;
        CardGenerated cardGenerated7;
        CardGenerated cardGenerated8;
        CardGenerated cardGenerated9;
        CardGenerated cardGenerated10;

        CardBuilder cardBuilder;
        ArrayList<ICard> cards;
        Enemy enemy;
        CardEff cardEff4;

    @Before
    public void before() {
        cardBuilder = new CardBuilder(0);
        cardDmg1 = new CardDmg(20,1);
//        cardDmg2 = new CardDmg(20,2);
//        cardDmg3 = new CardDmg(30,2);
//        cardEff1 = new CardEff(10,1, EffectType.HEAL);
//        cardEff2 = new CardEff(20,2, EffectType.DAMAGE);
//        cardEff3 = new CardEff(30,2, EffectType.ARMOUR);
        cardEff4 = new CardEff(2, 1, EffectType.DRAW);

        cardBuilder.addCardDmg(cardDmg1);
//        cardBuilder.addCardDmg(cardDmg2);
//        cardBuilder.addCardDmg(cardDmg3);
//        cardBuilder.addCardEff(cardEff1);
//        cardBuilder.addCardEff(cardEff2);
        cardBuilder.addCardEff(cardEff4);

        cardGenerated1 = cardBuilder.buildCard();
        cardGenerated2 = cardBuilder.buildCard();
        cardGenerated3 = cardBuilder.buildCard();
        cardGenerated4 = cardBuilder.buildCard();
        cardGenerated5 = cardBuilder.buildCard();
        cardGenerated6 = cardBuilder.buildCard();
        cardGenerated7 = cardBuilder.buildCard();
        cardGenerated8 = cardBuilder.buildCard();
        cardGenerated9 = cardBuilder.buildCard();
        cardGenerated10 = cardBuilder.buildCard();

        cards = new ArrayList();
        cards.add(cardGenerated1);
        cards.add(cardGenerated2);
        cards.add(cardGenerated3);
        cards.add(cardGenerated4);
        cards.add(cardGenerated5);
        cards.add(cardGenerated6);
        cards.add(cardGenerated7);
        cards.add(cardGenerated8);
        cards.add(cardGenerated9);
        cards.add(cardGenerated10);


        deck = new Deck(cards);

        player = new Player(100, 100, deck);

        enemy = new Enemy();

    }
    @Test
    public void playerCanUseDrawCards() {
        player.drawCards(1);
        assertEquals(1, player.getHand().getHand().size());
    }
}
