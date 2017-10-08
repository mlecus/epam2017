package com.sgalaktionov.testhomework6;

import com.sgalaktionov.homework6.StringParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringParserTest {

    public final String text =
            "Once upon\n"
                    + " a time\ta  Wolf was lapping at a spring on a hillside,"
                    + "when, looking up, what should he see but a\n"
                    + "Lamb just beginning to drink a little lower down.\n";

    public StringParser stringParser;

    @Before
    public void testSetUp() {

        stringParser = new StringParser(text);
    }

    @Test
    public void getNextWord() throws Exception {

        StringBuilder words =new StringBuilder();
        while (stringParser.hasNext()) {
            String word = stringParser.getNext();
            words.append(word).append("\n");
        }
        String expected ="Once\n" +
                "upon\n" +
                "\n" +
                "a\n" +
                "time\n" +
                "a\n" +
                "\n" +
                "Wolf\n" +
                "was\n" +
                "lapping\n" +
                "at\n" +
                "a\n" +
                "spring\n" +
                "on\n" +
                "a\n" +
                "hillside,when,\n" +
                "looking\n" +
                "up,\n" +
                "what\n" +
                "should\n" +
                "he\n" +
                "see\n" +
                "but\n" +
                "a\n" +
                "Lamb\n" +
                "just\n" +
                "beginning\n" +
                "to\n" +
                "drink\n" +
                "a\n" +
                "little\n" +
                "lower\n" +
                "down.\n";
        assertEquals (expected, words.toString());
    }

}