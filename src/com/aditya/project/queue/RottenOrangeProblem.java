package com.aditya.project.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangeProblem {

    public static void main(String[] args) {
        int[][] a = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int rotting = func(a);
        System.out.println("Minimum Number of Minutes Required : " + rotting);
    }

    // TC : O(N*M)
    // SC : O(N*M)
    private static int func(int[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int r = a.length;
        int c = a[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oranges = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 2) {
                    q.offer(new int[]{i, j});
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
        while (!q.isEmpty()) {
            int n = q.size();
            count += n;
            for (int i = 0; i < n; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    if (x < 0 || y < 0 || x >= r || y >= c || a[x][y] == 0 || a[x][y] == 2) {
                        continue;
                    }
                    a[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
            if (q.size() != 0) {
                time++;
            }
        }
        return oranges == count ? time : -1;
    }
}
