package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.SquareOnTheBoard;
import org.junit.Test;

public class SquareOnTheBoardShould {

    @Test
    public void
    list_the_squares_on_the_board() {
        for (int i = 0; i < 12; i++) {
            System.out.println("Square " + i + "=" + SquareOnTheBoard.getSquareOnTheBoard(i).getSubject().name());
        }
    }
}
