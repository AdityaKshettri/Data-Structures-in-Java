package com.aditya.project.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = a.length;
        print(a);
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Longest Increasing Subsequence (Recursion) : " + funcRecursion(0, -1, a));
        System.out.println("Longest Increasing Subsequence (Memoization) : " + funcMemoization(0, -1, a, dp));
        System.out.println("Longest Increasing Subsequence (Tabulation) : " + funcTabulation(a));
        System.out.println("Longest Increasing Subsequence (Space Optimization) : " + funcSpaceOptimization(a));
        System.out.println("Longest Increasing Subsequence (Alternative) : " + funcAlternative(a));
        System.out.println("Longest Increasing Subsequence : " + getLongestIncreasingSubsequence(a));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int prev, int[] a) {
        if (index == a.length) {
            return 0;
        }
        int notTake = funcRecursion(index + 1, prev, a);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || a[prev] < a[index]) {
            take = 1 + funcRecursion(index + 1, index, a);
        }
        return Math.max(take, notTake);
    }

    // Memoization
    // TC : O(N^2)
    // SC : O(N^2) + O(N) for Recursion
    private static int funcMemoization(int index, int prev, int[] a, int[][] dp) {
        if (index == a.length) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }
        int notTake = funcMemoization(index + 1, prev, a, dp);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || a[prev] < a[index]) {
            take = 1 + funcMemoization(index + 1, index, a, dp);
        }
        return dp[index][prev + 1] = Math.max(take, notTake);
    }

    // Tabulation
    // TC : O(N^2)
    // SC : O(N^2)
    private static int funcTabulation(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = dp[index + 1][prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || a[prev] < a[index]) {
                    take = 1 + dp[index + 1][index + 1];
                }
                dp[index][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    // TC : O(N^2)
    // SC : O(N)
    private static int funcSpaceOptimization(int[] a) {
        int n = a.length;
        int[] next = new int[n + 1];
        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[n + 1];
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = next[prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || a[prev] < a[index]) {
                    take = 1 + next[index + 1];
                }
                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }

    // Alternative Method
    // TC : O(N^2)
    // SC : O(N)
    private static int funcAlternative(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int getLongestIncreasingSubsequence(int[] a) {
        int n = a.length;
        int[] temp = new int[n];
        temp[0] = a[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] < temp[0]) {
                temp[0] = a[i];
            } else if (a[i] > temp[len - 1]) {
                temp[len++] = a[i];
            } else {
                int j = getCeilIndexFromBinarySearch(temp, -1, len - 1, a[i]);
                temp[j] = a[i];
            }
        }
        return len;
    }

    private static int getCeilIndexFromBinarySearch(int[] a, int l, int r, int key) {
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
