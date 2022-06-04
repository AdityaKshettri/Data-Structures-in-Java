package com.aditya.project.bt.check;

import com.aditya.project.bt.Node;

import static com.aditya.project.bt.Node.initializeBinaryTree;

public class CheckIdentical {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        boolean check = func(root, root);
        System.out.println(check);
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean func(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        return node1.data == node2.data
                && func(node1.left, node2.left)
                && func(node1.right, node1.right);
    }
}
