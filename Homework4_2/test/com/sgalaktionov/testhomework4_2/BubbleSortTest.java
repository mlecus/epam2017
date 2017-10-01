package com.sgalaktionov.testhomework4_2;

import com.sgalaktionov.homework4_2.BubbleSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void testSort() throws Exception {
        int[] array     = {5, 8, 20, -1, 15, -100};
        int[] expected  = {-100, -1, 5, 8, 15, 20};
        new BubbleSort().sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithRepeatedMembers() throws Exception {
        int[] array     = {5, 8, 20, 8, -100, 1, -100};
        int[] expected  = {-100, -100, 1, 5, 8, 8, 20};
        new BubbleSort().sort(array);
        assertArrayEquals(expected, array);
    }
}