package com.sgalaktionov.testhomework8_1;

import com.sgalaktionov.homework8_1.LimitedList;
import com.sgalaktionov.homework8_1.exceptions.LimitedListCapacityExceed;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LimitedListTest {
    final int CAPACITY = 10;
    LimitedList<Integer> limitedList;
    ArrayList<Integer> fullDataSource;
    ArrayList<Integer> extraDataSource;

    @Before
    public void testSetUp() {

        limitedList = new LimitedList<Integer>(CAPACITY);
        fullDataSource = new ArrayList<Integer>();
        extraDataSource = new ArrayList<Integer>();
        for (int i = 0; i < CAPACITY; i++) {
            fullDataSource.add(i);
            extraDataSource.add(i);
        }
        extraDataSource.add(10);
    }

    @Test
    public void size() throws Exception {

        limitedList.add(5);
        limitedList.add(5);
        assertEquals(2, limitedList.size());
    }

    @Test
    public void add() throws Exception {
        for (int i = 0; i < CAPACITY; i++) {
            limitedList.add(i);
        }
    }

    @Test(expected = LimitedListCapacityExceed.class)
    public void addToMuchElements() throws Exception {
        for (int i = 0; i < CAPACITY + 1; i++) {
            limitedList.add(i);
        }
    }

    @Test
    public void addAll() throws Exception {
        limitedList.addAll(fullDataSource);
    }

    @Test(expected = LimitedListCapacityExceed.class)
    public void addAllToMuch() throws Exception {
        limitedList.addAll(extraDataSource);
    }

    @Test
    public void addAllFromIndex() throws Exception {
        limitedList.addAll(0, fullDataSource);
    }

    @Test(expected = LimitedListCapacityExceed.class)
    public void addAllFromIndexTooMuch() throws Exception {
        limitedList.addAll(0, extraDataSource);
    }

    @Test
    public void addElement() throws Exception {

        for (int i = 0; i < CAPACITY; i++) {
            limitedList.add(i, i);
        }

    }

    @Test(expected = LimitedListCapacityExceed.class)
    public void addElemetnInTooLargeIdex() throws Exception {
        for (int i = 0; i < CAPACITY + 1; i++) {
            limitedList.add(CAPACITY, 10);
        }
    }
}