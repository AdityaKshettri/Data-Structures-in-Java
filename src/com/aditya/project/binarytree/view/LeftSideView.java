package com.aditya.project.binarytree.view;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class LeftSideView {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        leftSideView(root, 0, res);
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
    private static void leftSideView(Node node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.add(node.data);
        }
        leftSideView(node.left, level + 1, res);
        leftSideView(node.right, level + 1, res);
    }
}
