package com.aditya.project.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian {

    public static void main(String[] args) {
        // Row wise sorted array
        int[][] a = {
                {1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}
        };
        int r = 3;
        int c = 3;
        System.out.println("The median of the row-wise sorted matrix is (Brute Force) : " + funcBruteForce(a, r, c));
        System.out.println("The median of the row-wise sorted matrix is (Binary Search) : " + funcBinarySearch(a, r, c));
        System.out.println("The median of the row-wise sorted matrix is (Optimized) : " + funcOptimized(a, r, c));
    }

    // Brute Force
    // TC : O((N*M)log(N*M))
    // SC : O(N*M)
    private static int funcBruteForce(int[][] a, int r, int c) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : a) {
            for (int j : i) {
                list.add(j);
            }
        }
        Collections.sort(list);
        return list.get(r * c / 2);
    }

    // Binary Search
    // TC : O(log(max-min)*N*logM)
    // SC : O(1)
    // Logic: there has to be (r*c)/2-1 smaller elements before median
    private static int funcBinarySearch(int[][] a, int r, int c) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            low = Math.min(low, a[i][0]);
            high = Math.max(high, a[i][0]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < r; i++) {
                count += countAllSmaller(a[i], mid);
            }
            if (count <= (r * c) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Optimized
    // TC : O(N*logM)
    // SC : O(1)
    // Here, log(1e9-1) is a constant in TC
    private static int funcOptimized(int[][] a, int r, int c) {
        int low = 1;
        int high = (int) 1e9;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < r; i++) {
                count += countAllSmaller(a[i], mid);
            }
            if (count <= (r * c) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countAllSmaller(int[] a, int target) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
