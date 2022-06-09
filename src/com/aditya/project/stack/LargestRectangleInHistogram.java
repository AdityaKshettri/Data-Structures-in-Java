package com.aditya.project.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3, 1};
        System.out.println("Largest area of rectangle the histogram : " + calculateLargestRectangle(a));
    }

    // TC : O(N)
    // SC : O(N)
    public static int calculateLargestRectangle(int[] a) {
        int n = a.length;

        Stack<Integer> stack = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        // Calculating leftSmall[]
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        // Clearing the stack to be reused
        while (!stack.isEmpty()) {
            stack.pop();
        }

        // Calculating rightSmall[]
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        // Finding largest rectangle
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (rightSmall[i] - leftSmall[i] + 1) * a[i]);
        }
        return max;
    }
}
