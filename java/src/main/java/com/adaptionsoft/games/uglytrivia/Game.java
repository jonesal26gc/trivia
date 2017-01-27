package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Game {
    private static final int GOLDEN_COIN_TARGET = 6;
    private static final int NUMBER_OF_QUESTIONS_PER_CATEGORY = 50;

    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    private Console console;

    public Game(Console console) {
        this.console = console;

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

    public String createRockQuestion(int i) {
        return "Rock Question " + i;
    }

    public void takeTurn(Player player, int diceValue) {
        console.print(player.getName() + " is the current player");
        console.print("They have rolled a " + diceValue);

        if (player.isInThePenaltyBox()) {
            if (diceValue % 2 == 0) {
                console.print(player.getName() + " is not getting out of the penalty box");
                player.setGettingOutOfPenaltyBox(false);
                return;
            } else {
                player.setGettingOutOfPenaltyBox(true);
                console.print(player.getName() + " is getting out of the penalty box");
            }
        }
        player.setSquareOnTheBoard(player.getSquareOnTheBoard().move(diceValue));
        console.print(player.getName()
                + "'s new location is "
                + player.getSquareOnTheBoard().ordinal());
        console.print("The category is " + player.getSquareOnTheBoard().getQuestionCategory().label);
        askQuestion(player.getSquareOnTheBoard().getQuestionCategory());
    }

    private void askQuestion(QuestionCategory questionCategory) {
        try {
            switch (questionCategory) {
                case POP: {
                    console.print(popQuestions.removeFirst().toString());
                    break;
                }
                case SCIENCE: {
                    console.print(scienceQuestions.removeFirst().toString());
                    break;
                }
                case SPORTS: {
                    console.print(sportsQuestions.removeFirst().toString());
                    break;
                }
                case ROCK: {
                    console.print(rockQuestions.removeFirst().toString());
                    break;
                }
            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            console.print("no questions left in the " + questionCategory.label + " category");
        }
    }

    private void askQuestion2(QuestionCategory questionCategory) {
        try {
            LinkedList listToExtractFrom = getQuestionsForCategory(questionCategory);
            console.print(listToExtractFrom.removeFirst().toString());
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            console.print("no questions left in the " + questionCategory.label + " category");
        }
    }

    private LinkedList getQuestionsForCategory(QuestionCategory questionCategory) {
        switch (questionCategory) {
            case POP:
                return popQuestions;

            case SCIENCE:
                return scienceQuestions;

            case SPORTS:
                return sportsQuestions;

            default:
            case ROCK:
                return rockQuestions;
        }
    }

    public boolean correctAnswerAndCheckForWin(Player player) {
        console.print("Answer was correct!!!!");
        if (player.isInThePenaltyBox()) {
            if (!player.isGettingOutOfPenaltyBox()) {
                return false;
            } else {
                player.setInThePenaltyBox(false);
                player.setGettingOutOfPenaltyBox(false);
            }
        }
        player.setNumberOfGoldenCoins(player.getNumberOfGoldenCoins() + 1);
        console.print(player.getName()
                + " now has "
                + player.getNumberOfGoldenCoins()
                + " Gold Coins.");
        return (player.getNumberOfGoldenCoins() == GOLDEN_COIN_TARGET);
    }

    public void wrongAnswer(Player player) {
        console.print("Question was incorrectly answered");
        console.print(player.getName() + " was sent to the penalty box");
        player.setInThePenaltyBox(true);
        player.setGettingOutOfPenaltyBox(false);
    }
}
