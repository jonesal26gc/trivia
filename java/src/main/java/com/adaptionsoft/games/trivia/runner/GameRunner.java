
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;

import java.util.ArrayList;
import java.util.Random;


public class GameRunner {

    public static void main(String[] args) {
        boolean notAWinner;
        Game aGame = new Game();

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player((players.size() + 1), "Chet"));
        players.add(new Player((players.size() + 1), "Pat"));
        players.add(new Player((players.size() + 1), "Sue"));

        Random rand = new Random();

        for (Player player : players) {
            aGame.takeTurn(player, rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer(player);
            } else {
                notAWinner = aGame.correctAnswer(player);
            }

            if (!notAWinner) break;
        }
    }
}
