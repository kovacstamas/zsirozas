package com.github.kovacstamas.zsirozas.decks.cards;

import com.github.kovacstamas.zsirozas.decks.cards.suits.Suit;

public class Card {
	Suit suit;
	CardRank rank;
	
	public Card(Suit suit, CardRank value) {
		this.suit = suit;
		this.rank = value;
	}
	
	public String toString() {
		return this.suit.toString() + " " + this.rank.toString();
	}
	
	public CardRank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
}
