package com.adaptionsoft.games.uglytrivia;

public class Player {
    private int number;
    private String name;
    private int numberOfGoldenCoins = 0;
    private SquareOnTheBoard squareOnTheBoard = SquareOnTheBoard.ZERO;
    private boolean inThePenaltyBox = false;
    private boolean isGettingOutOfPenaltyBox = false;

    public Player(int number, String name) {
        this.number = number;
        this.name = name;
        System.out.println(this.name + " was added");
        System.out.println("They are player number " + this.number);
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

    public int getNumber() {
        return number;
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


