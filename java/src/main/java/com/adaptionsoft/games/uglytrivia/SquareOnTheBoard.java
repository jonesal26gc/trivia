package com.adaptionsoft.games.uglytrivia;

import static com.adaptionsoft.games.uglytrivia.QuestionCategory.*;

public enum SquareOnTheBoard {
    ZERO(POP),
    ONE(SCIENCE),
    TWO(SPORTS),
    THREE(ROCK),
    FOUR(POP),
    FIVE(SCIENCE),
    SIX(SPORTS),
    SEVEN(ROCK),
    EIGHT(POP),
    NINE(SCIENCE),
    TEN(SPORTS),
    ELEVEN(ROCK);

    private static final int NUMBER_OF_SQUARES_ON_THE_BOARD = SquareOnTheBoard.values().length;
    private QuestionCategory questionCategory;

    SquareOnTheBoard(QuestionCategory subject) {
        this.questionCategory = subject;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public static SquareOnTheBoard getSquareOnTheBoard(int number) {
        try {
            return SquareOnTheBoard.values()[number];
        } catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Square number " + number + " is invalid");
        }
    }

    public SquareOnTheBoard move(int numberOfSquares) {
        int newSquareNumber = this.ordinal() + numberOfSquares;
        if (newSquareNumber >= NUMBER_OF_SQUARES_ON_THE_BOARD) {
            newSquareNumber = newSquareNumber - NUMBER_OF_SQUARES_ON_THE_BOARD;
        }
        return getSquareOnTheBoard(newSquareNumber);
    }
}
