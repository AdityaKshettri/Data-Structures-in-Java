package com.aditya.project.binarytree.check;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CheckIdentical {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        boolean check = checkIdenticalBinaryTrees(root, root);
        System.out.println(check);
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean checkIdenticalBinaryTrees(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        boolean leftCheck = checkIdenticalBinaryTrees(node1.left, node2.left);
        boolean rightCheck = checkIdenticalBinaryTrees(node1.right, node1.right);
        return node1.data == node2.data && leftCheck && rightCheck;
    }
}
