package com.aditya.project.dp;

// Time Complexity : O(NlogN)
// Space Complexity : 0(N)
public class _LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        print(a);
        System.out.println("Longest Increasing Subsequence : " + getLongestIncreasingSubsequence(a));
    }

    private static int getLongestIncreasingSubsequence(int[] a) {
        int n = a.length;
        int[] temp = new int[n];
        temp[0] = a[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] < temp[0]) {
                temp[0] = a[i];
            } else if (a[i] > temp[len - 1]) {
                temp[len++] = a[i];
            } else {
                int j = getCeilIndexFromBinarySearch(temp, -1, len - 1, a[i]);
                temp[j] = a[i];
            }
        }
        return len;
    }

    private static int getCeilIndexFromBinarySearch(int[] a, int l, int r, int key) {
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
