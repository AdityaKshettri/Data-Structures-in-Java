package com.aditya.project.dynamic.matrix;

public class CountSquaresWithAll1s {

    public static void main(String[] args) {
        int[][] a = {
                {0, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 0}
        };
        System.out.println("No. of squares with all 1s : " + funcTabulation(a));
    }

    // TC : O(N*M)
    // SC : O(N*M)
    private static int funcTabulation(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = a[i][0];
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = a[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
