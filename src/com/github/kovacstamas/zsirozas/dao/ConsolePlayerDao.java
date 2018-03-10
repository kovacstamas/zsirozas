package com.github.kovacstamas.zsirozas.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.github.kovacstamas.zsirozas.decks.cards.Card;

public class ConsolePlayerDao implements PlayerDao {
	private String name;
	
	@Override
	public Card pickCard(List<Card> hand) {
		System.out.println(" hand:");
		int i = 0;
		for(Card card : hand) {
			System.out.print(i+ ". " + card + ", ");
			i++;
		}
		System.out.println("Which card to play?");
		int selectedCardNumber = askInteger();
		return hand.get(selectedCardNumber);
	}

	@Override
	public Card pickCardHighlighted(List<Card> hand, List<Card> highlighted) {
		System.out.println(" hand:");
		int i = 0;
		for(Card card : hand) {
			String str = i + ". ";
			if (highlighted.contains(card)) {
				str += "[" + card  + "], ";
			} else {
				str += card + ", ";
			}
			System.out.print(str);
			i++;
		}
		System.out.println("Play a highlighted card");
		int selectedCardNumber = askInteger();
		while(!highlighted.contains(hand.get(selectedCardNumber))) {
			System.out.println("You are not allowed to play that card. You have to play a highlighted one");
			selectedCardNumber = askInteger();
		}
		return hand.remove(selectedCardNumber);
	}
	
	public boolean makesYesNoDecision(String question) {
		System.out.println(question);
		return askBoolean();
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

}
