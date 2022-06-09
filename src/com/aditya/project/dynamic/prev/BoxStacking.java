package com.aditya.project.dynamic.prev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BoxStacking {

    public static void main(String[] args) {
        int[][] boxes = {
                {4, 6, 7},
                {1, 2, 3},
                {4, 5, 6},
                {10, 12, 32}
        };
        List<Box> a = initialize(boxes);
        int n = a.size();
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Max height of boxes (Recursion) : " + funcRecursion(n - 1, -1, a));
        System.out.println("Max height of boxes (Memoization) : " + funcMemoization(n - 1, -1, a, dp));
        System.out.println("Max height of boxes (Tabulation) : " + funcTabulation(n, a));
        System.out.println("Max height of boxes (Space Optimization) : " + funcSpaceOptimization(n, a));
    }

    private static List<Box> initialize(int[][] a) {
        List<Box> boxes = new ArrayList<>();
        for (int[] i : a) {
            boxes.add(new Box(Math.max(i[0], i[1]), Math.min(i[0], i[1]), i[2]));
            boxes.add(new Box(Math.max(i[1], i[2]), Math.min(i[1], i[2]), i[0]));
            boxes.add(new Box(Math.max(i[0], i[2]), Math.min(i[0], i[2]), i[1]));
        }
        boxes.sort(new BoxComparator());
        return boxes;
    }

    // Recursion
    // TC : O(exp)
    // SC : O(3N)
    private static int funcRecursion(int index, int prev, List<Box> a) {
        if (index < 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = index; i >= 0; i--) {
            if (prev == -1 || a.get(i).l < a.get(prev).l && a.get(i).b < a.get(prev).b) {
                max = Math.max(max, a.get(i).h + funcRecursion(i - 1, i, a));
            }
        }
        return max;
    }

    // Memoization
    // TC : O((3N)^3)
    // SC : O((3N)^2) + O(3N) for recursion
    private static int funcMemoization(int index, int prev, List<Box> a, int[][] dp) {
        if (index < 0) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = index; i >= 0; i--) {
            if (prev == -1 || a.get(i).l < a.get(prev).l && a.get(i).b < a.get(prev).b) {
                max = Math.max(max, a.get(i).h + funcMemoization(i - 1, i, a, dp));
            }
        }
        return dp[index][prev + 1] = max;
    }

    // Tabulation
    // TC : O((3N)^3)
    // SC : O((3N)^2)
    private static int funcTabulation(int n, List<Box> a) {
        int[][] dp = new int[n][n + 1];
        for (int index = 0; index < n; index++) {
            for (int prev = n - 1; prev >= -1; prev--) {
                int max = Integer.MIN_VALUE;
                for (int i = index; i >= 0; i--) {
                    if (prev == -1 || a.get(i).l < a.get(prev).l && a.get(i).b < a.get(prev).b) {
                        if (i - 1 >= 0) {
                            max = Math.max(max, a.get(i).h + dp[i - 1][i + 1]);
                        } else {
                            max = Math.max(max, a.get(i).h);
                        }
                    }
                }
                dp[index][prev + 1] = max;
            }
        }
        return dp[n - 1][0];
    }

    // Space Optimization
    // TC : O((3N)^3)
    // SC : O(3N)
    private static int funcSpaceOptimization(int n, List<Box> a) {
        int[] prev = new int[n + 1];
        for (int index = 0; index < n; index++) {
            int[] curr = new int[n + 1];
            for (int prevI = n - 1; prevI >= -1; prevI--) {
                int max = Integer.MIN_VALUE;
                for (int i = index; i >= 0; i--) {
                    if (prevI == -1 || a.get(i).l < a.get(prevI).l && a.get(i).b < a.get(prevI).b) {
                        if (i - 1 >= 0) {
                            max = Math.max(max, a.get(i).h + prev[i + 1]);
                        } else {
                            max = Math.max(max, a.get(i).h);
                        }
                    }
                }
                curr[prevI + 1] = max;
            }
            prev = curr;
        }
        return prev[0];
    }

    private static class Box {
        int l;
        int b;
        int h;

        Box(int l, int b, int h) {
            this.l = l;
            this.b = b;
            this.h = h;
        }

        int getArea() {
            return l * b;
        }
    }

    private static class BoxComparator implements Comparator<Box> {

        @Override
        public int compare(Box o1, Box o2) {
            return Integer.compare(o1.getArea(), o2.getArea());
        }
    }
}
