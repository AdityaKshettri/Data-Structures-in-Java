package com.aditya.project.dynamic.partition;

import java.util.Arrays;

public class EvaluateBooleanExpToTrue {

    public static void main(String[] args) {
        String a = "T|T&F^T";
        int n = a.length();
        int[][][] dp = new int[n][n][2];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        System.out.println("No. of ways (Recursion) : " + funcRecursion(0, n - 1, 1, a));
        System.out.println("No. of ways (Memoization) : " + funcMemoization(0, n - 1, 1, a, dp));
        System.out.println("No. of ways (Tabulation) : " + funcTabulation(n, a));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int i, int j, int isTrue, String a) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return a.charAt(i) == 'T' ? 1 : 0;
            } else {
                return a.charAt(i) == 'F' ? 1 : 0;
            }
        }
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lT = funcRecursion(i, k - 1, 1, a);
            int lF = funcRecursion(i, k - 1, 0, a);
            int rT = funcRecursion(k + 1, j, 1, a);
            int rF = funcRecursion(k + 1, j, 0, a);
            char c = a.charAt(k);
            if (c == '&') {
                if (isTrue == 1) {
                    ways += lT * rT;
                } else {
                    ways += lF * rT + lT * rF + lF * rF;
                }
            } else if (c == '|') {
                if (isTrue == 1) {
                    ways += lF * rT + lT * rF + lT * rT;
                } else {
                    ways += lF * rF;
                }
            } else if (c == '^') {
                if (isTrue == 1) {
                    ways += lF * rT + lT * rF;
                } else {
                    ways += lF * rF + lT * rT;
                }
            }
        }
        return ways;
    }

    // Memoization
    // TC : O(N*N*2)
    // SC : O(N*N*2) + O(N) for Recursion
    private static int funcMemoization(int i, int j, int isTrue, String a, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return a.charAt(i) == 'T' ? 1 : 0;
            } else {
                return a.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lT = funcMemoization(i, k - 1, 1, a, dp);
            int lF = funcMemoization(i, k - 1, 0, a, dp);
            int rT = funcMemoization(k + 1, j, 1, a, dp);
            int rF = funcMemoization(k + 1, j, 0, a, dp);
            char c = a.charAt(k);
            if (c == '&') {
                if (isTrue == 1) {
                    ways += lT * rT;
                } else {
                    ways += lF * rT + lT * rF + lF * rF;
                }
            } else if (c == '|') {
                if (isTrue == 1) {
                    ways += lF * rT + lT * rF + lT * rT;
                } else {
                    ways += lF * rF;
                }
            } else if (c == '^') {
                if (isTrue == 1) {
                    ways += lF * rT + lT * rF;
                } else {
                    ways += lF * rF + lT * rT;
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }

    // Tabulation
    // TC : O(N*N*2)
    // SC : O(N*N*2)
    private static int funcTabulation(int n, String a) {
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = a.charAt(i) == 'T' ? 1 : 0;
            dp[i][i][0] = a.charAt(i) == 'F' ? 1 : 0;
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    int ways = 0;
                    for (int k = i + 1; k <= j - 1; k += 2) {
                        int lT = dp[i][k - 1][1];
                        int lF = dp[i][k - 1][0];
                        int rT = dp[k + 1][j][1];
                        int rF = dp[k + 1][j][0];
                        char c = a.charAt(k);
                        if (c == '&') {
                            if (isTrue == 1) {
                                ways += lT * rT;
                            } else {
                                ways += lF * rT + lT * rF + lF * rF;
                            }
                        } else if (c == '|') {
                            if (isTrue == 1) {
                                ways += lF * rT + lT * rF + lT * rT;
                            } else {
                                ways += lF * rF;
                            }
                        } else if (c == '^') {
                            if (isTrue == 1) {
                                ways += lF * rT + lT * rF;
                            } else {
                                ways += lF * rF + lT * rT;
                            }
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][n - 1][1];
    }
}
