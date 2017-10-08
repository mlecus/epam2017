package com.sgalaktionov.homework6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private String string;
    private int currentPosition;
    private Matcher matcher;

    public StringParser(String string) {

        this.string = string;
        currentPosition = 0;

        String wordsSeparators ="\\s";
        Pattern wordsSeparatorsPattern = Pattern.compile(wordsSeparators);
        this.matcher = wordsSeparatorsPattern.matcher(string);
    }

    public String getNext() {

        if (currentPosition >= string.length()) {
            throw new StringIndexOutOfBoundsException("no any words more");
        }

        int nextWordEndPosition = matcher.start();
        String out = string.substring(currentPosition, nextWordEndPosition);
        currentPosition = nextWordEndPosition + 1;

        return out;
    }

    public boolean hasNext() {

        return matcher.find();
    }
}
