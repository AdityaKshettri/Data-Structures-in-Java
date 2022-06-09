package com.aditya.project.dynamic.stocks;

public class SingleBuyAndSell {

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit : " + func(a));
    }

    // TC : O(N)
    // SC : O(1)
    private static int func(int[] a) {
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i : a) {
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }
        return profit;
    }
}
