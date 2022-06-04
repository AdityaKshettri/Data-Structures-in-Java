package com.aditya.project.bt.check;

import com.aditya.project.bt.Node;

public class CheckSymmetric {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        boolean check = func(root, root);
        System.out.println(check);
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean func(Node a, Node b) {
        if (a == null || b == null) {
            return a == b;
        }
        return a.data == b.data
                && func(a.left, b.right)
                && func(a.right, b.left);
    }
}
