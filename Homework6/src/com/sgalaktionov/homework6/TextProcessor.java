package com.sgalaktionov.homework6;

public class TextProcessor {
    String punctuationSymbols =":.,!?\"\'\t";
    public TextProcessor() {
    }

    public String removePunctuation(String input) {

        String result = input;
        if ("".equals(input)) {
            return "";
        }

        char lastUncheckedSymbol;
        int lastUncheckedSymbolIndex;
        for (lastUncheckedSymbolIndex = result.length() - 1; lastUncheckedSymbolIndex >= 0; lastUncheckedSymbolIndex--) {
            lastUncheckedSymbol = input.charAt(lastUncheckedSymbolIndex);
            if (punctuationSymbols.indexOf(lastUncheckedSymbol) == -1) {
                break;
            }
        }
        if (lastUncheckedSymbolIndex < 0){
            return "";
        }else{
            result = result.substring(0, lastUncheckedSymbolIndex+1);
        }

        for (int i = 0; i < result.length(); i++) {
            char currentSymbol = result.charAt(i);
            if (punctuationSymbols.indexOf(currentSymbol) != -1) {
                String message = "unexpected punctuation mark " + currentSymbol + " in word \""+result +"\"";
                throw new IllegalArgumentException(message);
            }
        }
        return result;
    }

    public WordContainer process(String text){

        StringParser stringParser = new StringParser(text, punctuationSymbols);
        WordContainer wordContainer = new WordContainer();
        while (stringParser.isNextPresent()){
            try {
                String word = stringParser.getNextWord();

                word = removePunctuation(word);

                if (!"".equals(word)) {
                    wordContainer.add(word);
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return wordContainer;
    }
}
