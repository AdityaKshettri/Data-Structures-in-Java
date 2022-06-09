package com.aditya.project.array.matrix;

// Time Complexity: O(M*N)
// Auxiliary Space: O(1)
public class SetZeroesMatrix {

    public static void main(String[] args) {
        int[][] a = {{1, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println("Given Matrix : ");
        print(a);
        setZeroesMatrix(a);
        System.out.println("After setting Zeroes : ");
        print(a);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void setZeroesMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        // variables to check if there are any 0
        // in first row and column
        boolean row = false;
        boolean col = false;

        // updating the first row and col if 0
        // is encountered
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && a[i][j] == 0) {
                    row = true;
                }
                if (j == 0 && a[i][j] == 0) {
                    col = true;
                }
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        // Modify the input matrix mat[] using the
        // first row and first column of Matrix mat
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) {
                    a[i][j] = 0;
                }
            }
        }

        // modify first row if there was any 0
        if (row) {
            for (int j = 0; j < m; j++) {
                a[0][j] = 0;
            }
        }

        // modify first col if there was any 0
        if (col) {
            for (int i = 0; i < n; i++) {
                a[i][0] = 0;
            }
        }
    }
}
