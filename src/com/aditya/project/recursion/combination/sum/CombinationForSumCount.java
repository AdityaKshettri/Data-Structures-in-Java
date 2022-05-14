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
        System.out.println("No. of subsets with given sum : " + countSubsetsWithSum(0, arr, sum));
    }

    // Count Subset SUM problem
    // O(2^n)
    private static int countSubsetsWithSum(int i, int[] a, int sum) {
        if (i == a.length) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsetsWithSum(i + 1, a, sum) + countSubsetsWithSum(i + 1, a, sum - a[i]);
    }
}
