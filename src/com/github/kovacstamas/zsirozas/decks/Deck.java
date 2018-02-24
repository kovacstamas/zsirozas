package com.github.kovacstamas.zsirozas.decks;

import java.util.Collections;
import java.util.Stack;

import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.players.Player;

public class Deck {
	protected Stack<Card> cards;
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void dealToPlayer(Player player, int count) {
		for (int i=0; i<count; i++) {
			Card card = cards.pop();
			player.addCardToHand(card);
		}
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public boolean empty() {
		return cards.empty();
	}
}
