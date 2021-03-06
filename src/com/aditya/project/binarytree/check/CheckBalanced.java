package com.aditya.project.binarytree.check;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CheckBalanced {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int check = func(root);
        System.out.println(check != -1 ? "Balanced" : "Not Balanced");
    }

    // TC : O(N)
    // SC : O(N)
    private static int func(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = func(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = func(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
