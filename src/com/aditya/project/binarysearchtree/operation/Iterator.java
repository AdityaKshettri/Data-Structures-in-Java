package com.aditya.project.binarysearchtree.operation;

import com.aditya.project.binarysearchtree.Node;

import java.util.Stack;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Iterator {

    private final Stack<Node> stack = new Stack<>();

    // TC : O(1)
    // SC : O(H)
    public Iterator(Node root) {
        pushAll(root);
    }

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        Iterator iterator = new Iterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node node = stack.pop();
        pushAll(node.right);
        return node.data;
    }

    private void pushAll(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
