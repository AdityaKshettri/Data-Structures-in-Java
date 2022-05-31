package com.aditya.project.binarytree.check;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CheckMirrorImage {

    public static void main(String[] args) {
        Node root1 = initializeBinaryTree();
        Node root2 = initializeBinaryTree();
        Node temp = root2.left;
        root2.left = root2.right;
        root2.right = temp;
        boolean check = checkMirrorImage(root1, root2);
        System.out.println(check);
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean checkMirrorImage(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        boolean leftCheck = checkMirrorImage(a.left, b.right);
        boolean rightCheck = checkMirrorImage(a.right, a.left);
        return a.data == b.data && leftCheck && rightCheck;
    }
}
