package com.aditya.project.dp.string;

import java.util.Arrays;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] a = {"a", "abcd", "ab", "abd", "d"};
        Arrays.sort(a, (x, y) -> x.length() - y.length());
        print(a);
        int n = a.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Longest String Chain (Recursion) : " + funcRecursion(0, -1, a));
        System.out.println("Longest String Chain (Memoization) : " + funcMemoization(0, -1, a, dp));
        System.out.println("Longest String Chain (Tabulation) : " + funcTabulation(a));
        System.out.println("Longest String Chain (Space Optimization) : " + funcSpaceOptimization(a));
    }

    private static boolean isChainPossible(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n != m + 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < n) {
            if (j < m && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return i == n && j == m;
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int prev, String[] a) {
        if (index == a.length) {
            return 0;
        }
        int notTake = funcRecursion(index + 1, prev, a);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || isChainPossible(a[index], a[prev])) {
            take = 1 + funcRecursion(index + 1, index, a);
        }
        return Math.max(take, notTake);
    }

    // Memoization
    // TC : O(N^2)
    // SC : O(N^2) + O(N) for Recursion
    private static int funcMemoization(int index, int prev, String[] a, int[][] dp) {
        if (index == a.length) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }
        int notTake = funcMemoization(index + 1, prev, a, dp);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || isChainPossible(a[index], a[prev])) {
            take = 1 + funcMemoization(index + 1, index, a, dp);
        }
        return dp[index][prev + 1] = Math.max(take, notTake);
    }

    // Tabulation
    // TC : O(N^2)
    // SC : O(N^2)
    private static int funcTabulation(String[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = dp[index + 1][prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || isChainPossible(a[index], a[prev])) {
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
    private static int funcSpaceOptimization(String[] a) {
        int n = a.length;
        int[] next = new int[n + 1];
        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[n + 1];
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = next[prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || isChainPossible(a[index], a[prev])) {
                    take = 1 + next[index + 1];
                }
                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }

    private static void print(String[] a) {
        for (String i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
