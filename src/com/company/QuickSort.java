package com.company;

import com.sun.prism.impl.shape.BasicRoundRectRep;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        // Write your code here.
        quickSortHelper(array, 0, array.length -1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if(startIdx >= endIdx) return;
        int pivotIdx = startIdx;
        int left = startIdx + 1;
        int right = endIdx;
        while(left <= right) {
            if(array[left] > array[pivotIdx] && array[right] < array[pivotIdx]) {
                swap(array, left, right);
            }
            if(array[left] <= array[pivotIdx]) left++;
            if(array[right] >= array[pivotIdx]) right--;
        }
        swap(array, pivotIdx, right);
        boolean isLeftSmaller = (right - 1) - startIdx < endIdx - (right + 1);
        if (isLeftSmaller) {
            quickSortHelper(array, startIdx, right - 1);
            quickSortHelper(array, right + 1, endIdx);
        } else {
            quickSortHelper(array, right + 1, endIdx);
            quickSortHelper(array, startIdx, right - 1);
        }
    }
    public static void swap(int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        quickSort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
