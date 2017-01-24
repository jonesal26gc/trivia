package com.adaptionsoft.games.uglytrivia;

/**
 * Created by xm39 on 24/01/2017.
 */
public enum QuestionCategory {
    POP ("Pop"),
    ROCK ("Rock"),
    SCIENCE ("Science"),
    SPORTS ("Sports");

    String label;

    QuestionCategory(String label) {
        this.label = label;
    }
}
