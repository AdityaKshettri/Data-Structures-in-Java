package com.aditya.project.recursion.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationForSum {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[]{1, 2, 1};
        int sum = 2;
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("sum : " + sum);
        System.out.println("Subsets with given sum : ");
        printCombinationForSum(0, new ArrayList<>(), sum, arr);
    }

    // Subsequence SUM Problem
    // O(n) Aux Space
    // O(2^n)
    private static void printCombinationForSum(int i, List<Integer> curr, int sum, int[] a) {
        if (i >= a.length) {
            if (sum == 0) {
                System.out.println(curr);
            }
            return;
        }
        if (a[i] <= sum) {
            curr.add(a[i]);
            printCombinationForSum(i + 1, curr, sum - a[i], a);
            curr.remove(curr.size() - 1);
        }
        printCombinationForSum(i + 1, curr, sum, a);
    }
}
