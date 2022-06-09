package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class Height {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int height = func(root);
        System.out.println(height);
    }

    // TC : O(N)
    // SC : O(N)
    private static int func(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = func(node.left);
        int rightHeight = func(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
