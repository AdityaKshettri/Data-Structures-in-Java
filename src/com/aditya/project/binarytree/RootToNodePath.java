package com.aditya.project.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int target = 7;
        System.out.println("Target : " + target);
        List<Integer> res = new ArrayList<>();
        rootToNodePath(root, target, res);
        System.out.println(res);
    }

    private static Node initializeBinaryTree() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
        left = new Node(4);
        right = new Node(5);
        root.left.left = left;
        root.left.right = right;
        left = new Node(6);
        right = new Node(7);
        root.right.left = left;
        root.right.right = right;
        return root;
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean rootToNodePath(Node node, int target, List<Integer> res) {
        if (node == null) {
            return false;
        }
        res.add(node.data);
        if (node.data == target) {
            return true;
        }
        if (rootToNodePath(node.left, target, res) || rootToNodePath(node.right, target, res)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }
}
