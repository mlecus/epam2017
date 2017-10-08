package com.sgalaktionov.testhomework6;

import com.sgalaktionov.homework6.TextProcessor;
import com.sgalaktionov.homework6.WordContainer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskAcceptanceTest {
    public final String correctText =
            "Once upon a time a  Wolf was lapping... at a spring on a hillside,"
                    + " when, looking up, what should he see but a\n"
                    + "Lamb just beginning to drink a little lower down.\n";




    @Test//(timeout = 1000)
    public void testProcess() throws Exception {

        TextProcessor textProcessor = new TextProcessor();
        WordContainer wordContainer = textProcessor.process(correctText);
        String expected = "A: a at\n" +
                "B: beginning but\n" +
                "D: down drink\n" +
                "H: he hillside\n" +
                "J: just\n" +
                "L: lamb lapping little looking lower\n" +
                "O: on once\n" +
                "S: see should spring\n" +
                "T: time to\n" +
                "U: up upon\n" +
                "W: was what when wolf\n";
        System.out.println(wordContainer);
        assertEquals(expected,wordContainer.toString());
    }

}
