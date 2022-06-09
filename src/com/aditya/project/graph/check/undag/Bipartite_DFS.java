package com.aditya.project.graph.check.undag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bipartite_DFS {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(1).add(4);
        graph.get(4).add(1);
        graph.get(1).add(5);
        graph.get(5).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(3).add(5);
        graph.get(5).add(3);
        if (isBipartite(n, graph))
            System.out.println("Bipartite");
        else
            System.out.println("Not Bipartite");
    }

    // TC : O(N+E)
    // SC : O(N)
    private static boolean isBipartite(int n, List<List<Integer>> graph) {
        int[] colour = new int[n];
        Arrays.fill(colour, -1);
        for (int i = 0; i < n; i++) {
            if (colour[i] == -1) {
                if (!checkForBipartite(i, colour, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkForBipartite(int curr, int[] colour, List<List<Integer>> graph) {
        if (colour[curr] == -1) {
            colour[curr] = 1;
        }
        for (Integer i : graph.get(curr)) {
            if (colour[i] == -1) {
                colour[i] = 1 - colour[curr];
                if (!checkForBipartite(i, colour, graph)) {
                    return false;
                }
            } else if (colour[i] == colour[curr]) {
                return false;
            }
        }
        return true;
    }
}
