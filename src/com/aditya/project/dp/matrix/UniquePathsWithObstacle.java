package com.aditya.project.dp.matrix;

import java.util.Arrays;

public class UniquePathsWithObstacle {

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] a = {{0, 0, 0}, {0, -1, 0}, {0, 0, 0}};
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Unique Paths With Obstacle : (Recursion) = " + funcRecursion(n - 1, m - 1, a));
        System.out.println("Unique Paths With Obstacle : (Memoization) = " + funcMemoization(n - 1, m - 1, a, dp));
        System.out.println("Unique Paths With Obstacle : (Tabulation) = " + funcTabulation(n, m, a));
        System.out.println("Unique Paths With Obstacle : (Space Optimization) = " + funcSpaceOptimization(n, m, a));
    }

    // Recursion
    // TC : O(2^(M+N))
    // SC : O(M+N)
    private static int funcRecursion(int row, int col, int[][] a) {
        if (row >= 0 && col >= 0 && a[row][col] == -1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        return funcRecursion(row - 1, col, a) + funcRecursion(row, col - 1, a);
    }

    // Memoization
    // TC : O(M*N)
    // SC : O(M*N) + O(M+N) for recursion
    private static int funcMemoization(int row, int col, int[][] a, int[][] dp) {
        if (row >= 0 && col >= 0 && a[row][col] == -1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        return dp[row][col] = funcMemoization(row - 1, col, a, dp) + funcMemoization(row, col - 1, a, dp);
    }

    // Tabulation
    // TC : O(M*N)
    // SC : O(M*N)
    private static int funcTabulation(int n, int m, int[][] a) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == -1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // Space Optimization
    // TC : O(M*N)
    // SC : O(M)
    private static int funcSpaceOptimization(int n, int m, int[][] a) {
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (a[i][j] == -1) {
                    curr[j] = 0;
                } else if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = curr[j - 1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}
