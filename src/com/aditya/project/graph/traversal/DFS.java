package com.aditya.project.graph.traversal;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.graph.Graph.initializeGraph;

// Time Complexity : O(N+E)
// Space Complexity : O(N+E) + O(N) + O(N)
public class DFS {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = initializeGraph();
        List<Integer> dfs = dfsOfGraph(n, graph);
        System.out.println(dfs);
    }

    // TC : O(N+E)
    // SC : O(N)
    private static List<Integer> dfsOfGraph(int n, List<List<Integer>> graph) {
        boolean[] v = new boolean[n];
        List<Integer> dfs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                dfs(i, v, graph, dfs);
            }
        }
        return dfs;
    }

    private static void dfs(int node, boolean[] v, List<List<Integer>> graph, List<Integer> dfs) {
        dfs.add(node);
        v[node] = true;
        for (Integer i : graph.get(node)) {
            if (!v[i]) {
                dfs(i, v, graph, dfs);
            }
        }
    }
}
