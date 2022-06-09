package com.aditya.project.array.find.majority;

import java.util.ArrayList;
import java.util.List;

// Buyer Moore Voting Algorithm
// Time Complexity: O(N)
// Auxiliary Space: O(1)
// element present more than n/3 times
public class FindMajorityElementExtended {

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Array :");
        print(a);
        System.out.println("Majority element : " + findMajorityElement(a));
    }

    public static List<Integer> findMajorityElement(int[] a) {
        int n = a.length;
        int n1 = -1;
        int n2 = -1;
        int c1 = 0;
        int c2 = 0;
        for (int i : a) {
            if (i == n1) {
                c1++;
            } else if (i == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = i;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = i;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : a) {
            if (i == n1) {
                c1++;
            } else if (i == n2) {
                c2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (c1 > n / 3) {
            list.add(n1);
        }
        if (c2 > n / 3) {
            list.add(n2);
        }
        return list;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
