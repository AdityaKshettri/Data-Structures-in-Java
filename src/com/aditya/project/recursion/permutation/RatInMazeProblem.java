package com.aditya.project.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class RatInMazeProblem {

    public static void main(String[] args) {
        int[][] a = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println("Given Array :");
        print(a);
        int r = a.length;
        int c = a[0].length;
        boolean[][] visited = new boolean[r][c];
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        List<String> res = new ArrayList<>();
        if (a[0][0] == 1) {
            solve(0, 0, "", a, r, c, visited, di, dj, res);
        }
        System.out.println("Paths to reach destination : " + res);
    }

    private static void solve(int i, int j, String move, int[][] a, int r, int c, boolean[][] visited, int[] di, int[] dj, List<String> res) {
        if (i == r - 1 && j == c - 1) {
            res.add(move);
            return;
        }
        String dir = "DLRU";
        for (int k = 0; k < 4; k++) {
            int nexti = i + di[k];
            int nextj = j + dj[k];
            if (nexti >= 0 && nexti < r && nextj >= 0 && nextj < c && !visited[nexti][nextj] && a[nexti][nextj] == 1) {
                visited[nexti][nextj] = true;
                solve(nexti, nextj, move + dir.charAt(k), a, r, c, visited, di, dj, res);
                visited[nexti][nextj] = false;
            }
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
