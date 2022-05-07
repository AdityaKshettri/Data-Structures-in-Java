package com.aditya.project.array.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(N)
// Auxiliary Space: O(N)
public class TwoSumProblem {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.println("Array :");
        print(a);
        int target = 9;
        System.out.println("Target : " + target);
        System.out.println("2 Sum : " + Arrays.toString(get2Sum(a, target)));
    }

    private static int[] get2Sum(int[] a, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i])) {
                res[0] = map.get(target - a[i]);
                res[1] = i;
                return res;
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
