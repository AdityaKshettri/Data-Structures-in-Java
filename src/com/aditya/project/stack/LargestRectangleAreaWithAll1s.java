package com.aditya.project.stack;

import static com.aditya.project.stack.LargestRectangleInHistogram.calculateLargestRectangle;

public class LargestRectangleAreaWithAll1s {

    public static void main(String[] args) {
        int[][] a = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println("Largest Rectangle Area with all 1s : " + func(a));
    }

    // TC : O(N*M)
    // SC : O(N)
    private static int func(int[][] a) {
        int m = a[0].length;
        int[] r = new int[m];
        int max = 0;
        for (int[] i : a) {
            for (int j = 0; j < m; j++) {
                if (i[j] == 1) {
                    r[j]++;
                } else {
                    r[j] = 0;
                }
            }
            max = Math.max(max, calculateLargestRectangle(r));
        }
        return max;
    }
}
