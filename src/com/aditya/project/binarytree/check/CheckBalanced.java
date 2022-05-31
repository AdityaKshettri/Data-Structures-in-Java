package com.aditya.project.binarytree.check;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CheckBalanced {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int check = checkBalancedBinaryTree(root);
        System.out.println(check != -1 ? "Balanced" : "Not Balanced");
    }

    // TC : O(N)
    // SC : O(N)
    private static int checkBalancedBinaryTree(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkBalancedBinaryTree(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkBalancedBinaryTree(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
