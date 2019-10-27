package com.company;

public class MaxProfitOneTransaction {
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
           if(prices[i] <  minPrice) {
               minPrice = prices[i];
           }
           int profit = prices[i] - minPrice;
           if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int p = maxProfit(arr);
        System.out.print(p);
    }
}
