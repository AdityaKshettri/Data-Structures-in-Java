package com.aditya.project.graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.aditya.project.graph.Graph.initializeGraph;

// Time Complexity : O(N+E)
// Space Complexity : O(N+E) + O(N) + O(N)
public class BFS {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = initializeGraph();
        List<Integer> bfs = bfsOfGraph(n, graph);
        System.out.println(bfs);
    }

    // TC : O(N+E)
    // SC : O(N)
    private static List<Integer> bfsOfGraph(int n, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] v = new boolean[n];
        queue.add(0);
        v[0] = true;
        List<Integer> bfs = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            bfs.add(curr);
            for (Integer i : graph.get(curr)) {
                if (!v[i]) {
                    queue.add(i);
                    v[i] = true;
                }
            }
        }
        return bfs;
    }
}
