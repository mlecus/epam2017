package com.sgalaktionov.testhomework6;

import com.sgalaktionov.homework6.TextProcessor;
import com.sgalaktionov.homework6.WordContainer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextProcessorTest {

    public final String correctText =
            "Once upon a time a  Wolf was lapping... at a spring on a hillside,"
                    + " when, looking up, what should he see but a\n"
                    + "Lamb just beginning to drink a little lower down.\n";

    public TextProcessor textProcessor;

    @Before
    public void testSetUp() {

        textProcessor = new TextProcessor();
    }

    @Test//(timeout = 1000)
    public void testProcess() throws Exception {

        WordContainer wordContainer = textProcessor.process(correctText);
        //System.out.println(wordContainer);
    }

    @Test//(timeout = 1000)
    public void testProcessWithOnlyCFWordDividers() throws Exception {

        WordContainer wordContainer = textProcessor.process("aword1.\naword2\nbword1\n");
        //System.out.println(wordContainer);
        String expected = "A: aword1 aword2\n" +
                "B: bword1\n";
        assertEquals(expected, wordContainer.toString());
    }

    @Test
    public void testProcessWithMultipleCFWordDividers() throws Exception {

        WordContainer wordContainer = textProcessor.process("aword1.\n\n\naword2\nbword1\n");
        //System.out.println(wordContainer);
        String expected = "A: aword1 aword2\n" +
                "B: bword1\n";
        assertEquals(expected, wordContainer.toString());
    }

    @Test//(timeout = 1000)
    public void testProcessWithOnlySpaceWordDividers() throws Exception {

        WordContainer wordContainer = textProcessor.process("aword1.  aword2 bword1 ");
        //System.out.println(wordContainer);
        String expected = "A: aword1 aword2\n" +
                "B: bword1\n";
        assertEquals(expected, wordContainer.toString());
    }

    @Test//(timeout = 1000)
    public void testProcessWithMultipleSpaceWordDividers() throws Exception {

        WordContainer wordContainer = textProcessor.process("aword1.  aword2 bword1 ");
        //System.out.println(wordContainer);
        String expected = "A: aword1 aword2\n" +
                "B: bword1\n";
        assertEquals(expected, wordContainer.toString());
    }

    @Test
    public void testRemovePunctuation() {

        assertEquals("word", textProcessor.removePunctuation("word."));
    }

    @Test
    public void testRemovePunctuationWithMultiplePunctuationAtTheEnd() {

        assertEquals("word", textProcessor.removePunctuation("word..."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePunctuationWithPunctuationInsideWord() {

        textProcessor.removePunctuation("wo.rd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMultiplePunctuationWithPunctuationInsideWord() {

        textProcessor.removePunctuation("wo^!.rd");
    }
}
