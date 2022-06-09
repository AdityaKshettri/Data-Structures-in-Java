package com.aditya.project.array.matrix;

// Time Complexity: O(N^2)
// Auxiliary Space: O(1)
// Using same Matrix
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Given Matrix : ");
        print(a);
        rotateMatrix(a);
        System.out.println("After Rotating Matix : ");
        print(a);
    }

    private static void rotateMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        // transpose of matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }

        // reverse each row of matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int t = a[i][j];
                a[i][j] = a[i][n - 1 - j];
                a[i][n - 1 - j] = t;
            }
        }
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
