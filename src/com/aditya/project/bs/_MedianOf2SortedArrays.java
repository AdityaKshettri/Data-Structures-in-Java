package com.aditya.project.bs;

// Time Complexity : log(min(m,n))
// Space Complexity: O(1)
public class _MedianOf2SortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("Median of 2 Sorted Arrays : " + calculateMedian(a, b));
    }

    private static int calculateMedian(int[] a, int[] b) {
        int na = a.length;
        int nb = b.length;
        if (na > nb) {
            return calculateMedian(b, a);
        }
        int low = 0;
        int high = na;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (na + nb + 1) / 2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int right1 = cut1 == na ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == nb ? Integer.MAX_VALUE : b[cut2];
            if (left1 <= right2 && left2 <= right1) {
                if ((na + nb) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.max(right1, right2)) / 2;
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
