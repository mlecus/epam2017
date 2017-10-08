package com.sgalaktionov.homework6;

public class StringParser {

    String string;
    int currentPosition;
    final String wasteSymbols;

    public StringParser(String string) {

        this.string = string;
        currentPosition = 0;
        wasteSymbols = "";
    }

    public StringParser(String string, String punctuationSymbols) {

        this.string = string;
        currentPosition = 0;
        this.wasteSymbols = punctuationSymbols;
    }

    public String getNextWord() {

        if (currentPosition >= string.length()) {
            throw new StringIndexOutOfBoundsException("no any words more");
        }

        int nextSpasePosition = string.indexOf(" ", currentPosition);
        int nextLFPosition = string.indexOf("\n", currentPosition);
        int nextWordEndPosition = 0;
        if (nextLFPosition == -1) {
            nextWordEndPosition = nextSpasePosition;
        } else {
            if (nextSpasePosition != -1) {
                nextWordEndPosition = Math.min(nextLFPosition, nextSpasePosition);
            } else {
                nextWordEndPosition = nextLFPosition;
            }
        }
        if (nextWordEndPosition == -1) {
            nextWordEndPosition = string.length();
        }

        String out = string.substring(currentPosition, nextWordEndPosition);
        currentPosition = nextWordEndPosition + 1;

        return out;
    }

    public boolean isNextPresent() {

        return (currentPosition < string.length() - 1);
    }
}
