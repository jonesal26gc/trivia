
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;

import java.util.ArrayList;
import java.util.Random;


public class GameRunner {

    public static void main(String[] args) {
        boolean winnerFound = false;
        Game aGame = new Game();

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player((players.size() + 1), "Chet"));
        players.add(new Player((players.size() + 1), "Pat"));
        players.add(new Player((players.size() + 1), "Sue"));

        Random rand = new Random();
        mainLoop:
        while (!winnerFound) {
            for (Player player : players) {
                aGame.takeTurn(player, rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    aGame.wrongAnswer(player);
                } else {
                    winnerFound = aGame.correctAnswer(player);
                    if (winnerFound) {
                        break mainLoop;
                    }
                }
            }
        }
    }
}
