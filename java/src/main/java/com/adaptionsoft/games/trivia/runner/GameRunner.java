
package com.adaptionsoft.games.trivia.runner;
import java.util.ArrayList;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player((players.size()+1),"Chet"));
		players.add(new Player((players.size()+1),"Pat"));
		players.add(new Player((players.size()+1),"Sue"));

		
		Random rand = new Random();
	
		do {
			
			aGame.takeTurn(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.correctAnswer();
			}
			
			
			
		} while (notAWinner);
		
	}
}
