package com.github.kovacstamas.zsirozas.players;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.github.kovacstamas.zsirozas.decks.cards.Card;
import com.github.kovacstamas.zsirozas.decks.cards.CardRank;

public class Player {
	protected List<Card> hand;
	private String name;
	private int points;
	
	public Player(String name) {
		this.hand = new ArrayList<Card>();
		this.name = name;
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
	
	public Card playsCard() {
		System.out.println(name + " hand:");
		int i = 0;
		for(Card card : hand) {
			System.out.print(i+ ". " + card + ", ");
			i++;
		}
		System.out.println("Which card to play?");
		int selectedCardNumber = askInteger();
		return hand.remove(selectedCardNumber);
	}
	
	public Card playsCardInRank(CardRank rank) {
		System.out.println(name + " hand:");
		int i = 0;
		for(Card card : hand) {
			String str = i + ". ";
			if (card.getRank().equals(rank)) {
				str += "[" + card  + "], ";
			} else {
				str += card + ", ";
			}
			System.out.print(str);
			i++;
		}
		System.out.println("Play a card with the rank " + rank);
		int selectedCardNumber = askInteger();
		while(!hand.get(selectedCardNumber).getRank().equals(rank)) {
			System.out.println("You are not allowed to play that card. You have to play one with the rank " + rank);
			selectedCardNumber = askInteger();
		}
		return hand.remove(selectedCardNumber);
	}
	
	public Card playsCardInRankOrSeven(CardRank rank) {
		System.out.println(name + " hand:");
		int i = 0;
		for(Card card : hand) {
			String str = i + ". ";
			if (card.getRank().equals(rank) || card.getRank().equals(CardRank.SEVEN)) {
				str += "[" + card  + "], ";
			} else {
				str += card + ", ";
			}
			System.out.print(str);
			i++;
		}
		System.out.println("Play a card with the rank " + rank);
		int selectedCardNumber = askInteger();
		while(!hand.get(selectedCardNumber).getRank().equals(rank) && !hand.get(selectedCardNumber).getRank().equals(CardRank.SEVEN)) {
			System.out.println("You are not allowed to play that card. You have to play one with the rank " + rank);
			selectedCardNumber = askInteger();
		}
		return hand.remove(selectedCardNumber);
	}
	
	public boolean wantsToContinue() {
		System.out.println(name + ", do you wish to continue the trick?");
		return askBoolean();
		
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
	
	private int askInteger() {
		int choosen = 0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Integer: ");	    
	        choosen = Integer.parseInt(br.readLine());
	    }catch(Exception nfe){
	        System.err.println("Exception");
	    }
		return choosen;
	}
	
	private boolean askBoolean() {
		boolean answer = false;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter true/false: ");	    
	        answer = Boolean.parseBoolean(br.readLine());
	    }catch(Exception nfe){
	        System.err.println("Exception");
	    }
		return answer;
	}
	
	public String toString() {
		return name;
	}

}
