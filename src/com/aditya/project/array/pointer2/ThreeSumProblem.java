package com.aditya.project.array.pointer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblem {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println("Unique triplets with sum 0 (Brute Force) : " + funcBruteForce(a));
        System.out.println("Unique triplets with sum 0 (Optimized) : " + funcOptimized(a));
    }

    // TC : O(N^3)
    // OC : O(1)
    private static List<List<Integer>> funcBruteForce(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        set.add(List.of(a[i], a[j], a[k]));
                    }
                }
            }
        }
        return set.stream().toList();
    }

    // TC : O(N^2)
    // OC : O(1)
    private static List<List<Integer>> funcOptimized(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int sum = -a[i];
            int front = i + 1;
            int back = n - 1;
            while (front < back) {
                if (a[front] + a[back] == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a[i]);
                    list.add(a[front]);
                    list.add(a[back]);
                    set.add(list);
                    while (front < back && a[front] == list.get(1)) {
                        front++;
                    }
                    while (front < back && a[back] == list.get(2)) {
                        back--;
                    }
                } else if (a[front] + a[back] < sum) {
                    front++;
                } else {
                    back--;
                }
            }
        }
        return set.stream().toList();
    }
}
