package com.aditya.project.graph.check;

import java.util.ArrayList;
import java.util.List;

public class DirectedCycleUsingDFS {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>(n);

        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<>();
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<>();
        neighbors.add(4);
        graph.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<>();
        graph.add(neighbors);

        if (isCyclic(n, graph))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycles detected");
    }

    // TC : O(N+E)
    // SC : O(N)
    private static boolean isCyclic(int n, List<List<Integer>> graph) {
        boolean[] v = new boolean[n];
        boolean[] dfsV = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                if (checkForCycle(i, v, dfsV, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle(int curr, boolean[] v, boolean[] dfsV, List<List<Integer>> graph) {
        v[curr] = true;
        dfsV[curr] = true;
        for (Integer i : graph.get(curr)) {
            if (!v[i]) {
                if (checkForCycle(i, v, dfsV, graph)) {
                    return true;
                }
            } else if (dfsV[curr]) {
                return true;
            }
        }
        dfsV[curr] = false;
        return false;
    }
}
