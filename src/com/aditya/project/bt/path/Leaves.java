package com.aditya.project.bt.path;

import com.aditya.project.bt.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.bt.Node.initializeBinaryTree;

public class Leaves {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        func(root, res);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static void func(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(node.data);
        }
        func(node.left, res);
        func(node.right, res);
    }
}
