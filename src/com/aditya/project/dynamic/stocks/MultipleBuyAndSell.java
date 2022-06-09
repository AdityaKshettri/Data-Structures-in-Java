package com.aditya.project.dynamic.stocks;

import java.util.Arrays;

public class MultipleBuyAndSell {

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int n = a.length;
        int[][] dp = new int[n][2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Max Profit (Recursion) : " + funcRecursion(0, 1, a));
        System.out.println("Max Profit (Memoization) : " + funcMemoization(0, 1, a, dp));
        System.out.println("Max Profit (Tabulation) : " + funcTabulation(n, a));
        System.out.println("Max Profit (Space Optimization) : " + funcSpaceOptimization(n, a));
        System.out.println("Max Profit (Variable Solution) : " + funcVariableSolution(n, a));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int buy, int[] a) {
        if (index == a.length) {
            return 0;
        }
        int notTake, take;
        if (buy == 1) {
            notTake = funcRecursion(index + 1, buy, a);
            take = -a[index] + funcRecursion(index + 1, 0, a);
        } else {
            notTake = funcRecursion(index + 1, buy, a);
            take = a[index] + funcRecursion(index + 1, 1, a);
        }
        return Math.max(notTake, take);
    }

    // Memoization
    // TC : O(N*2)
    // SC : O(N*2) + O(N) for Recursion
    private static int funcMemoization(int index, int buy, int[] a, int[][] dp) {
        if (index == a.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int notTake, take;
        if (buy == 1) {
            notTake = funcMemoization(index + 1, buy, a, dp);
            take = -a[index] + funcMemoization(index + 1, 0, a, dp);
        } else {
            notTake = funcMemoization(index + 1, buy, a, dp);
            take = a[index] + funcMemoization(index + 1, 1, a, dp);
        }
        return dp[index][buy] = Math.max(notTake, take);
    }

    // Tabulation
    // TC : O(N*2)
    // SC : O(N*2)
    private static int funcTabulation(int n, int[] a) {
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int notTake, take;
                if (j == 1) {
                    notTake = dp[i + 1][j];
                    take = -a[i] + dp[i + 1][0];
                } else {
                    notTake = dp[i + 1][j];
                    take = a[i] + dp[i + 1][1];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }
        return dp[0][1];
    }

    // Space Optimization
    // TC : O(N*2)
    // SC : O(1)
    private static int funcSpaceOptimization(int n, int[] a) {
        int[] next = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int j = 0; j <= 1; j++) {
                int notTake, take;
                if (j == 1) {
                    notTake = next[j];
                    take = -a[i] + next[0];
                } else {
                    notTake = next[j];
                    take = a[i] + next[1];
                }
                curr[j] = Math.max(notTake, take);
            }
            next = curr;
        }
        return next[1];
    }

    // Variable Solution
    // TC : O(N)
    // SC : O(1)
    private static int funcVariableSolution(int n, int[] a) {
        int nextBuy = 0;
        int nextNotBuy = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currBuy = Math.max(nextBuy, -a[i] + nextNotBuy);
            int currNotBuy = Math.max(nextNotBuy, a[i] + nextBuy);
            nextBuy = currBuy;
            nextNotBuy = currNotBuy;
        }
        return nextBuy;
    }
}
