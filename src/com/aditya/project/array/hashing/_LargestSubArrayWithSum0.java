package com.aditya.project.array.hashing;

import java.util.HashMap;

public class _LargestSubArrayWithSum0 {

    public static void main(String[] args) {
        int[] a = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Array :");
        print(a);
        System.out.println("Largest SubArray Length with Sum 0 : " + getLargestSubArrayWithSum0(a));
    }

    private static int getLargestSubArrayWithSum0(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
