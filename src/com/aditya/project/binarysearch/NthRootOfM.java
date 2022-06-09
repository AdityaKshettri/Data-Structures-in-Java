package com.aditya.project.binarysearch;

public class NthRootOfM {

    public static void main(String[] args) {
        int m = 27;
        int n = 3;
        System.out.println("Nth root of M : " + func(m, n));
    }

    // TC : O(NlogM)
    // SC : O(1)
    private static double func(int m, int n) {
        double low = 1;
        double high = m;
        double eps = 1e-6;
        while (high - low > eps) {
            double mid = (low + high) / 2;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static double multiply(double number, int n) {
        double product = 1;
        for (int i = 1; i <= n; i++) {
            product *= number;
        }
        return product;
    }
}
