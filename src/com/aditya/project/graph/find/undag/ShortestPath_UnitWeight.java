package com.aditya.project.graph.find.undag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath_UnitWeight {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            graph.add(arr);
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(4);
        int src = 0;
        int dest = 5;
        Integer shortestPath = func(n, graph, src, dest);
        System.out.printf("Shortest Path from %d to %d = %d", src, dest, shortestPath);
    }

    // TC : O(N+E)
    // SC : O(N) for dist + O(N) for Queue
    private static Integer func(int n, List<List<Integer>> graph, int src, int dest) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            for (Integer i : graph.get(curr)) {
                if (dist[curr] + 1 < dist[i]) {
                    dist[i] = dist[curr] + 1;
                    q.add(i);
                }
            }
        }
        return dist[dest];
    }
}
