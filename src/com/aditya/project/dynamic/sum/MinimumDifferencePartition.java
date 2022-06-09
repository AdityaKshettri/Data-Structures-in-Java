package com.aditya.project.dynamic.sum;

/*
    Partition a set into two subsets such that
    the difference of subset sums is minimum
 */
public class MinimumDifferencePartition {

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 2, 2, 1};
        int n = a.length;
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        System.out.println("Min diff b/w 2 sets (Recursion) : " + funcRecursion(n - 1, 0, sum, a));
    }

    // TC : O(exp)
    // SC : O(N)
    private static int funcRecursion(int index, int curr, int sum, int[] a) {
        if (index == 0) {
            return Math.abs((sum - curr) - curr);
        }
        int notTake = funcRecursion(index - 1, curr, sum, a);
        int take = funcRecursion(index - 1, curr + a[index], sum, a);
        return Math.min(take, notTake);
    }
}
