package com.aditya.project.bt.view;

import com.aditya.project.bt.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import static com.aditya.project.bt.Node.initializeBinaryTree;

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
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
