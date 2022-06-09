package com.aditya.project.dynamic.partition;

import java.util.Arrays;

public class MinCostToCutStick {

    public static void main(String[] args) {
        int n = 7;
        int c = 4;
        int[] a = {1, 3, 4, 5};
        int[] s = new int[c + 2];
        s[0] = 0;
        int k = 1;
        for (int i : a) {
            s[k++] = i;
        }
        s[c + 1] = n;
        Arrays.sort(s);
        int[][] dp = new int[c + 1][c + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Min cost to cut stick (Recursion) : " + funcRecursion(1, c, s));
        System.out.println("Min cost to cut stick (Memoization) : " + funcMemoization(1, c, s, dp));
        System.out.println("Min cost to cut stick (Tabulation) : " + funcTabulation(s, c));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int i, int j, int[] a) {
        if (i > j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = a[j + 1] - a[i - 1] + funcRecursion(i, k - 1, a) + funcRecursion(k + 1, j, a);
            min = Math.min(min, cost);
        }
        return min;
    }

    // Memoization
    // TC : O(N^3)
    // SC : O(N^2) + O(N) for Recursion
    private static int funcMemoization(int i, int j, int[] a, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = a[j + 1] - a[i - 1] + funcMemoization(i, k - 1, a, dp) + funcMemoization(k + 1, j, a, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    // Tabulation
    // TC : O(N^3)
    // SC : O(N^2)
    private static int funcTabulation(int[] a, int c) {
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = a[j + 1] - a[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }
}
