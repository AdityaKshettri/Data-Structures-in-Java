package com.aditya.project.graph.check;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int curr;
    int prev;

    public Node(int curr, int prev) {
        this.curr = curr;
        this.prev = prev;
    }
}

public class CycleUsingBFS {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(2).add(3);
        graph.get(1).add(3);
        graph.get(2).add(4);
        if (isCyclic(n, graph))
            System.out.println("Cyclic");
        else
            System.out.println("Not Cyclic");
    }

    // TC : O(N+E)
    // SC : O(N)
    private static boolean isCyclic(int n, List<List<Integer>> graph) {
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                if (checkForCycle(i, v, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle(int s, boolean[] v, List<List<Integer>> graph) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s, -1));
        v[s] = true;
        while (!queue.isEmpty()) {
            int curr = queue.peek().curr;
            int prev = queue.peek().prev;
            queue.remove();
            for (Integer i : graph.get(curr)) {
                if (!v[i]) {
                    queue.add(new Node(i, curr));
                    v[i] = true;
                } else if (i != prev) {
                    return true;
                }
            }
        }
        return false;
    }
}
