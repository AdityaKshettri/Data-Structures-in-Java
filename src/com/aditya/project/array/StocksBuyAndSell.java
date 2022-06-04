package com.aditya.project.array;

public class StocksBuyAndSell {

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        print(a);
        System.out.println("Max Profit : " + getMaxProfit(a));
    }

    private static int getMaxProfit(int[] a) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < minPrice) {
                minPrice = a[i];
            }
            if (a[i] - minPrice > maxProfit) {
                maxProfit = a[i] - minPrice;
            }
        }
        return maxProfit;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
