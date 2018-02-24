package com.github.kovacstamas.zsirozas.games;

import com.github.kovacstamas.zsirozas.decks.HungarianDeck;
import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.players.Player;

public class TwoPlayerZsirozas extends Game {
	private HungarianDeck deck;
	private Player player1;
	private Player player2;
	
	@Override
	public void start() {
		initGame();
		System.out.println("The game has begun!");
		while (!deck.empty()) {
			trick();
		}
	}
	
	private void initGame() {
		deck = new HungarianDeck();
		deck.shuffle();
		
		player1 = new Player("Player 1");
		
		player2 = new Player("Player 2");
		
		deck.dealToPlayer(player1, 4);
		deck.dealToPlayer(player2, 4);
	}
	
	private void trick() {
		Card ledCard = player1.playsCard();
		System.out.println("The led card is: " + ledCard);
		Card followCard = player2.playsCard();
		System.out.println("The follow card is: " + followCard);
		
	}

}
