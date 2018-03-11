package com.github.kovacstamas.zsirozas.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.github.kovacstamas.zsirozas.decks.cards.Card;

public class ConsolePlayerDao implements PlayerDao {
	private static final char LOWERCASE_YES = 'y';
	private static final char LOWERCASE_NO = 'n';
	private static final String ANY_STRING_REGEX = "^.*$";
	private static final String BETWEEN_START_AND_FINISH_REGEX = "^[:start-:finish]$";
	private static final String YES_NO_REGEXP = "^(Yes|yes|Y|y|No|no|N|n)$";
	
	@Override
	public Card pickCard(List<Card> hand) {
		System.out.println("Hand:");
		int i = 0;
		for(Card card : hand) {
			System.out.print(i+ ". " + card + ", ");
			i++;
		}
		System.out.println("Which card to play?");
		int selectedCardNumber = askDigitBetween(0, hand.size()-1);
		return hand.get(selectedCardNumber);
	}

	@Override
	public Card pickCardHighlighted(List<Card> hand, List<Card> highlighted) {
		System.out.println("Hand:");
		int i = 0;
		String regex = "^(";
		for(Card card : hand) {
			String str = i + ". ";
			if (highlighted.contains(card)) {
				str += "[" + card  + "], ";
				regex = regex + i + "|";
			} else {
				str += card + ", ";
			}
			System.out.print(str);
			i++;
		}
		regex = regex.substring(0, regex.length()-1) + ")$";
		System.out.println("Play a highlighted card");
		int selectedCardNumber = Integer.parseInt(askString(regex.substring(1,regex.length()-1), regex));
		return hand.remove(selectedCardNumber);
	}
	
	@Override
	public boolean makesYesNoDecision(String question) {
		System.out.println(question);
		return askBoolean();
	}
	
	private int askInteger() {
		int choosen = 0;
		choosen = Integer.parseInt(askString("integer", "^[0-9]*$"));
		return choosen;
	}
	
	private int askDigitBetween(int a, int b) {
		int choosen = 0;
		String regex = BETWEEN_START_AND_FINISH_REGEX.replaceAll(":start", String.valueOf(a)).replaceAll(":finish", String.valueOf(b));
		String message = regex.substring(1,regex.length()-1);
		choosen = Integer.parseInt(askString(message, regex));
		return choosen;
	}
	
	private boolean askBoolean() {
		boolean answer = false;
		try {
			String answerString = askString("(y)es/(n)o", YES_NO_REGEXP).toLowerCase();
			char firstChar = answerString.charAt(0); 
			if (LOWERCASE_YES == firstChar) {
				return true;
			} else if (LOWERCASE_NO == firstChar) {
				return false;
			}
			System.out.println("Answer with yes or no.");
	    } catch (Exception nfe){
	        System.err.println("Exception: " + nfe);
	    }
		return answer;
	}
	
	private String askString(String message, String regex) {
		String answer = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.print(message + " > ");
				answer = br.readLine();
			} while(!answer.matches(regex));
			
		} catch (Exception nfe){
	        System.err.println("Exception: " + nfe);
	    } 
		return answer;
	}
	
	private String askString () {
		return askString("", ANY_STRING_REGEX) ;
	}

}
