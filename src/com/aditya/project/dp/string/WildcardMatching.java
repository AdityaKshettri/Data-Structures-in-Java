package com.aditya.project.dp.string;

import java.util.Arrays;

public class WildcardMatching {

    public static void main(String[] args) {
        String a = "adi*";
        String b = "aditya";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Wildcard Matching (Recursion) : " + funcRecursion(n - 1, m - 1, a, b));
        System.out.println("Wildcard Matching (Memoization) : " + funcMemoization(n - 1, m - 1, a, b, dp));
        System.out.println("Wildcard Matching (Tabulation) : " + funcTabulation(a, b));
        System.out.println("Wildcard Matching (Space Optimization) : " + funcSpaceOptimization(a, b));
    }

    // Recursion
    // TC : O(>>2^(M+N))
    // SC : O(>>M+N)
    private static boolean funcRecursion(int i, int j, String a, String b) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0 && j >= 0) {
            return false;
        }
        if (i >= 0 && j < 0) {
            for (int k = 0; k <= i; k++) {
                if (a.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (a.charAt(i) == b.charAt(j) || a.charAt(i) == '?') {
            return funcRecursion(i - 1, j - 1, a, b);
        }
        if (a.charAt(i) == '*') {
            return funcRecursion(i - 1, j, a, b) || funcRecursion(i, j - 1, a, b);
        }
        return false;
    }

    // Memoization
    // TC : O(M*N)
    // SC : O(M*N) + O(M+N) for Recursion
    private static boolean funcMemoization(int i, int j, String a, String b, int[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0 && j >= 0) {
            return false;
        }
        if (i >= 0 && j < 0) {
            for (int k = 0; k <= i; k++) {
                if (a.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (a.charAt(i) == b.charAt(j) || a.charAt(i) == '?') {
            boolean res = funcMemoization(i - 1, j - 1, a, b, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        if (a.charAt(i) == '*') {
            boolean res = funcMemoization(i - 1, j, a, b, dp) || funcMemoization(i, j - 1, a, b, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        dp[i][j] = 0;
        return false;
    }

    // Tabulation
    // TC : O(M*N)
    // SC : O(M*N)
    private static boolean funcTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int k = 1; k <= i; k++) {
                if (a.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) || a.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (a.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    // Space Optimization
    // TC : O(M*N)
    // SC : O(M)
    private static boolean funcSpaceOptimization(String a, String b) {
        int n = a.length();
        int m = b.length();
        boolean[] prev = new boolean[m + 1];
        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            prev[j] = false;
        }
        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m + 1];
            boolean flag = true;
            for (int k = 1; k <= i; k++) {
                if (a.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) || a.charAt(i - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (a.charAt(i - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
