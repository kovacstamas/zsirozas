package com.github.kovacstamas.zsirozas.decks;

import java.util.Stack;

import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.decks.cards.CardRank;
import com.github.kovacstamas.zsirozas.decks.cards.suits.GermanSuit;

public class HungarianDeck extends Deck {
	
	public HungarianDeck() {
		this.cards = new Stack<Card>();
		for (GermanSuit suit: GermanSuit.values()) {
			for (CardRank value : new CardRank[] {CardRank.ACE, CardRank.KING, CardRank.OVER, CardRank.UNDER,
					CardRank.TEN, CardRank.NINE, CardRank.EIGHT, CardRank.SEVEN}) {
				this.cards.add(new Card(suit, value));
			}
		}
	}
}
