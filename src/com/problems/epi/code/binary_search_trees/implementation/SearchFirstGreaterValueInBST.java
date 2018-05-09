package com.problems.epi.code.binary_search_trees.implementation;

import com.util.TreeNode;

public class SearchFirstGreaterValueInBST {

    public static TreeNode<Integer> searchFirstGreaterValueInBST_Iterative(TreeNode<Integer> root, int val) {
        if(root == null) return null;
        TreeNode<Integer> succ = null;
        while(root != null) {
            if(root.data > val) {
                succ = root;
                root = root.left;
            }
            else root = root.right;
        }
        return succ;
    }

    public static TreeNode<Integer> searchFirstGreaterValueInBST_Recursive(TreeNode<Integer> root, int val) {
        if(root == null) return null;
        return searchFirstGreaterValueInBST_Recursive(root, val, null);
    }

    private static TreeNode<Integer> searchFirstGreaterValueInBST_Recursive(TreeNode<Integer> root, int val, TreeNode<Integer> succ) {
        if(root == null) return null;
        if(root.data > val) succ = searchFirstGreaterValueInBST_Recursive(root.left, val, root);
        else if(root.data < val) succ = searchFirstGreaterValueInBST_Recursive(root.right, val, succ);
        else {
            if(root.right != null) succ = getMinimumValueInBST(root.right);
            else return succ;
        }
        return succ;
    }

    private static TreeNode<Integer> getMinimumValueInBST(TreeNode<Integer> root) {
        if(root.left == null) return root;
        return getMinimumValueInBST(root.left);
    }
}
