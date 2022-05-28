package com.aditya.project.array;

// Time Complexity: O(log(M*N)
// Auxiliary Space: O(1)
public class _SearchIn2dMatrix {

    public static void main(String[] args) {
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        print(a);
        int target = 16;
        System.out.println("target to be searched: " + target);
        System.out.println("target present in matrix : " + searchMatrix(a, target));
    }

    private static boolean searchMatrix(int[][] a, int target) {
        int r = a.length;
        int c = a[0].length;
        int low = 0;
        int high = (r * c) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid / c][mid % c] == target) {
                return true;
            } else if (a[mid / c][mid % c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static void print(int[][] a) {
        for (int[] nums : a) {
            for (int num : nums) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
