package com.adaptionsoft.games.uglytrivia;

/**
 * Created by xm39 on 25/01/2017.
 */
public class Console {
    private StringBuilder stringBuilder = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public Console() {}

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void print(String printLine) {
        stringBuilder.append(printLine).append(NEW_LINE);
    }
}
