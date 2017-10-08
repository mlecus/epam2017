package com.sgalaktionov.testhomework6;

import com.sgalaktionov.homework6.WordContainer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordContainerTest {

    WordContainer wordContainer;

    @Before
    public void testSetUp() {

        wordContainer = new WordContainer();
    }

    @Test
    public void testAdd() throws Exception {

        WordContainer wordContainer = new WordContainer();
        wordContainer.add("bword1");
        wordContainer.add("a2");
        wordContainer.add("aword2");
        wordContainer.add("aword1");
        wordContainer.add("aword1");
        wordContainer.add("Aword1");
        wordContainer.add("Bword2");
        wordContainer.add("bword3");
        String expected = "A: a2 aword1 aword2\n" + "B: bword1 bword2 bword3\n";
        //System.out.println(wordContainer);
        assertEquals(expected, wordContainer.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNull() throws Exception {

        wordContainer.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithEmptyString() throws Exception {

        wordContainer.add("");
    }
}