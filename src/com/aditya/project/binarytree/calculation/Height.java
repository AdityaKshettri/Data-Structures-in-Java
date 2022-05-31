package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class Height {

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
        int leftHeight = findHeightOfBinaryTree(node.left);
        int rightHeight = findHeightOfBinaryTree(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
