package com.aditya.project.recursion.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _CombinationForSumUnique {

    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[]{1, 1, 1, 2, 2};
        int sum = 4;
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.sort(a);
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("sum : " + sum);
        System.out.println("Subsets with given sum : ");
        printCombinationForSum(0, new ArrayList<>(), sum, a);
    }

    // Subsequence SUM Problem without duplicates
    // O(n) Aux Space
    // O(2^n)
    private static void printCombinationForSum(int i, List<Integer> curr, int sum, int[] a) {
        if (sum == 0) {
            System.out.println(curr);
            return;
        }
        for (int j = i; j < a.length; j++) {
            if (j != i && a[j] == a[j - 1]) {
                continue;
            }
            if (a[j] > sum) {
                break;
            }
            curr.add(a[j]);
            printCombinationForSum(j + 1, curr, sum - a[j], a);
            curr.remove(curr.size() - 1);
        }
    }
}
