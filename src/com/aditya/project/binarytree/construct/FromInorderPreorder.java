package com.aditya.project.binarytree.construct;

import com.aditya.project.binarytree.Node;

import java.util.HashMap;
import java.util.Map;

public class FromInorderPreorder {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preOrder = {3, 9, 20, 15, 7};
        Node node = func(inorder, preOrder);
        System.out.println(node.data);
    }

    private static Node func(int[] inorder, int[] preorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        int m = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return func(inorder, 0, n - 1, preorder, 0, m - 1, map);
    }

    private static Node func(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        Node root = new Node(preorder[preStart]);
        int index = map.get(root.data);
        int numsLeft = index - inStart;
        root.left = func(inorder, inStart, index - 1, preorder, preStart + 1, preStart + numsLeft, map);
        root.right = func(inorder, index + 1, inEnd, preorder, preStart + numsLeft + 1, preEnd, map);
        return root;
    }
}
