package com.aditya.project.recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{3, 1, 2};
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("Array Subsets :");
        printAllCombinations(0, new ArrayList<>(), a);
        System.out.println("Array Subsets In Reverse:");
        printAllCombinationsInReverse(0, new ArrayList<>(), a);
    }

    // Subsequence Problem
    // O(n) Aux Space
    // O(2^n)
    private static void printAllCombinations(int i, List<Integer> curr, int[] a) {
        if (i >= a.length) {
            System.out.println(curr);
            return;
        }
        curr.add(a[i]);
        printAllCombinations(i + 1, curr, a);
        curr.remove(curr.size() - 1);
        printAllCombinations(i + 1, curr, a);
    }

    private static void printAllCombinationsInReverse(int i, List<Integer> curr, int[] a) {
        if (i >= a.length) {
            System.out.println(curr);
            return;
        }
        printAllCombinationsInReverse(i + 1, curr, a);
        curr.add(a[i]);
        printAllCombinationsInReverse(i + 1, curr, a);
        curr.remove(curr.size() - 1);
    }
}
