package com.aditya.project.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n : " + n);
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = '.';
            }
        }
        boolean[] lr = new boolean[n];
        boolean[] ld = new boolean[2 * n - 1];
        boolean[] ud = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<>();
        func(0, a, lr, ld, ud, res);
        System.out.println(res);
    }

    // TC: O(N^2)
    // SC: O(N)
    private static void func(int col, char[][] a, boolean[] lr, boolean[] ld, boolean[] ud, List<List<String>> res) {
        if (col == a.length) {
            res.add(construct(a));
            return;
        }
        for (int row = 0; row < a.length; row++) {
            if (!lr[row] && !ld[row + col] && !ud[a.length - 1 + col - row]) {
                a[row][col] = 'Q';
                lr[row] = true;
                ld[row + col] = true;
                ud[a.length - 1 + col - row] = true;
                func(col + 1, a, lr, ld, ud, res);
                a[row][col] = '.';
                lr[row] = false;
                ld[row + col] = false;
                ud[a.length - 1 + col - row] = false;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
