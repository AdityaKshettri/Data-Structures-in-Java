package com.aditya.project.bt.calculation;

import com.aditya.project.bt.Node;

import static com.aditya.project.bt.Node.initializeBinaryTree;

public class MaxPathSum {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int[] maxPathSum = new int[1];
        maxPathSum[0] = Integer.MIN_VALUE;
        func(root, maxPathSum);
        System.out.println(maxPathSum[0]);
    }

    // TC : O(N)
    // SC : O(N)
    private static int func(Node node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, func(node.left, maxPathSum));
        int right = Math.max(0, func(node.right, maxPathSum));
        maxPathSum[0] = Math.max(maxPathSum[0], left + right + node.data);
        return node.data + Math.max(left, right);
    }
}
