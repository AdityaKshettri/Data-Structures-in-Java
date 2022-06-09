package com.aditya.project.dynamic.matrix;

import java.util.Arrays;

public class CherryPickup3D {

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] a = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        int[][][] dp = new int[n][m][m];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        System.out.println("Max Cherry Pickup Sum : (Recursion) = " + funcRecursion(0, 0, m - 1, n, m, a));
        System.out.println("Max Cherry Pickup Sum : (Memoization) = " + funcMemoization(0, 0, m - 1, n, m, a, dp));
        System.out.println("Max Cherry Pickup Sum : (Tabulation) = " + funcTabulation(a));
        System.out.println("Max Cherry Pickup Sum : (Space Optimization) = " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(3^(2*N))
    // SC : O(N)
    private static int funcRecursion(int i, int j1, int j2, int n, int m, int[][] a) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }
        if (i == n - 1) {
            if (j1 == j2) {
                return a[i][j1];
            } else {
                return a[i][j1] + a[i][j2];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2) {
                    max = Math.max(max, a[i][j1] + funcRecursion(i + 1, j1 + dj1, j2 + dj2, n, m, a));
                } else {
                    max = Math.max(max, a[i][j1] + a[i][j2] + funcRecursion(i + 1, j1 + dj1, j2 + dj2, n, m, a));
                }
            }
        }
        return max;
    }

    // Memoization
    // TC : O(N*M*M) * 9
    // SC : O(N*M*M) + O(N) for Recursion
    private static int funcMemoization(int i, int j1, int j2, int n, int m, int[][] a, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        if (i == n - 1) {
            if (j1 == j2) {
                return a[i][j1];
            } else {
                return a[i][j1] + a[i][j2];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2) {
                    max = Math.max(max, a[i][j1] + funcMemoization(i + 1, j1 + dj1, j2 + dj2, n, m, a, dp));
                } else {
                    max = Math.max(max, a[i][j1] + a[i][j2] + funcMemoization(i + 1, j1 + dj1, j2 + dj2, n, m, a, dp));
                }
            }
        }
        return dp[i][j1][j2] = max;
    }

    // Tabulation
    // TC : O(N*M*M) * 9
    // SC : O(N*M*M)
    private static int funcTabulation(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][][] dp = new int[n][m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = a[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = a[n - 1][j1] + a[n - 1][j2];
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value;
                            if (j1 == j2) {
                                value = a[i][j1];
                            } else {
                                value = a[i][j1] + a[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                value = (int) -1e8;
                            }
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    // Space Optimization
    // TC : O(N*M*M) * 9
    // SC : O(M*M)
    private static int funcSpaceOptimization(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] next = new int[m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    next[j1][j2] = a[n - 1][j1];
                } else {
                    next[j1][j2] = a[n - 1][j1] + a[n - 1][j2];
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value;
                            if (j1 == j2) {
                                value = a[i][j1];
                            } else {
                                value = a[i][j1] + a[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += next[j1 + dj1][j2 + dj2];
                            } else {
                                value = (int) -1e8;
                            }
                            max = Math.max(max, value);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            next = curr;
        }
        return next[0][m - 1];
    }
}
