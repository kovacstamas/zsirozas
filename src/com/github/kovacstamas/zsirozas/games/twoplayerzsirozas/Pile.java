package com.github.kovacstamas.zsirozas.games.twoplayerzsirozas;

import java.util.Stack;

import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.decks.cards.CardRank;

public class Pile {
	private Stack<Card> cardPile;
	private CardRank pileRank;
	
	public Pile() {
		cardPile = null;
		pileRank = null;
	}
	
	public void startPile(Card ledCard) {
		cardPile = new Stack<Card>();
		cardPile.push(ledCard);
		pileRank = ledCard.getRank();
	}
	
	public void addCard(Card card) {
		cardPile.push(card);
	}
	
	public CardRank getRank() {
		return pileRank;
	}
	
	public int getPointValue() {
		int value = 0;
		for (Card card : cardPile) {
			if (card.getRank() == CardRank.ACE || card.getRank() == CardRank.TEN ) {
				value = value + 10;
			}
		}
		return value;
	}
	
	

}
