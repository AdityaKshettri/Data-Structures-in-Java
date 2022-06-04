package com.aditya.project.bt.check;

import com.aditya.project.bt.Node;

public class CheckMirrorImage {

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        boolean check = func(root1, root2);
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
