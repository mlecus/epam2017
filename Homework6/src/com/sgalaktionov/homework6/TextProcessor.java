package com.sgalaktionov.homework6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

    private  String punctuationSymbolsRegExp = "\\W";
    private Pattern punctuationPattern;

    private String punctuationInsideWordRegExp = "\\w*\\W+\\w+";

    public TextProcessor() {

        punctuationPattern = Pattern.compile(punctuationSymbolsRegExp);
    }

    public String removePunctuation(String input) {

        if ("".equals(input)) {
            return "";
        }

        if (input.matches(punctuationInsideWordRegExp)) {
            throw new IllegalArgumentException(input);
        }

        Matcher punctuationRemover = punctuationPattern.matcher(input);
        String result = punctuationRemover.replaceAll("");
        return result;
    }

    public WordContainer process(String text) {

        StringParser stringParser = new StringParser(text/*, punctuationSymbolsRegExp*/);
        WordContainer wordContainer = new WordContainer();
        while (stringParser.hasNext()) {
            try {
                String word = stringParser.getNext();
                word = removePunctuation(word);
                if (!"".equals(word)) {
                    wordContainer.add(word);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return wordContainer;
    }
}
