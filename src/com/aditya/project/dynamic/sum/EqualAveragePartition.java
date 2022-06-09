package com.aditya.project.dynamic.sum;

import java.util.ArrayList;
import java.util.List;

public class EqualAveragePartition {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        List<List<List<Integer>>> partitions = func(a);
        System.out.println(partitions);
    }

    // Logic :
    // A[] -> B[] + C[]
    // sum of A[] = S, no. of elements = n
    // sum of B[] = s1, no. of elements = n1
    // sum of C[] = s2, no. of elements = n2
    // Requirement :
    // s1/n1 = s2/n2
    // s1/n1 = (S - s1)/(n - n1)
    // Solving :
    // s1 = (S * n1)/n
    private static List<List<List<Integer>>> func(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        List<List<List<Integer>>> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0) {
                int s = sum * i / n;
                List<Integer> res = new ArrayList<>();
                if (checkSum(0, s, i, n, a, res)) {
                    List<Integer> left = new ArrayList<>();
                    for (int j : a) {
                        if (!res.contains(j)) {
                            left.add(j);
                        }
                    }
                    list.add(List.of(res, left));
                }
            }
        }
        return list;
    }

    private static boolean checkSum(int index, int target, int count, int n, int[] a, List<Integer> res) {
        if (count == 0) {
            return target == 0;
        }
        if (index == n) {
            return false;
        }
        if (target - a[index] >= 0) {
            res.add(a[index]);
            if (checkSum(index + 1, target - a[index], count - 1, n, a, res)) {
                return true;
            }
            res.remove(res.size() - 1);
        }
        return checkSum(index + 1, target, count, n, a, res);
    }
}
