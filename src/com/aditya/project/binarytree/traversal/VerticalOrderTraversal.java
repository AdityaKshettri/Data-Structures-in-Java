package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<List<Integer>> res = func(root);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static List<List<Integer>> func(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        for (Map<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.add(nodes.poll());
                }
            }
            res.add(list);
        }
        return res;
    }

    static class Tuple {
        Node node;
        int x;
        int y;

        public Tuple(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
}
