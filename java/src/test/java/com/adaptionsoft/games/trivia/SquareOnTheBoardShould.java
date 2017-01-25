package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.SquareOnTheBoard;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareOnTheBoardShould {

    @Test
    public void
    list_the_squares_on_the_board() {
        for (int i = 0; i < 12; i++) {
            System.out.println("Square " + i + "=" + SquareOnTheBoard.getSquareOnTheBoard(i).getQuestionCategory().name());
        }
    }

    @Test
    public void
    move_square_on_the_board() {
        assertThat(SquareOnTheBoard.ZERO.move(1),is(SquareOnTheBoard.ONE));
        assertThat(SquareOnTheBoard.TWO.move(1),is(SquareOnTheBoard.THREE));
        assertThat(SquareOnTheBoard.ZERO.move(5),is(SquareOnTheBoard.FIVE));
        assertThat(SquareOnTheBoard.SIX.move(6),is(SquareOnTheBoard.ZERO));
    }
}
