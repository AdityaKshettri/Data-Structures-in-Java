package com.aditya.project.hashing;

import java.util.HashMap;

public class LargestSubArrayWithSum0 {

    public static void main(String[] args) {
        int[] a = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Largest SubArray Length with Sum 0 (Brute Force) : " + funcBruteForce(a));
        System.out.println("Largest SubArray Length with Sum 0 (HashMap) : " + funcHashMap(a));
        System.out.println("Largest SubArray Length with Sum 0 (Space Optimized) : " + funcSpaceOptimized(a));
    }

    // TC : O(N^2)
    // SC : O(1)
    private static int funcBruteForce(int[] a) {
        int n = a.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // TC : O(N)
    // SC : O(N)
    private static int funcHashMap(int[] a) {
        int n = a.length;
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0) {
                max = i + 1;
            } else if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    // TC : O(N)
    // SC : O(1)
    private static int funcSpaceOptimized(int[] a) {
        int n = a.length;
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        while (i < n) {
            sum += a[i];
            if (sum == 0) {
                max = Math.max(max, i - j + 1);
            } else if (sum > 0) {
                while (sum > 0 && j < n) {
                    sum -= a[j++];
                }
                if (sum == 0) {
                    max = Math.max(max, i - j + 1);
                }
            }
            i++;
        }
        return max;
    }
}
