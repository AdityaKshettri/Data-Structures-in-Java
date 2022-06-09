package com.aditya.project.dynamic.partition;

import java.util.Arrays;

public class PalindromePartition {

    public static void main(String[] args) {
        String a = "abcd";
        int n = a.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.printf("Min no. of palindrome partitions (Recursion) : %d\n", funcRecursion(1, n, a));
        System.out.printf("Min no. of palindrome partitions (Memoization) : %d\n", funcMemoization(1, n, a, dp));
        System.out.printf("Min no. of palindrome partitions (Tabulation) : %d\n", funcTabulation(a));
        System.out.printf("Min no. of palindrome partitions (Space Optimization) : %d\n", funcSpaceOptimization(a));
    }

    private static boolean isPalindrome(String a, int i, int j) {
        while (i < j) {
            if (a.charAt(i++) != a.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int i, int n, String a) {
        if (i == n) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(a, i, j)) {
                int cost = 1 + funcRecursion(j + 1, n, a);
                min = Math.min(min, cost);
            }
        }
        return min;
    }

    // Memoization
    // TC : O(N^2)
    // TC : O(N) + O(N) for Recursion
    private static int funcMemoization(int i, int n, String a, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(a, i, j)) {
                int cost = 1 + funcMemoization(j + 1, n, a, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    // Tabulation
    // TC : O(N^2)
    // TC : O(N)
    private static int funcTabulation(String a) {
        int n = a.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i > 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(a, i, j)) {
                    int cost = 1 + dp[j + 1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[1];
    }

    // Space Optimization
    // TC : O(N^2)
    // TC : O(1)
    private static int funcSpaceOptimization(String a) {
        int n = a.length();
        int prev = 0;
        for (int i = n - 1; i > 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(a, i, j)) {
                    int cost = 1 + prev;
                    min = Math.min(min, cost);
                }
            }
            prev = min;
        }
        return prev;
    }
}
