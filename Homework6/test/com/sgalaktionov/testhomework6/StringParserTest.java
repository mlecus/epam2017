package com.sgalaktionov.testhomework6;

import com.sgalaktionov.homework6.StringParser;
import org.junit.Before;
import org.junit.Test;

public class StringParserTest {

    public final String text =
            "Once upon a time a  Wolf was lapping at a spring on a hillside,"
                    + "when, looking up, what should he see but a\n"
                    + "Lamb just beginning to drink a little lower down.\n";

    public StringParser stringParser;

    @Before
    public void testSetUp() {

        stringParser = new StringParser(text);
    }

    @Test
    public void getNextWord() throws Exception {

        while (stringParser.isNextPresent()) {
            String word = stringParser.getNextWord();
           // System.out.println(word);
        }

    }

}