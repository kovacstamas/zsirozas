package com.github.kovacstamas.zsirozas.dao;

import java.util.List;

import com.github.kovacstamas.zsirozas.decks.cards.Card;

public interface PlayerDao {
	
	public Card pickCard(List<Card> hand);

	public Card pickCardHighlighted(List<Card> hand, List<Card> highlighted);
	
	public boolean makesYesNoDecision(String question);
}
