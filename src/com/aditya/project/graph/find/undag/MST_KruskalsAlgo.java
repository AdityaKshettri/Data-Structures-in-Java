package com.aditya.project.graph.find.undag;

import com.aditya.project.graph.Node;
import com.aditya.project.graph.NodeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MST_KruskalsAlgo {

    public static void main(String[] args) {
        int n = 5;
        List<Node> graph = new ArrayList<>();
        graph.add(new Node(0, 1, 2));
        graph.add(new Node(0, 3, 6));
        graph.add(new Node(1, 3, 8));
        graph.add(new Node(1, 2, 3));
        graph.add(new Node(1, 4, 5));
        graph.add(new Node(2, 4, 7));
        int cost = minSpanningTree(n, graph);
        System.out.println("Min Spanning Tree Cost : " + cost);
    }

    private static int findParent(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    // Kruskal's Algorithm
    // TC : O(E*logE)
    // SC : O(N) for MST + O(N) for parent + O(N) for rank
    private static int minSpanningTree(int n, List<Node> graph) {
        Collections.sort(graph, new NodeComparator());
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        List<Node> mst = new ArrayList<>();
        for (Node i : graph) {
            if (findParent(i.getU(), parent) != findParent(i.getV(), parent)) {
                cost += i.getW();
                mst.add(i);
                union(i.getU(), i.getV(), parent, rank);
            }
        }
        for (Node node : mst) {
            System.out.println(node.getU() + " - " + node.getV());
        }
        return cost;
    }
}
