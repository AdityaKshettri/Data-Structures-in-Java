package com.aditya.project.graph.find.undag;

import java.util.ArrayList;
import java.util.List;

public class Bridges {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(1).add(3);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        System.out.println(func(n, graph));
    }

    // TC : O(N+E)
    // SC : O(N)
    // Formula : low[i] > tin[node]
    private static List<List<Integer>> func(int n, List<List<Integer>> graph) {
        int timer = 0;
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, timer, graph, bridges);
            }
        }
        return bridges;
    }

    private static void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, int timer, List<List<Integer>> graph, List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        for (Integer i : graph.get(node)) {
            if (i == parent) {
                continue;
            }
            if (!vis[i]) {
                dfs(i, node, vis, tin, low, timer, graph, bridges);
                low[node] = Math.min(low[node], low[i]);
                if (low[i] > tin[node]) {
                    bridges.add(new ArrayList<>(List.of(i, node)));
                }
            } else {
                low[node] = Math.min(low[node], tin[i]);
            }
        }
    }
}
