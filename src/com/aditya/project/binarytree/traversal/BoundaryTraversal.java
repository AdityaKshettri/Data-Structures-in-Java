package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class BoundaryTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = func(root);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static List<Integer> func(Node root) {
        List<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) {
            res.add(root.data);
        }
        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);
        return res;
    }

    private static boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    private static void addLeftBoundary(Node node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.data);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    private static void addRightBoundary(Node node, List<Integer> res) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.data);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}
