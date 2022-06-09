package com.aditya.project.graph.find.dag;

import com.aditya.project.graph.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPath_TopoSort {

    public static void main(String[] args) {
        int n = 6;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(4, 1));
        graph.get(1).add(new Node(2, 3));
        graph.get(2).add(new Node(3, 6));
        graph.get(4).add(new Node(2, 2));
        graph.get(4).add(new Node(5, 4));
        graph.get(5).add(new Node(3, 1));
        int src = 0;
        int[] dist = shortestPath(src, n, graph);
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.printf("Shortest distance for %d is %d\n", i, -1);
            } else {
                System.out.printf("Shortest distance for %d is %d\n", i, dist[i]);
            }
        }
    }

    // TC : O(N+E)
    // SC : O(N) for dist + O(N) for Stack
    private static int[] shortestPath(int src, int n, List<List<Node>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topologicalSortUtil(i, vis, graph, stack);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (Node i : graph.get(node)) {
                if (dist[node] + i.getW() < dist[i.getV()]) {
                    dist[i.getV()] = dist[node] + i.getW();
                }
            }
        }
        return dist;
    }

    private static void topologicalSortUtil(int node, boolean[] vis, List<List<Node>> graph, Stack<Integer> stack) {
        vis[node] = true;
        for (Node i : graph.get(node)) {
            if (!vis[i.getV()]) {
                topologicalSortUtil(i.getV(), vis, graph, stack);
            }
        }
        stack.push(node);
    }
}
