package com.aditya.project.stack;

import java.util.Stack;

// TC : O(N)
// SC : O(N)
public class _StockSpanProblem {

    public static void main(String[] args) {
        int[] prices = {10, 4, 5, 90, 120, 80};
        int[] span = calculateStockSpan(prices);
        for (int i : span) {
            System.out.print(i + " ");
        }
    }

    private static int[] calculateStockSpan(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] s = new int[n];
        stack.push(0);
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            s[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return s;
    }
}
