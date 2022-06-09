package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentSubtreeSum {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(-4);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        func(root, new HashMap<>(), map);
        System.out.println(map.lastEntry().getValue());
    }

    // Time Complexity: O(N)
    // Auxiliary Space: O(N)
    private static int func(Node node, Map<Integer, Integer> freq, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return 0;
        }
        int left = func(node.left, freq, map);
        int right = func(node.right, freq, map);
        int sum = node.data + left + right;
        mapUtil(sum, freq, map);
        return sum;
    }

    private static void mapUtil(int sum, Map<Integer, Integer> freq, Map<Integer, List<Integer>> map) {
        if (!freq.containsKey(sum)) {
            freq.put(sum, 1);
        } else {
            freq.put(sum, freq.get(sum) + 1);
        }
        if (!map.containsKey(freq.get(sum))) {
            map.put(freq.get(sum), new ArrayList<>());
        }
        map.get(freq.get(sum)).add(sum);
    }
}
