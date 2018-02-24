package com.github.kovacstamas.zsirozas;

import com.github.kovacstamas.zsirozas.games.twoplayerzsirozas.TwoPlayerZsirozas;

public class Zsirozas {
	public static void main(String[] args) {
		System.out.println("Zsirozas 0.0.1");
		
		TwoPlayerZsirozas game = new TwoPlayerZsirozas();
		game.start();
	}

}
