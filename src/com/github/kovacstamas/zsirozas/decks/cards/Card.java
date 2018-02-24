package com.github.kovacstamas.zsirozas.decks.cards;

import com.github.kovacstamas.zsirozas.decks.cards.suits.Suit;

public class Card {
	Suit suit;
	CardValue value;
	
	public Card(Suit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	public String toString() {
		return this.suit.toString() + " " + this.value.toString();
	}
}
