package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Game {
    private static final int GOLDEN_COIN_TARGET = 6;
    private static final int NUMBER_OF_QUESTIONS_PER_CATEGORY = 50;

    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    public Game() {
        for (int i = 0; i < NUMBER_OF_QUESTIONS_PER_CATEGORY; i++) {
            popQuestions.addLast(createPopQuestion(i));
            scienceQuestions.addLast(createScienceQuestion(i));
            sportsQuestions.addLast(createSportsQuestion(i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    private String createPopQuestion(int i) {
        return "Pop Question " + i;
    }

    private String createScienceQuestion(int i) {
        return "Science Question " + i;
    }

    private String createSportsQuestion(int i) {
        return "Sports Question " + i;
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public void takeTurn(Player player, int diceValue) {
        System.out.println(player.getName() + " is the current player");
        System.out.println("They have rolled a " + diceValue);

        if (player.isInThePenaltyBox()) {
            if (diceValue % 2 != 0) {
                player.setGettingOutOfPenaltyBox(true);
                System.out.println(player.getName() + " is getting out of the penalty box");

                player.setSquareOnTheBoard(player.getSquareOnTheBoard().move(diceValue));
                System.out.println(player.getName()
                        + "'s new location is "
                        + player.getSquareOnTheBoard().number);
                System.out.println("The category is " + player.getSquareOnTheBoard().getQuestionCategory().label);
                askQuestion(player.getSquareOnTheBoard().getQuestionCategory());
            } else {
                System.out.println(player.getName() + " is not getting out of the penalty box");
                player.setGettingOutOfPenaltyBox(false);
            }
        } else {
            player.setSquareOnTheBoard(player.getSquareOnTheBoard().move(diceValue));
            System.out.println(player.getName()
                    + "'s new location is "
                    + player.getSquareOnTheBoard().number);
            System.out.println("The category is " + player.getSquareOnTheBoard().getQuestionCategory().label);
            askQuestion(player.getSquareOnTheBoard().getQuestionCategory());
        }
    }

    private void askQuestion(QuestionCategory questionCategory) {
        try {
            switch (questionCategory) {
                case POP: {
                    System.out.println(popQuestions.removeFirst());
                    break;
                }
                case SCIENCE:{
                    System.out.println(scienceQuestions.removeFirst());
                    break;
                }
                case SPORTS:{
                    System.out.println(sportsQuestions.removeFirst());
                    break;
                }
                case ROCK:{
                    System.out.println(rockQuestions.removeFirst());
                    break;
                }
            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            System.out.println("no questions left");
        }
    }

    public boolean correctAnswer(Player player) {
        if (player.isInThePenaltyBox()) {
            if (player.isGettingOutOfPenaltyBox()) {
                System.out.println("Answer was correct!!!!");
                player.setNumberOfGoldenCoins(player.getNumberOfGoldenCoins() + 1);
                System.out.println(player.getName()
                        + " now has "
                        + player.getNumberOfGoldenCoins()
                        + " Gold Coins.");

                player.setInThePenaltyBox(false);
                player.setGettingOutOfPenaltyBox(false);

                return didPlayerWin(player.getNumberOfGoldenCoins());
            } else {
                return false;
            }

        } else {
            System.out.println("Answer was corrent!!!!");
            player.setNumberOfGoldenCoins(player.getNumberOfGoldenCoins() + 1);
            System.out.println(player.getName()
                    + " now has "
                    + player.getNumberOfGoldenCoins()
                    + " Gold Coins.");

            return didPlayerWin(player.getNumberOfGoldenCoins());
        }
    }

    public boolean wrongAnswer(Player player) {
        System.out.println("Question was incorrectly answered");
        System.out.println(player.getName() + " was sent to the penalty box");
        player.setInThePenaltyBox(true);
        player.setGettingOutOfPenaltyBox(false);
        return false;
    }

    private boolean didPlayerWin(int numberOfGoldenCoins) {
        return (numberOfGoldenCoins == GOLDEN_COIN_TARGET);
    }
}
