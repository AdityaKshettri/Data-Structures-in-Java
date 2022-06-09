package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CountNodesForCompleteBT {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int countNodes = func(root);
        System.out.println(countNodes);
    }

    // TC : O((log N)^2)
    // SC : O(log N)
    private static int func(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        } else {
            return 1 + func(root.left) + func(root.right);
        }
    }

    private static int getLeftHeight(Node root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private static int getRightHeight(Node root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
