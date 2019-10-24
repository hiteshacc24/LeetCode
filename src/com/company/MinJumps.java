package com.company;

import java.util.Arrays;

public class MinJumps {
    public static int minNumberJumps(int[] array) {
        if(array == null || array.length == 0) return 0;
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for(int i = 1; i < array.length; i++) {
            for(int j = 0; j < i; j++) {
                if(j + array[j] >= i) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }
        return jumps[array.length - 1];
    }
    public static void main(String[] args) {
        int[] arr = {3,4,2,1,2,3,7,1,1,1,3};
        int result = minNumberJumps(arr);
        System.out.print(result);
    }
}
