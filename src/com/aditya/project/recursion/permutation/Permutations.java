package com.aditya.project.recursion.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.print("Array : ");
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println("\nPermutations : ");
        List<List<Integer>> permutations = new ArrayList<>();
        func(0, a, permutations);
        System.out.println(permutations);
    }

    // TC : O(2^N)
    // SC : O(N)
    private static void func(int index, int[] a, List<List<Integer>> res) {
        if (index == a.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : a) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = index; i < a.length; i++) {
            swap(a, index, i);
            func(index + 1, a, res);
            swap(a, index, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
