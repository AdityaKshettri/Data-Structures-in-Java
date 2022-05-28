package com.aditya.project.stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Time Complexity: O(N)
// Space Complexity: O(K)
public class _MaxSlidingWindow {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int[] window = maxSlidingWindow(arr, k);
        for (int i : window) {
            System.out.print(i + "  ");
        }
    }

    private static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && a[deque.peekLast()] <= a[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (!deque.isEmpty() && i >= k - 1) {
                r[ri++] = a[deque.peek()];
            }
        }
        return r;
    }
}
