package com.sgalaktionov.homework4_2;

public class SelectionSort extends Sorter{
    @Override
    public void sort(int[] array) {
        int localMaxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[localMaxIndex] < array[j]) {
                    localMaxIndex = j;
                }
            }
            int temp = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = array[localMaxIndex];
            array[localMaxIndex] = temp;
            localMaxIndex=0;
        }
    }
}
