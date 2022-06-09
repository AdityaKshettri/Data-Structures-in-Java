package com.aditya.project.binarytree.view.bfs;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class BottomView {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = func(root);
        System.out.println(res);
    }

    private static List<Integer> func(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        Map<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.node;
            int x = pair.x;
            map.put(x, node.data);
            if (node.left != null) {
                q.offer(new Pair(node.left, x - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, x + 1));
            }
        }
        res.addAll(map.values());
        return res;
    }

    private static class Pair {
        Node node;
        int x;

        public Pair(Node node, int x) {
            this.node = node;
            this.x = x;
        }
    }
}
