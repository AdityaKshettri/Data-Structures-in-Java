package com.aditya.project.dp.sum;

import static com.aditya.project.dp.sum.SubsetSumEqualsTarget.funcSpaceOptimization;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 3, 4, 5};
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % 2 == 1) {
            System.out.println("Partition into equal arrays not possible as sum is odd : " + sum);
            return;
        }
        System.out.println("Partition into equal sum : " + funcSpaceOptimization(a, sum / 2));
    }
}
