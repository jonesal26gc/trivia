package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.SquareOnTheBoard;
import org.junit.Test;

import static com.adaptionsoft.games.uglytrivia.SquareOnTheBoard.*;
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
        assertThat(ZERO.move(1), is(ONE));
        assertThat(TWO.move(1), is(THREE));
        assertThat(ZERO.move(5), is(FIVE));
        assertThat(SIX.move(6), is(ZERO));
    }

    @Test(expected = RuntimeException.class)
    public void
    not_like_invalid_square() {
        SquareOnTheBoard.getSquareOnTheBoard(12);
    }
}
