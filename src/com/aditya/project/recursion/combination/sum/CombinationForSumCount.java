package com.aditya.project.recursion.combination.sum;

import java.util.Arrays;

public class CombinationForSumCount {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[]{10, 20, 15};
        int sum = 25;
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("sum : " + sum);
        System.out.println("No. of subsets with given sum : " + countSubsetsWithSum(arr, n, sum));
    }

    // Count Subset SUM problem
    // O(2^n)
    private static int countSubsetsWithSum(int[] a, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsetsWithSum(a, n - 1, sum) + countSubsetsWithSum(a, n - 1, sum - a[n - 1]);
    }
}
