package com.aditya.project.dp.string;

public class ShortestCommonSuperSequencePrint {

    public static void main(String[] args) {
        String a = "brute";
        String b = "groot";
        System.out.println("Shortest Common Super Sequence : " + funcPrinting(a, b));
    }

    // Printing Shortest Common Super Sequence
    // TC : O(N*M)
    // SC : O(N*M)
    private static String funcPrinting(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder s = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                s.insert(0, a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                s.insert(0, a.charAt(i - 1));
                i--;
            } else {
                s.insert(0, b.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            s.insert(0, a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            s.insert(0, a.charAt(j - 1));
            j--;
        }
        return s.toString();
    }
}
