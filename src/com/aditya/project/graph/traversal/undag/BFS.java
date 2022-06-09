package com.aditya.project.graph.traversal.undag;

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
        List<Integer> res = func(n, graph);
        System.out.println(res);
    }

    // TC : O(N+E)
    // SC : O(N)
    private static List<Integer> func(int n, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n];
        q.add(0);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer node = q.poll();
            res.add(node);
            v[node] = true;
            for (Integer i : graph.get(node)) {
                if (!v[i]) {
                    q.add(i);
                }
            }
        }
        return res;
    }
}
