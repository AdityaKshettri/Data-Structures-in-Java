package com.aditya.project.graph.traversal.dag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort_BFS {

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
        List<Integer> topologicalSort = topologicalSort(n, graph);
        System.out.println(topologicalSort);
    }

    // TC : O(N+E)
    // SC : O(N) for InDegree + O(N) for Queue
    private static List<Integer> topologicalSort(int n, List<List<Integer>> graph) {
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
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            res.add(curr);
            for (Integer i : graph.get(curr)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return res;
    }
}
