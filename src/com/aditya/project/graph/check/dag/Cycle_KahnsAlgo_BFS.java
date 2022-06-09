package com.aditya.project.graph.check.dag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cycle_KahnsAlgo_BFS {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            graph.add(arr);
        }
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        if (isCyclic(n, graph)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycles detected");
        }
    }

    // Kahn's Algo : If Topological Sort cannot be generated, then it is Cyclic
    // TC : O(N+E)
    // SC : O(N) for InDegree + O(N) for Queue
    private static boolean isCyclic(int n, List<List<Integer>> graph) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer it : graph.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int c = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            c++;
            for (Integer i : graph.get(curr)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return c == n;
    }
}
