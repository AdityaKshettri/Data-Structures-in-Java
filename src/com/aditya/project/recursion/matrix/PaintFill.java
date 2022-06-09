package com.aditya.project.recursion.matrix;

public class PaintFill {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4;
        int y = 4;
        int c = 3;
        int n = a.length;
        int m = a[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        System.out.println("Given Matrix :");
        print(a);
        func(x, y, n, m, a[x][y], c, a, dx, dy);
        System.out.println("After Colouring :");
        print(a);
    }

    // TC : O(N*M)
    // SC : O(N*M) for Recursion
    private static void func(int i, int j, int n, int m, int prev, int c, int[][] a, int[] dx, int[] dy) {
        if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] != prev) {
            return;
        }
        a[i][j] = c;
        for (int k = 0; k < 4; k++) {
            func(i + dx[k], j + dy[k], n, m, prev, c, a, dx, dy);
        }
    }

    private static void print(int[][] a) {
        for (int[] nums : a) {
            for (int num : nums) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
