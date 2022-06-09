package com.aditya.project.graph.find.dag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SCC_KosarajusAlgo {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(4);
        List<List<Integer>> scc = findSCC(n, graph);
        System.out.println(scc);
    }

    private static void dfs(int node, boolean[] vis, Stack<Integer> stack, List<List<Integer>> graph) {
        vis[node] = true;
        for (Integer i : graph.get(node)) {
            if (!vis[i]) {
                dfs(i, vis, stack, graph);
            }
        }
        stack.push(node);
    }

    private static void dfs(int node, boolean[] vis, List<Integer> res, List<List<Integer>> graph) {
        vis[node] = true;
        res.add(node);
        for (Integer i : graph.get(node)) {
            if (!vis[i]) {
                dfs(i, vis, res, graph);
            }
        }
    }

    // Kosaraju's Algo
    // TC : O(N+E)
    // SC : O(N+E)
    private static List<List<Integer>> findSCC(int n, List<List<Integer>> graph) {

        // Find Topological Sort
        boolean[] vis = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, stack, graph);
            }
        }

        // Find Transpose Graph
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j : graph.get(i)) {
                transpose.get(j).add(i);
            }
        }

        // DFS on transpose graph
        Arrays.fill(vis, false);
        List<List<Integer>> scc = new ArrayList<>();
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!vis[node]) {
                List<Integer> component = new ArrayList<>();
                dfs(node, vis, component, transpose);
                scc.add(component);
            }
        }
        return scc;
    }
}
