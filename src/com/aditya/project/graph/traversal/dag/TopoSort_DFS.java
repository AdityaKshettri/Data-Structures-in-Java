package com.aditya.project.graph.traversal.dag;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort_DFS {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            graph.add(arr);
        }
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        List<Integer> topologicalSort = topologicalSort(n, graph);
        System.out.println(topologicalSort);
    }

    // TC : O(N+E)
    // SC : O(N) for Visited + O(N) for Stack
    // ASC : O(N) for Recursion
    private static List<Integer> topologicalSort(int n, List<List<Integer>> graph) {
        boolean[] v = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                topologicalSortUtil(i, v, graph, stack);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void topologicalSortUtil(int node, boolean[] v, List<List<Integer>> graph, Stack<Integer> stack) {
        v[node] = true;
        for (Integer i : graph.get(node)) {
            if (!v[i]) {
                topologicalSortUtil(i, v, graph, stack);
            }
        }
        stack.push(node);
    }
}
