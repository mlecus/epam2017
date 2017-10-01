package com.sgalaktionov.homework4_2;

public class SortingContext {
    public void arrayPrint(int[] array){
        for (int item: array){
            System.out.print(item+" ");
        }
        System.out.println();
    }
    public void sortingContext() {
        int[] array1 = {5, 8, 20, 8, -100, 1, -100};
        arrayPrint(array1);
        Sorter sorter = new SelectionSort();
        sorter.sort(array1);
        arrayPrint(array1);

        System.out.println();
        int[] array2     = {5, 8, 20, -1, 15, -100};
        arrayPrint(array2);
        sorter = new BubbleSort();
        sorter.sort(array2);
        arrayPrint(array2);
    }
}
