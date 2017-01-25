package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import static java.nio.file.Files.readAllBytes;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FullRegressionTestWithFileCompare {
    private static final String TESTRUN_FILE_NAME = "run.txt";
    private static final String MASTER_FILE_NAME = "master.txt";

    @Test
    public void run() throws IOException {
        writeOutputTo(TESTRUN_FILE_NAME);

        runGameTimes(500);

        assertThat(readFile(TESTRUN_FILE_NAME), is(readFile(MASTER_FILE_NAME)));
    }

    private void writeOutputTo(String filename) throws FileNotFoundException {
        System.setOut(new PrintStream(new FileOutputStream(filename)));
    }

    private String readFile(String filename) throws IOException {
        return new String(readAllBytes(Paths.get(filename)));
    }

    private void runGameTimes(int numberOfGamesRun) {
        for (int seed = 0; seed < numberOfGamesRun; seed++) {
            Random rand = new Random(seed);
            runOneGame(rand);
        }
    }

    private void runOneGame(Random rand) {
        Game aGame = new Game();

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player((players.size() + 1), "Chet"));
        players.add(new Player((players.size() + 1), "Pat"));
        players.add(new Player((players.size() + 1), "Sue"));

        boolean winnerFound=false;

        mainLoop:
        while (!winnerFound) {
            for (Player player : players) {
                aGame.takeTurn(player, rand.nextInt(5) + 1);
                if (rand.nextInt(9) == 7) {
                    aGame.wrongAnswer(player);
                } else {
                    winnerFound = aGame.correctAnswer(player);
                    if (winnerFound) { break mainLoop;}
                }
            }
        }
    }
}

