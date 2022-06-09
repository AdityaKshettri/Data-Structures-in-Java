package com.aditya.project.dynamic.prev;

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
        System.out.println("Max points (Recursion) : " + funcRecursion(n - 1, m, a));
        System.out.println("Max points (Memoization) : " + funcMemoization(n - 1, m, a, dp));
        System.out.println("Max points (Tabulation) : " + funcTabulation(a));
        System.out.println("Max points (Space Optimization) : " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(2^N*M)
    // SC : O(N*M)
    private static int funcRecursion(int index, int prev, int[][] a) {
        if (index == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a[0].length; i++) {
                if (i != prev) {
                    max = Math.max(max, a[0][i]);
                }
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a[index].length; i++) {
            if (i != prev) {
                int points = a[index][i] + funcRecursion(index - 1, i, a);
                max = Math.max(max, points);
            }
        }
        return max;
    }

    // Memoization
    // TC : O(N*M*M)
    // SC : O(N*M) + O(N+M) for Recursion
    private static int funcMemoization(int index, int prev, int[][] a, int[][] dp) {
        if (index == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a[0].length; i++) {
                if (i != prev) {
                    max = Math.max(max, a[0][i]);
                }
            }
            return max;
        }
        if (dp[index][prev] != -1) {
            return dp[index][prev];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a[index].length; i++) {
            if (i != prev) {
                int points = a[index][i] + funcMemoization(index - 1, i, a, dp);
                max = Math.max(max, points);
            }
        }
        return dp[index][prev] = max;
    }

    // Tabulation
    // TC : O(N*M*M)
    // SC : O(N*M)
    private static int funcTabulation(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m + 1];
        dp[0][m] = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (i != j) {
                    max = Math.max(max, a[0][j]);
                }
            }
            dp[0][i] = max;
            dp[0][m] = Math.max(dp[0][m], a[0][i]);
        }
        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        int points = a[i][k] + dp[i - 1][k];
                        max = Math.max(max, points);
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[n - 1][m];
    }

    // Space Optimization
    // TC : O(N*M*M)
    // SC : O(M)
    private static int funcSpaceOptimization(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[] prev = new int[m + 1];
        prev[m] = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (i != j) {
                    max = Math.max(max, a[0][j]);
                }
            }
            prev[i] = max;
            prev[m] = Math.max(prev[m], a[0][i]);
        }
        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int[] curr = new int[m + 1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        int points = a[i][k] + prev[k];
                        max = Math.max(max, points);
                    }
                }
                curr[j] = max;
            }
            prev = curr;
        }
        return prev[m];
    }
}
