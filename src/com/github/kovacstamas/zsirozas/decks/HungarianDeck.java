package com.github.kovacstamas.zsirozas.decks;

import java.util.Stack;

import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.decks.cards.CardValue;
import com.github.kovacstamas.zsirozas.decks.cards.suits.GermanSuit;

public class HungarianDeck extends Deck {
	
	public HungarianDeck() {
		this.cards = new Stack<Card>();
		for (GermanSuit suit: GermanSuit.values()) {
			for (CardValue value : new CardValue[] {CardValue.ACE, CardValue.KING, CardValue.OVER, CardValue.UNDER,
					CardValue.TEN, CardValue.NINE, CardValue.EIGHT, CardValue.SEVEN}) {
				this.cards.add(new Card(suit, value));
			}
		}
	}
}
