package com.aditya.project.array.find.majority;

// Moore Voting Algorithm
// Time Complexity: O(N)
// Auxiliary Space: O(1)
// element present more than n/2 times
public class FindMajorityElement {

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Array :");
        print(a);
        System.out.println("Majority element : " + findMajorityElement(a));
    }

    private static int findMajorityElement(int[] a) {
        int count = 0;
        int element = 0;
        for (int i : a) {
            if (count == 0) {
                element = i;
            }
            if (i == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
