package com.aditya.project.stack;

import java.util.LinkedList;
import java.util.Queue;

public class _RottenOrangeProblem {

    public static void main(String[] args) {
        int[][] a = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int rotting = orangesRotting(a);
        System.out.println("Minimum Number of Minutes Required : " + rotting);
    }

    private static int orangesRotting(int[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int rows = a.length;
        int cols = a[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int oranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (a[i][j] != 0) {
                    oranges++;
                }
            }
        }
        if (oranges == 0) {
            return 0;
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            count += n;
            for (int i = 0; i < n; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || a[x][y] == 0 || a[x][y] == 2) {
                        continue;
                    }
                    a[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            if (queue.size() != 0) {
                time++;
            }
        }
        return oranges == count ? time : -1;
    }
}
