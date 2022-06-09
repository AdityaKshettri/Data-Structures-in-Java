package com.aditya.project.binarysearch.cuts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthElementIn2SortedArrays {

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 8;
        System.out.println("Kth element of 2 Sorted Arrays (Sorting) : " + funcSorting(a, b, k));
        System.out.println("Kth element of 2 Sorted Arrays (Brute Force) : " + funcBruteForce(a, b, k));
        System.out.println("Kth element of 2 Sorted Arrays (Space Optimization) : " + funcSpaceOptimization(a, b, k));
        System.out.println("Kth element of 2 Sorted Arrays (Binary Search) : " + funcBinarySearch(a, b, k));
    }

    // Sorting
    // TC : O((N+M)log(N+M))
    // SC : O(N+M)
    private static int funcSorting(int[] a, int[] b, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        for (int i : b) {
            list.add(i);
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    // Brute Force
    // TC : O(N+M)
    // SC : O(N+M)
    private static int funcBruteForce(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
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
        return list.get(k - 1);
    }

    // Space Optimization
    // TC : O(K)
    // SC : O(1)
    private static int funcSpaceOptimization(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        int count = 0;
        while (i < n && j < m) {
            if (count == k) {
                break;
            } else if (a[i] <= b[j]) {
                ans = a[i++];
            } else {
                ans = b[j++];
            }
            count++;
        }
        if (count != k) {
            if (i != n - 1) {
                ans = a[k - count];
            } else {
                ans = b[k - count];
            }
        }
        return ans;
    }

    // Binary Search
    // TC : log(min(N,M))
    // SC : O(1)
    private static int funcBinarySearch(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        if (n > m) {
            return funcBinarySearch(b, a, k);
        }
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int right1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}
