package com.aditya.project.binarysearch.cuts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println("Median of 2 Sorted Arrays (Sorting) : " + funcSorting(a, b));
        System.out.println("Median of 2 Sorted Arrays (Brute Force) : " + funcBruteForce(a, b));
        System.out.println("Median of 2 Sorted Arrays (Binary Search) : " + funcBinarySearch(a, b));
    }

    // Sorting
    // TC : O((N+M)log(N+M))
    // SC : O(N+M)
    private static double funcSorting(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        for (int i : b) {
            list.add(i);
        }
        Collections.sort(list);
        if ((m + n) % 2 == 0) {
            return (list.get((n + m) / 2 - 1) + list.get((n + m) / 2)) / 2.0;
        } else {
            return list.get((n + m) / 2);
        }
    }

    // Brute Force
    // TC : O(N+M)
    // SC : O(N+M)
    private static double funcBruteForce(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (a[i] < b[j]) {
                list.add(a[i++]);
            } else {
                list.add(b[j++]);
            }
        }
        while (i < n) {
            list.add(a[i++]);
        }
        while (j < m) {
            list.add(b[j++]);
        }
        if ((m + n) % 2 == 0) {
            return (list.get((n + m) / 2 - 1) + list.get((n + m) / 2)) / 2.0;
        } else {
            return list.get((n + m) / 2);
        }
    }

    // Binary Search
    // TC : log(min(N,M))
    // SC : O(1)
    private static double funcBinarySearch(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if (n > m) {
            return funcBinarySearch(b, a);
        }
        int low = 0;
        int high = n;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;
            double left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            double left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            double right1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            double right2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];
            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }
}
