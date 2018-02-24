package com.github.kovacstamas.zsirozas.games.twoplayerzsirozas;

import java.util.HashMap;
import java.util.Map;

import com.github.kovacstamas.zsirozas.decks.HungarianDeck;
import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.decks.cards.CardRank;
import com.github.kovacstamas.zsirozas.games.Game;
import com.github.kovacstamas.zsirozas.players.Player;

public class TwoPlayerZsirozas extends Game {
	private HungarianDeck deck;
	private Player player1;
	private Player player2;
	private Map<PlayerRole, Player> playerRoles;
	private Pile trickPile;
	
	private static int CARDS_IN_HAND = 4;
	
	@Override
	public void start() {
		initGame();
		System.out.println("The game has begun!");
		System.out.println("----------------------------");
		int i = 0;
		while (!deck.empty()) {
			i++;
			System.out.println("");
			System.out.println("Trick no. " + i + " starts.");
			trick();
			System.out.println("Trick no. " + i + " is over. The current standing is:");
			System.out.println(player1 + ": " + player1.getPoints());
			System.out.println(player2 + ": " + player2.getPoints());
			System.out.println("");
			refillPlayerHands();
			System.out.println("");
			System.out.println("----------------------------");
		}
	}
	
	private void initGame() {
		deck = new HungarianDeck();
		deck.shuffle();
		
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		
		refillPlayerHands();
		
		playerRoles = new HashMap<PlayerRole, Player>();
		playerRoles.put(PlayerRole.TRICKLEADER, player1);
		playerRoles.put(PlayerRole.FOLLOWER, player2);
	}
	
	private void trick() {
		trickPile = new Pile();
		Player leader = playerRoles.get(PlayerRole.TRICKLEADER);
		Player follower = playerRoles.get(PlayerRole.FOLLOWER);
		
		
		Card leaderCard = leader.playsCard();
		trickPile.startPile(leaderCard);
		System.out.println("The led card is: " + leaderCard);
		
		Card followCard = follower.playsCard();
		trickPile.addCard(followCard);
		System.out.println("The follow card is: " + followCard);
		
		while (equalInRank(trickPile.getRank(), followCard) 
				&& leader.haveCardLeft()
				&& leader.haveCardInRank(trickPile.getRank())
				&& leader.wantsToContinue()) {
			leaderCard = leader.playsCard();
			trickPile.addCard(leaderCard);
			System.out.println("The led card is: " + leaderCard);
			
			followCard = follower.playsCard();
			trickPile.addCard(followCard);
			System.out.println("The follow card is: " + followCard);
		}
		
		int winning = trickPile.getPointValue();
		
		if (equalInRank(trickPile.getRank(), followCard)) {
			follower.gainPoints(winning);
			System.out.println("Trick won by: " + follower);
			
			playerRoles.clear();
			playerRoles.put(PlayerRole.TRICKLEADER, follower);
			playerRoles.put(PlayerRole.FOLLOWER, leader);
		} else {
			leader.gainPoints(winning);
			System.out.println("Trick won by: " + leader);
		}
		
	}
	
	private void refillPlayerHands() {
		int deckSize = deck.getSize();
		int neededCards = CARDS_IN_HAND - player1.getHandSize();
		int deltCards = neededCards;
		if (neededCards * 2 > deckSize) {
			deltCards = deckSize / 2;
		}
		deck.dealToPlayer(player1, deltCards);
		deck.dealToPlayer(player2, deltCards);
		System.out.println("Number of cards delt to players: " + deltCards);
	}
	
	private boolean equalInRank(CardRank ledCardValue, Card followCard) {
		if (ledCardValue.equals(followCard.getRank()) || followCard.getRank().equals(CardRank.SEVEN)) {
			return true;
		} else {
			return false;
		}
	}

}
