package com.aditya.project.graph.check;

import java.util.ArrayList;
import java.util.List;

public class CycleUsingDFS {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(2).add(3);
        graph.get(1).add(3);
        graph.get(2).add(4);
        if (isCyclic(n, graph))
            System.out.println("Cyclic");
        else
            System.out.println("Not Cyclic");
    }

    // TC : O(N+E)
    // SC : O(N)
    private static boolean isCyclic(int n, List<List<Integer>> graph) {
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                if (checkForCycle(i, -1, v, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle(int curr, int prev, boolean[] v, List<List<Integer>> graph) {
        v[curr] = true;
        for (Integer i : graph.get(curr)) {
            if (!v[i]) {
                if (checkForCycle(i, curr, v, graph)) {
                    return true;
                }
            } else if (i != prev) {
                return true;
            }
        }
        return false;
    }
}
