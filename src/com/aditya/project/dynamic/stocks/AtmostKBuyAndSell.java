package com.aditya.project.dynamic.stocks;

import java.util.Arrays;

public class AtmostKBuyAndSell {

    public static void main(String[] args) {
        int[] a = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = a.length;
        int k = 2;
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        System.out.println("Max Profit (Recursion) : " + funcRecursion(0, 1, k, a));
        System.out.println("Max Profit (Memoization) : " + funcMemoization(0, 1, k, a, dp));
        System.out.println("Max Profit (Tabulation) : " + funcTabulation(n, k, a));
        System.out.println("Max Profit (Space Optimization) : " + funcSpaceOptimization(n, k, a));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int buy, int k, int[] a) {
        if (index == a.length || k == 0) {
            return 0;
        }
        int notTake, take;
        if (buy == 1) {
            notTake = funcRecursion(index + 1, buy, k, a);
            take = -a[index] + funcRecursion(index + 1, 0, k, a);
        } else {
            notTake = funcRecursion(index + 1, buy, k, a);
            take = a[index] + funcRecursion(index + 1, 1, k - 1, a);
        }
        return Math.max(notTake, take);
    }

    // Memoization
    // TC : O(N*2*K)
    // SC : O(N*2*K) + O(N) for Recursion
    private static int funcMemoization(int index, int buy, int k, int[] a, int[][][] dp) {
        if (index == a.length || k == 0) {
            return 0;
        }
        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }
        int notTake, take;
        if (buy == 1) {
            notTake = funcMemoization(index + 1, buy, k, a, dp);
            take = -a[index] + funcMemoization(index + 1, 0, k, a, dp);
        } else {
            notTake = funcMemoization(index + 1, buy, k, a, dp);
            take = a[index] + funcMemoization(index + 1, 1, k - 1, a, dp);
        }
        return dp[index][buy][k] = Math.max(notTake, take);
    }

    // Tabulation
    // TC : O(N*2*K)
    // SC : O(N*2*K)
    private static int funcTabulation(int n, int k, int[] a) {
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int p = 1; p <= k; p++) {
                    int notTake, take;
                    if (j == 1) {
                        notTake = dp[i + 1][j][p];
                        take = -a[i] + dp[i + 1][0][p];
                    } else {
                        notTake = dp[i + 1][j][p];
                        take = a[i] + dp[i + 1][1][p - 1];
                    }
                    dp[i][j][p] = Math.max(notTake, take);
                }
            }
        }
        return dp[0][1][k];
    }

    // Space Optimization
    // TC : O(N*2*K)
    // SC : O(2*K)
    private static int funcSpaceOptimization(int n, int k, int[] a) {
        int[][] next = new int[2][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][k + 1];
            for (int j = 0; j <= 1; j++) {
                for (int p = 1; p <= k; p++) {
                    int notTake, take;
                    if (j == 1) {
                        notTake = next[j][p];
                        take = -a[i] + next[0][p];
                    } else {
                        notTake = next[j][p];
                        take = a[i] + next[1][p - 1];
                    }
                    curr[j][p] = Math.max(notTake, take);
                }
                next = curr;
            }
        }
        return next[1][k];
    }
}
