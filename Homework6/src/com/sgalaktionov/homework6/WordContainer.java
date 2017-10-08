package com.sgalaktionov.homework6;

import java.util.*;

public class WordContainer {

    private TreeMap<Character, TreeSet<String>> container;

    public WordContainer() {

        container = new TreeMap<>();
    }

    public void add(String inputWord) {

        if ((inputWord == null) || ("".equals(inputWord))) {
            throw new IllegalArgumentException("null or empty string received");
        }
        inputWord = inputWord.toLowerCase();
        Character key = inputWord.charAt(0);
        if (container.keySet().contains(key)) {
            Set<String> wordList = container.get(key);
            wordList.add(inputWord);
        } else {
            TreeSet<String> wordList = new TreeSet<String>();
            wordList.add(inputWord);
            container.put(key, wordList);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Character firtsLetter : container.keySet()) {
            sb.append(firtsLetter.toString().toUpperCase() + ":");
            for (String word : container.get(firtsLetter)) {
                sb.append(" ").append(word);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
