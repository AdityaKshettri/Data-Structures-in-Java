package com.aditya.project.dynamic.matrix;

import java.util.Arrays;

public class LongestPath {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };
        int n = a.length;
        int m = a[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, funcRecursion(i, j, n, m, a, dx, dy));
            }
        }
        System.out.println("Length of Longest Path (Recursion) : " + max);
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, funcMemoization(i, j, n, m, a, dx, dy, dp));
            }
        }
        System.out.println("Length of Longest Path (Memoization) : " + max);
    }

    // Recursion
    // TC : O(exp)
    // SC : O(N)
    private static int funcRecursion(int i, int j, int n, int m, int[][] a, int[] dx, int[] dy) {
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int ik = i + dx[k];
            int jk = j + dy[k];
            if (ik >= 0 && ik < n && jk >= 0 && jk < m && a[i][j] + 1 == a[ik][jk]) {
                max = Math.max(max, 1 + funcRecursion(ik, jk, n, m, a, dx, dy));
            }
        }
        return max;
    }

    // Recursion
    // TC : O(N^2)
    // SC : O(N^2) + O(N) for Recursion
    private static int funcMemoization(int i, int j, int n, int m, int[][] a, int[] dx, int[] dy, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int ik = i + dx[k];
            int jk = j + dy[k];
            if (ik >= 0 && ik < n && jk >= 0 && jk < m && a[i][j] + 1 == a[ik][jk]) {
                max = Math.max(max, 1 + funcMemoization(ik, jk, n, m, a, dx, dy, dp));
            }
        }
        return max;
    }
}
