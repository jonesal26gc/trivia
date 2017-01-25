package com.adaptionsoft.games.uglytrivia;

public enum SquareOnTheBoard {
    ZERO(0, QuestionCategory.POP),
    ONE(1, QuestionCategory.SCIENCE),
    TWO(2, QuestionCategory.SPORTS),
    THREE(3, QuestionCategory.ROCK),
    FOUR(4, QuestionCategory.POP),
    FIVE(5, QuestionCategory.SCIENCE),
    SIX(6, QuestionCategory.SPORTS),
    SEVEN(7, QuestionCategory.ROCK),
    EIGHT(8, QuestionCategory.POP),
    NINE(9, QuestionCategory.SCIENCE),
    TEN(10, QuestionCategory.SPORTS),
    ELEVEN(11, QuestionCategory.ROCK);

    static final int NUMBER_OF_SQUARES_ON_THE_BOARD = 12;
    int number;
    QuestionCategory questionCategory;

    SquareOnTheBoard(int number, QuestionCategory subject) {
        this.number = number;
        this.questionCategory = subject;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public static SquareOnTheBoard getSquareOnTheBoard(int number) {
        for (SquareOnTheBoard i : SquareOnTheBoard.values()) {
            if (i.number == number) {
                return i;
            }
        }
        throw new RuntimeException("Square number " + number + " is invalid");
    }

    public SquareOnTheBoard move(int numberOfSquares) {
        int newSquareNumber = this.number + numberOfSquares;
        if (newSquareNumber >= NUMBER_OF_SQUARES_ON_THE_BOARD) {
            newSquareNumber = newSquareNumber - NUMBER_OF_SQUARES_ON_THE_BOARD;
        }
        return getSquareOnTheBoard(newSquareNumber);
    }
}
