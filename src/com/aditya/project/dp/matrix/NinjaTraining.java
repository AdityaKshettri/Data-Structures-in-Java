package com.aditya.project.dp.matrix;

import java.util.Arrays;

public class NinjaTraining {

    public static void main(String[] args) {
        int[][] a = {{10, 50, 1}, {5, 100, 11}};
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Max points (Recursion) : " + funcRecursion(n - 1, 3, a));
        System.out.println("Max points (Memoization) : " + funcMemoization(n - 1, 3, a, dp));
    }

    // Recursion
    // TC : O(2^N*M)
    // SC : O(N*M)
    private static int funcRecursion(int index, int last, int[][] a) {
        if (index == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a[0].length; i++) {
                if (i != last) {
                    max = Math.max(max, a[0][i]);
                }
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a[index].length; i++) {
            if (i != last) {
                int points = a[index][i] + funcRecursion(index - 1, i, a);
                max = Math.max(max, points);
            }
        }
        return max;
    }

    // Memoization
    // TC : O(N*M)
    // SC : O(N*M)
    private static int funcMemoization(int index, int last, int[][] a, int[][] dp) {
        if (index == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a[0].length; i++) {
                if (i != last) {
                    max = Math.max(max, a[0][i]);
                }
            }
            return max;
        }
        if (dp[index][last] != -1) {
            return dp[index][last];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a[index].length; i++) {
            if (i != last) {
                int points = a[index][i] + funcMemoization(index - 1, i, a, dp);
                max = Math.max(max, points);
            }
        }
        return dp[index][last] = max;
    }
}
