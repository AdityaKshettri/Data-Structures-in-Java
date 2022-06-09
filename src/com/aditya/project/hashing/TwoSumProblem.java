package com.aditya.project.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.print("Array : ");
        print(a);
        int target = 9;
        System.out.println("Target : " + target);
        System.out.println("2 Sum (Brute Force): " + Arrays.toString(funcBruteForce(a, target)));
        System.out.println("2 Sum (HashMap): " + Arrays.toString(funcHashMap(a, target)));
    }

    // Brute Force
    // TC : O(N^2)
    // SC : O(1)
    private static int[] funcBruteForce(int[] a, int target) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && a[i] + a[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // HashMap
    // TC : O(N)
    // SC : O(N)
    private static int[] funcHashMap(int[] a, int target) {
        int n = a.length;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - a[i])) {
                res[0] = map.get(target - a[i]);
                res[1] = i;
            }
            map.put(a[i], i);
        }
        return res;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
