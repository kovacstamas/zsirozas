package com.github.kovacstamas.zsirozas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.github.kovacstamas.zsirozas.games.twoplayerzsirozas.TwoPlayerZsirozas;

public class Zsirozas {
	
	public static void main(String[] args) {
		System.out.println("Zsirozas 0.0.1");
		Properties properties = new Properties(); 
		if (args.length < 1) {
			System.out.println("Properties file name as argument is mandatory");
		}
		
		try {
			FileInputStream fis = new FileInputStream(new File(args[0]));
			properties.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		
		TwoPlayerZsirozas game = new TwoPlayerZsirozas();
		game.start(properties.getProperty("Player1Dao"), properties.getProperty("Player2Dao"));
	}

}
