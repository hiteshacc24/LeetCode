package com.company;

public class ShiftedBinarySearch {
    public static int shiftedSearch(int[] arr, int target) {
        return helper(arr, 0, arr.length - 1, target);
    }
    public static int helper(int[] arr, int left, int right, int target) {
        if(left > right) return -1;
        int leftNum = arr[left];
        int rightNum = arr[right];
        int mid = (left + right)/2;
        int potentialMatch = arr[mid];
        if(potentialMatch == target) return mid;
        else if(leftNum <= potentialMatch) {
            if(target < potentialMatch && target >= leftNum) {
                return helper(arr, left, mid - 1, target);
            } else {
                return helper(arr, mid + 1, right, target);
            }
        } else {
            if(target > potentialMatch && target <= rightNum) {
                return helper(arr, left, mid - 1, target);
            } else {
                return helper(arr, mid + 1, right, target);
            }
        }
    }
    public static int[] findRange(int[] array, int target) {
        int left = binaryLeft(array, target);
        int right = binaryRight(array, target);
        return new int[] {left, right};
    }
    public static int binaryLeft(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while(left <= right) {
            int mid = (left + right)/2;
            int potentialMatch = array[mid];
            if(potentialMatch == target) {
                if( mid == 0 || target != array[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if(potentialMatch < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int binaryRight(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while(left <= right) {
            int mid = (left + right)/2;
            int potentialMatch = array[mid];
            if(potentialMatch == target) {
                if( mid == array.length - 1 || target != array[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if(potentialMatch < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {45, 61, 71, 72, 73, 0, 1, 21, 33, 45};
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73 };
        int idx = shiftedSearch(arr, 33);
        int[] res = findRange(array, 45);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.print(idx);
    }
}
