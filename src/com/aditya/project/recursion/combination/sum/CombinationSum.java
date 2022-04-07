package com.aditya.project.recursion.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{3, 1, 2};
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("Array Subsets :");
        List<Integer> sum = new ArrayList<>();
        generateSubsetSum(0, 0, a, n, sum);
        Collections.sort(sum);
        System.out.println(sum);
    }

    private static void generateSubsetSum(int i, int sum, int[] a, int n, List<Integer> subsetSum) {
        if (i >= n) {
            subsetSum.add(sum);
            return;
        }
        generateSubsetSum(i + 1, sum + a[i], a, n, subsetSum);
        generateSubsetSum(i + 1, sum, a, n, subsetSum);
    }
}
