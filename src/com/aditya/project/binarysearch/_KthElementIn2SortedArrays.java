package com.aditya.project.binarysearch;

// Time Complexity : log(min(m,n))
// Space Complexity: O(1)
public class _KthElementIn2SortedArrays {

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 9;
        System.out.println("Kth element of 2 Sorted Arrays : " + findKthElement(a, b, k));
    }

    private static int findKthElement(int[] a, int[] b, int k) {
        int na = a.length;
        int nb = b.length;
        if (na > nb) {
            return findKthElement(b, a, k);
        }
        int low = Math.max(0, k - nb);
        int high = Math.min(k, na);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int right1 = cut1 == na ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == nb ? Integer.MAX_VALUE : b[cut2];
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 1;
    }
}
