package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Random;

import static java.nio.file.Files.readAllBytes;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompleteRegressionTest {
    private static final String TESTRUN_FILE_NAME = "run.txt";
    private static final String MASTER_FILE_NAME = "master.txt";

    @Test
    public void runCompleteRegressionTest() throws IOException {
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
        Game aGame = createGame();

        boolean notAWinner;
        do {
            aGame.roll(rand.nextInt(5) + 1);
            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }

    private Game createGame() {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        return aGame;

    }
}

