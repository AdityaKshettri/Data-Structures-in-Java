package com.aditya.project.binarysearchtree.check;

import com.aditya.project.binarysearchtree.Node;

import java.util.Stack;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

class Iterator {

    private final Stack<Node> stack = new Stack<>();
    boolean reverse;

    // TC : O(N)
    // SC : O(H) * 2
    public Iterator(Node root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public int next() {
        Node node = stack.pop();
        if (!reverse) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.data;
    }

    private void pushAll(Node node) {
        while (node != null) {
            stack.push(node);
            if (!reverse) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}

public class TwoSum {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int k = 6;
        System.out.println(findTwoSum(root, k));
    }

    // TC : O(N)
    // SC : O(H)
    private static boolean findTwoSum(Node root, int k) {
        if (root == null) {
            return false;
        }
        Iterator l = new Iterator(root, false);
        Iterator r = new Iterator(root, true);
        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }
}
