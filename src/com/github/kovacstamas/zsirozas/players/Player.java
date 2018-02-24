package com.github.kovacstamas.zsirozas.players;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.github.kovacstamas.zsirozas.decks.cards.Card;

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
	
	public String toString() {
		return name + ": " + points + "point";
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
		int selectedCardNumber = chooseCard();
		return hand.remove(selectedCardNumber);
	}
	
	private int chooseCard() {
		int choosen = 0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Integer:");	    
	        choosen = Integer.parseInt(br.readLine());
	    }catch(Exception nfe){
	        System.err.println("Exception");
	    }
		return choosen;
	}

}
