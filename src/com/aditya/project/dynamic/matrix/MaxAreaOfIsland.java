package com.aditya.project.dynamic.matrix;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int n = a.length;
        int m = a[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    max = Math.max(max, func(i, j, n, m, a));
                }
            }
        }
        System.out.println("Max Area of Island : " + max);
    }

    // TC : O(N*M)
    // SC : O(L) where L is size of Largest Island
    private static int func(int i, int j, int n, int m, int[][] a) {
        if (i < 0 || j < 0 || i >= n || j >= m || a[i][j] == 0) {
            return 0;
        }
        a[i][j] = 0;
        int up = func(i - 1, j, n, m, a);
        int down = func(i + 1, j, n, m, a);
        int left = func(i, j - 1, n, m, a);
        int right = func(i, j + 1, n, m, a);
        return 1 + up + down + left + right;
    }
}
