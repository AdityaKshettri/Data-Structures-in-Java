package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class Diameter {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int[] diameter = new int[1];
        findDiameterOfBinaryTree(root, diameter);
        System.out.println(diameter[0]);
    }

    // TC : O(N)
    // SC : O(N)
    private static int findDiameterOfBinaryTree(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = findDiameterOfBinaryTree(node.left, diameter);
        int rightHeight = findDiameterOfBinaryTree(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
