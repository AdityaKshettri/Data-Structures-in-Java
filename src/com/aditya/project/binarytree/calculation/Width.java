package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class Width {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int width = func(root);
        System.out.println(width);
    }

    // TC : O(N)
    // SC : O(N)
    private static int func(Node root) {
        if (root == null) {
            return 0;
        }
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().n;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int curr = Objects.requireNonNull(queue.peek()).n - min;
                Node node = queue.peek().node;
                queue.poll();
                if (i == 0) {
                    first = curr;
                }
                if (i == size - 1) {
                    last = curr;
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * curr + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * curr + 2));
                }
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }

    private static class Pair {
        Node node;
        int n;

        Pair(Node node, int n) {
            this.node = node;
            this.n = n;
        }
    }
}
