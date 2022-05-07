package com.aditya.project.array;

// Time Complexity: O(N)
// Auxiliary Space: O(1)
// Grid Unique Paths = (m+n-2)C(n-1) = (m+n-2)C(m-1)
public class GridUniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("Unique Path = " + getUniquePaths(m, n));
    }

    private static int getUniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = n - 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }
}
