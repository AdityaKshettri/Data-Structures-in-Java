package com.aditya.project.binarytree;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int height = findHeightOfBinaryTree(root);
        System.out.println(height);
    }

    // TC : O(N)
    // SC : O(N)
    private static int findHeightOfBinaryTree(Node node) {
        if (node == null) {
            return 0;
        }
        int left = findHeightOfBinaryTree(node.left);
        int right = findHeightOfBinaryTree(node.right);
        return 1 + Math.max(left, right);
    }
}
