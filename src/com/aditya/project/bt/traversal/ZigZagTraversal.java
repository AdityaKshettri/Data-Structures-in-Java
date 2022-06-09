package com.aditya.project.bt.traversal;

import com.aditya.project.bt.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.aditya.project.bt.Node.initializeBinaryTree;

public class ZigZagTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<List<Integer>> res = func(root);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(H)
    private static List<List<Integer>> func(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n && !queue.isEmpty(); i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (leftToRight) {
                    list.add(node.data);
                } else {
                    list.add(0, node.data);
                }
            }
            leftToRight = !leftToRight;
            res.add(list);
        }
        return res;
    }
}
