package com.aditya.project.graph.find.undag;

import com.aditya.project.graph.Node;
import com.aditya.project.graph.NodeComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MST_PrimsAlgo {

    public static void main(String[] args) {
        int n = 5;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(1, 2));
        graph.get(1).add(new Node(0, 2));
        graph.get(1).add(new Node(2, 3));
        graph.get(2).add(new Node(1, 3));
        graph.get(0).add(new Node(3, 6));
        graph.get(3).add(new Node(0, 6));
        graph.get(1).add(new Node(3, 8));
        graph.get(3).add(new Node(1, 8));
        graph.get(1).add(new Node(4, 5));
        graph.get(4).add(new Node(1, 5));
        graph.get(2).add(new Node(4, 7));
        graph.get(4).add(new Node(2, 7));
        int cost = func(n, graph);
        System.out.println("Min spanning tree cost : " + cost);
    }

    // Prims Algorithm
    // TC : O((N+E)*logN)
    // SC : O(N) for key + O(N) for MST + O(N) for parent + O(N) for PQ
    private static int func(int n, List<List<Node>> graph) {
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new NodeComparator());
        dist[0] = 0;
        pq.add(new Node(0, dist[0]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.getV();
            vis[v] = true;
            for (Node i : graph.get(v)) {
                if (!vis[i.getV()] && i.getW() < dist[i.getV()]) {
                    dist[i.getV()] = i.getW();
                    pq.add(new Node(i.getV(), dist[i.getV()]));
                }
            }
        }
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += dist[i];
        }
        return cost;
    }
}
