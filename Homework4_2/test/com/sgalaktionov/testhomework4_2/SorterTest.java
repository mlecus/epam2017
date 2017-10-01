package com.sgalaktionov.testhomework4_2;

import com.sgalaktionov.homework4_2.BubbleSort;
import com.sgalaktionov.homework4_2.SelectionSort;
import com.sgalaktionov.homework4_2.Sorter;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {
    final public static int AMOUNT = (int) (65536 * 5);
    int[] array = new int[AMOUNT];

    @Before
    public void testSetUp() {
        for (int i = 0; i < AMOUNT; i++) {
            array[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
    }

    @Test
    public void testBubbleSortStrategy() throws Exception {
        Sorter sorter = new BubbleSort();
        sorter.sort(array);
    }

    @Test
    public void testSelectionSortStrategy() throws Exception {
        Sorter sorter = new SelectionSort();
        sorter.sort(array);
    }
}