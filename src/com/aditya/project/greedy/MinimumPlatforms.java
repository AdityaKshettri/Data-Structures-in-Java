package com.aditya.project.greedy;

import java.util.Arrays;

// TC : O(NLogN)
// SC : O(1)
public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform = 1;
        int max = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else {
                platform--;
                j++;
            }
            if (platform > max) {
                max = platform;
            }
        }
        System.out.println("No. of minimum platforms needed : " + max);
    }
}
