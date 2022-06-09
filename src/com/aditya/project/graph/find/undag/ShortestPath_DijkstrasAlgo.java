package com.aditya.project.graph.find.undag;

import com.aditya.project.graph.Node;
import com.aditya.project.graph.NodeComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath_DijkstrasAlgo {

    public static void main(String[] args) {
        int n = 5;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(1, 2));
        graph.get(1).add(new Node(0, 2));
        graph.get(1).add(new Node(2, 4));
        graph.get(2).add(new Node(1, 4));
        graph.get(0).add(new Node(3, 1));
        graph.get(3).add(new Node(0, 1));
        graph.get(3).add(new Node(2, 3));
        graph.get(2).add(new Node(3, 3));
        graph.get(1).add(new Node(4, 5));
        graph.get(4).add(new Node(1, 5));
        graph.get(2).add(new Node(4, 1));
        graph.get(4).add(new Node(2, 1));
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

    // TC : O((N+E)*logN)
    // SC : O(N) for dist + O(N) for PQ
    private static int[] shortestPath(int src, int n, List<List<Node>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new NodeComparator());
        pq.add(new Node(src, 0));
        dist[src] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node i : graph.get(node.getV())) {
                if (dist[node.getV()] + i.getW() < dist[i.getV()]) {
                    dist[i.getV()] = dist[node.getV()] + i.getW();
                    pq.add(new Node(i.getV(), dist[i.getV()]));
                }
            }
        }
        return dist;
    }
}
