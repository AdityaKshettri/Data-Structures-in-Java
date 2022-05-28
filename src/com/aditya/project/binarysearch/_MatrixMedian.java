package com.aditya.project.binarysearch;

public class _MatrixMedian {

    public static void main(String[] args) {
        int row = 3, col = 3;
        // Row wise sorted array
        int[][] arr = {{1, 3, 8}, {2, 3, 4}, {1, 2, 5}};
        System.out.println("The median of the row-wise sorted matrix is: " + findMatrixMedian(arr, row, col));
    }

    public static int findMatrixMedian(int[][] a, int row, int col) {
        int low = 1;
        int high = 1000000000;
        while (low <= high) {
            int mid = (low + high) / 2;
            int c = 0;
            for (int i = 0; i < row; i++) {
                c += countSmallerThanMidInRow(a[i], mid);
            }
            if (c <= (row * col) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static int countSmallerThanMidInRow(int[] a, int mid) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (a[m] <= mid) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return low;
    }
}
