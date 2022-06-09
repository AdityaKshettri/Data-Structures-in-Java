package com.aditya.project.hashing;

import java.util.HashMap;

public class LargestSubArrayWithSumK {

    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println("Largest SubArray Length with Sum K (Brute Force) : " + funcBruteForce(a, k));
        System.out.println("Largest SubArray Length with Sum K (HashMap) : " + funcHashMap(a, k));
        System.out.println("Largest SubArray Length with Sum K (Space Optimized) : " + funcSpaceOptimized(a, k));
    }

    // TC : O(N^2)
    // SC : O(1)
    private static int funcBruteForce(int[] a, int k) {
        int n = a.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // TC : O(N)
    // SC : O(N)
    private static int funcHashMap(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == k) {
                max = i + 1;
            }
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }

    // TC : O(N)
    // SC : O(1)
    // Note : This Algo doesn't work for negative no.
    private static int funcSpaceOptimized(int[] a, int k) {
        int n = a.length;
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        while (i < n) {
            sum += a[i];
            if (sum == k) {
                max = Math.max(max, i - j + 1);
            } else if (sum > k) {
                while (sum > k && j < n) {
                    sum -= a[j++];
                }
                if (sum == k) {
                    max = Math.max(max, i - j + 1);
                }
            }
            i++;
        }
        return max;
    }
}
