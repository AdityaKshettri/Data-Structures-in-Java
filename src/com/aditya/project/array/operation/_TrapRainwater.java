package com.aditya.project.array.operation;

public class _TrapRainwater {

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Rainwater : " + trapRainwater(a));
    }

    // TC : O(N)
    // SC : O(1)
    private static int trapRainwater(int[] a) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (left <= right) {
            if (a[left] <= a[right]) {
                if (a[left] >= maxLeft) {
                    maxLeft = a[left];
                } else {
                    res += maxLeft - a[left];
                }
                left++;
            } else {
                if (a[right] >= maxRight) {
                    maxRight = a[right];
                } else {
                    res += maxRight - a[right];
                }
                right--;
            }
        }
        return res;
    }
}
