package com.aditya.project.graph.check.dag;

import com.aditya.project.graph.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NegativeCycle_BellmanFordAlgo {

    public static void main(String[] args) {
        int n = 6;
        List<Node> graph = new ArrayList<>();
        graph.add(new Node(3, 2, 6));
        graph.add(new Node(5, 3, 1));
        graph.add(new Node(0, 1, 5));
        graph.add(new Node(1, 5, -3));
        graph.add(new Node(1, 2, -2));
        graph.add(new Node(3, 4, -2));
        graph.add(new Node(2, 4, 3));
        int src = 0;
        System.out.println(detectCycle(src, n, graph));
    }

    // Bellman Ford Algo
    // TC : O(N*E)
    // SC : O(N)
    // Running the same check n-1 times gives you the shortest distance
    // If once more you run it and it is successful, then it has a negative cycle
    // To get shortest distance if no cycle detected, just print dist array
    private static boolean detectCycle(int src, int n, List<Node> edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < n; i++) {
            for (Node node : edges) {
                if (dist[node.getU()] + node.getW() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getW();
                }
            }
        }
        for (Node node : edges) {
            if (dist[node.getU()] + node.getW() < dist[node.getV()]) {
                return true;
            }
        }
        return false;
    }
}
