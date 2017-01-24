package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.SquareOnTheBoard;

public class Player {
    private String name;
    private int numberOfGoldenCoins = 0;
    private SquareOnTheBoard squareOnTheBoard = SquareOnTheBoard.ZERO;
    private boolean inThePenaltyBox = false;
    private boolean isGettingOutOfPenaltyBox = false;

    public Player(String name) {
        this.name = name;
    }

    public boolean isInThePenaltyBox() {
        return inThePenaltyBox;
    }

    public void setInThePenaltyBox(boolean inThePenaltyBox) {
        this.inThePenaltyBox = inThePenaltyBox;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGoldenCoins() {
        return numberOfGoldenCoins;
    }

    public void setNumberOfGoldenCoins(int numberOfGoldenCoins) {
        this.numberOfGoldenCoins = numberOfGoldenCoins;
    }

    public SquareOnTheBoard getSquareOnTheBoard() {
        return squareOnTheBoard;
    }

    public void setSquareOnTheBoard(SquareOnTheBoard squareOnTheBoard) {
        this.squareOnTheBoard = squareOnTheBoard;
    }
}


