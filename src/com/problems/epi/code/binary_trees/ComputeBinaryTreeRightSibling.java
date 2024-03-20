package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

public class ComputeBinaryTreeRightSibling {
    public static void constructRightSibling(TreeNode<Integer> root) {
        if(root == null) return;
        TreeNode<Integer> curr = root;
        while(curr != null && curr.left != null) {
            populateRightSibiling(curr);
            curr = curr.left;
        }
    }

    private static void populateRightSibiling(TreeNode<Integer> node) {
        TreeNode<Integer> iter = node;
        while(iter != null) {
            iter.left.next = iter.right;
            if(iter.next != null) iter.right.next = iter.next.left;
            iter = iter.next;
        }
    }
}
