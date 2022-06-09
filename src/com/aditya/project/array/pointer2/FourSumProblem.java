package com.aditya.project.array.pointer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {

    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println("Using 4 Pointer : " + func4Pointer(a, target));
        //System.out.println("Using 3 Pointer : " + func3Pointer(a, target));
        System.out.println("Using 2 Pointer : " + func2Pointer(a, target));
    }

    // TC : O(N^4)
    // SC : O(N^2)
    private static List<List<Integer>> func4Pointer(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(a[i]);
                            list.add(a[j]);
                            list.add(a[k]);
                            list.add(a[l]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

    // TC : O(N^3*logN)
    // SC : O(N^2)
    private static List<List<Integer>> func3Pointer(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x = target - a[i] - a[j] - a[k];
                    int low = k + 1;
                    int high = n - 1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (x > a[mid]) {
                            low = mid + 1;
                        } else if (x < a[mid]) {
                            high = mid - 1;
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(a[i]);
                            list.add(a[j]);
                            list.add(a[k]);
                            list.add(a[mid]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

    // TC : O(N^3)
    // SC : O(N^2)
    private static List<List<Integer>> func2Pointer(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = target - a[i] - a[j];
                int front = j + 1;
                int back = n - 1;
                while (front < back) {
                    int sum = a[front] + a[back];
                    if (sum < x) {
                        front++;
                    } else if (sum > x) {
                        back--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(a[i]);
                        list.add(a[j]);
                        list.add(a[front]);
                        list.add(a[back]);
                        res.add(list);
                        while (front < back && a[front] == list.get(2)) {
                            front++;
                        }
                        while (front < back && a[back] == list.get(3)) {
                            back--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
