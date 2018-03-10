package com.github.kovacstamas.zsirozas.players;

import java.util.ArrayList;
import java.util.List;

import com.github.kovacstamas.zsirozas.dao.PlayerDao;
import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.decks.cards.CardRank;

public class Player {
	private List<Card> hand;
	private String name;
	private int points;
	private PlayerDao dao;
	
	public Player(String name, PlayerDao dao) {
		this.hand = new ArrayList<Card>();
		this.name = name;
		this.dao = dao;
		points = 0;
	}
	
	public void addCardToHand(Card card) {
		hand.add(card);
	}
	
	public void gainPoints(int gainedPoints) {
		points = points + gainedPoints;
	}
	
	public void loosePoints(int lostPoints) {
		points = points - lostPoints;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String getName() {
		return name;
	}
	
	public Card playsCard() {
		Card pickedCard = dao.pickCard(hand);
		hand.remove(pickedCard);
		return pickedCard;
	}
	
	public Card playsCardInRank(CardRank rank) {
		List<Card> highlighted = new ArrayList<Card>();
		for (Card card : hand) {
			if (card.getRank().equals(rank)) {
				highlighted.add(card);
			}
		}
		Card pickedCard = dao.pickCardHighlighted(hand, highlighted);
		hand.remove(pickedCard);
		return pickedCard;
	}
	
	public Card playsCardInRankOrSeven(CardRank rank) {
		List<Card> highlighted = new ArrayList<Card>();
		for (Card card : hand) {
			if (card.getRank().equals(rank) || card.getRank().equals(CardRank.SEVEN)) {
				highlighted.add(card);
			}
		}
		Card pickedCard = dao.pickCardHighlighted(hand, highlighted);
		hand.remove(pickedCard);
		return pickedCard;
	}
	
	public boolean makesYesNoDecision(String question) {
		return dao.makesYesNoDecision(question);
	}
	
	public boolean haveCardInRank(CardRank rank) {
		for (Card card : hand) {
			if (card.getRank().equals(rank) || card.getRank().equals(CardRank.SEVEN)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean haveCardLeft() {
		return hand.size() > 0;
	}
	
	public int getHandSize() {
		return hand.size();
	}
	
	public String toString() {
		return name;
	}

}
