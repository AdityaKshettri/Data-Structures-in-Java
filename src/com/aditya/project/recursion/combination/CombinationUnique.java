package com.aditya.project.recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationUnique {

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{1, 1, 2};
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("Unique Subsets :");
        printAllUniqueCombinations(0, new ArrayList<>(), a);
    }

    // Subsequence Problem
    // O(n) Aux Space
    // O(2^n)
    private static void printAllUniqueCombinations(int index, List<Integer> curr, int[] a) {
        System.out.println(curr);
        for (int i = index; i < a.length; i++) {
            if (i != index && a[i] == a[i - 1]) {
                continue;
            }
            curr.add(a[i]);
            printAllUniqueCombinations(i + 1, curr, a);
            curr.remove(curr.size() - 1);
        }
    }
}
