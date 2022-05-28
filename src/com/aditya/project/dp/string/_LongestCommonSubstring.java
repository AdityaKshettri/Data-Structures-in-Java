package com.aditya.project.dp.string;

import java.util.Arrays;

public class _LongestCommonSubstring {

    public static void main(String[] args) {
        String a = "abcde";
        String b = "cabcd";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Longest Common Substring Length (Recursion) : " + funcRecursion(n, m, 0, a, b));
        System.out.println("Longest Common Substring Length (Memoization) : " + funcMemoization(n, m, 0, a, b, dp));
        System.out.println("Longest Common Substring Length (Tabulation) : " + funcTabulation(a, b));
        System.out.println("Longest Common Substring Length (Space Optimization) : " + funcSpaceOptimization(a, b));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N+M)
    private static int funcRecursion(int i, int j, int count, String a, String b) {
        if (i == 0 || j == 0) {
            return count;
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return funcRecursion(i - 1, j - 1, count + 1, a, b);
        }
        return Math.max(count, Math.max(funcRecursion(i, j - 1, count, a, b), funcRecursion(i - 1, j, count, a, b)));
    }

    // Memoization
    // TC : O(N*M)
    // SC : O(N*M) + O(N) for Recursion
    private static int funcMemoization(int i, int j, int count, String a, String b, int[][] dp) {
        if (i == 0 || j == 0) {
            return count;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return dp[i][j] = funcMemoization(i - 1, j - 1, count + 1, a, b, dp);
        }
        return dp[i][j] = Math.max(count, Math.max(funcRecursion(i, j - 1, count, a, b), funcRecursion(i - 1, j, count, a, b)));
    }

    // Tabulation
    // TC : O(N*M)
    // SC : O(N*M)
    private static int funcTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    // Space Optimization
    // TC : O(N*M)
    // SC : O(M)
    private static int funcSpaceOptimization(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] prev = new int[m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        return ans;
    }
}
