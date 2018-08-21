package com.problems.epi.code.binary_search_trees;

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
        if(root.data > val) {
            TreeNode<Integer> succ = searchFirstGreaterValueInBST_Recursive(root.left, val);
            if(succ == null) return root;
            else return succ;
        }
        else return searchFirstGreaterValueInBST_Recursive(root.right, val);
    }

    private static TreeNode<Integer> getMinimumValueInBST(TreeNode<Integer> root) {
        if(root.left == null) return root;
        return getMinimumValueInBST(root.left);
    }
}
