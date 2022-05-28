package com.aditya.project.dp.sum;

import static com.aditya.project.dp.sum.MaxSumOfNonAdjacent.funcSpaceOptimization;

public class MaxSumOfNonAdjacentCircular {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 5};
        int n = a.length;
        int[] a1 = new int[n - 1];
        int[] a2 = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                a2[i - 1] = a[i];
            }
            if (i != n - 1) {
                a1[i] = a[i];
            }
        }
        int max = Math.max(funcSpaceOptimization(a1), funcSpaceOptimization(a2));
        System.out.println("Max Sum Of Circular Non Adjacent Elements = " + max);
    }
}
