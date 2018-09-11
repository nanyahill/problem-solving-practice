package com.problems.ctci.chapter4;

import com.util.TreeNode;

public class Question4_6 {
    public static TreeNode inOrderSuccessor(TreeNode node) {
        TreeNode succ = null;
        if(node == null) return succ;
        if(node.right != null) {
            succ = findMin(node.right);
        }
        else {
            TreeNode parent = node.parent;
            while(parent != null && node != parent.left) {
                node = parent;
                parent = node.parent;
            }
            succ = parent;
        }
        return succ;
    }

    private static TreeNode findMin(TreeNode node) {
        if(node.left == null) return node;
        return findMin(node.left);
    }
}
