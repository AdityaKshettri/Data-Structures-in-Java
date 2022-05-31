package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<List<Integer>> res = levelOrderTraversal(root);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(H)
    private static List<List<Integer>> levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= size; i++) {
                if (Objects.requireNonNull(queue.peek()).left != null) {
                    queue.offer(queue.peek().left);
                }
                if (Objects.requireNonNull(queue.peek()).right != null) {
                    queue.offer(queue.peek().right);
                }
                list.add(Objects.requireNonNull(queue.poll()).data);
            }
            res.add(list);
        }
        return res;
    }
}
