package com.aditya.project.dynamic;

/*
    Given n dice each with m faces,
    numbered from 1 to m,
    find the number of ways to get sum X.
    X is the summation of values on each face when all the dice are thrown
*/
public class DiceThrowSum {

    public static void main(String[] args) {
        int n = 3;
        int m = 6;
        int x = 8;
        System.out.println("No. of ways (Tabulation) : " + funcTabulation(n, m, x));
    }

    // Tabulation
    // TC : O(N*M*X)
    // SC : O(N*X)
    private static int funcTabulation(int n, int m, int x) {
        int[][] dp = new int[n + 1][x + 1];
        for (int j = 1; j <= m && j <= x; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k < j && k <= m; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        return dp[n][x];
    }
}
