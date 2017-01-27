
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Console;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;

import java.util.ArrayList;
import java.util.Random;


public class GameRunner {
    /******************************************************
     * This is a board game is which there are 12 squares.
     * You must answer a question correctly, else you go into the
     * penalty box. Throwing an odd number gets you out of the penalty box.
     * With each correct answer, you collect a gold coin.
     * 6 gold coins wins the game.
     */

    public static void main(String[] args) {
        Console console = new Console();
        Game aGame = new Game(console);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player((players.size() + 1), "Chet", console));
        players.add(new Player((players.size() + 1), "Pat", console));
        players.add(new Player((players.size() + 1), "Sue", console));

        Random rand = new Random();

        mainLoop:
        while (true) {
            for (Player player : players) {
                aGame.takeTurn(player, rand.nextInt(5) + 1);
                if (player.isInThePenaltyBox()
                        & !player.isGettingOutOfPenaltyBox()) {
                    continue;
                }
                if (rand.nextInt(9) == 7) {
                    aGame.wrongAnswer(player);
                    continue;
                }
                if (aGame.correctAnswerAndCheckForWin(player)) {
                    break mainLoop;
                }
            }
        }
        console.print("Winner!");
        System.out.print(console.getStringBuilder().toString());
    }
}
