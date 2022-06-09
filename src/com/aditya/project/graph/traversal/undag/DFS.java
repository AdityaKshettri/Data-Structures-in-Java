package com.aditya.project.graph.traversal.undag;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.graph.Graph.initializeGraph;

public class DFS {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = initializeGraph();
        List<Integer> dfs = func(n, graph);
        System.out.println(dfs);
    }

    // TC : O(N+E)
    // SC : O(N)
    private static List<Integer> func(int n, List<List<Integer>> graph) {
        boolean[] v = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                dfs(i, v, res, graph);
            }
        }
        return res;
    }

    private static void dfs(int node, boolean[] v, List<Integer> res, List<List<Integer>> graph) {
        res.add(node);
        v[node] = true;
        for (Integer i : graph.get(node)) {
            if (!v[i]) {
                dfs(i, v, res, graph);
            }
        }
    }
}
