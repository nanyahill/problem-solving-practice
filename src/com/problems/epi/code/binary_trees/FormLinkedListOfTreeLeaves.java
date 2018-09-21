package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FormLinkedListOfTreeLeaves {

    public static List<TreeNode<Integer>> createListOfLeaves(TreeNode<Integer> root) {
        if(root == null) return Collections.emptyList();
        List<TreeNode<Integer>> result = new LinkedList<>();
        getLeavesNodesInBinaryTree(root, result);
        return result;
    }

    private static TreeNode getLeavesNodesInBinaryTree(TreeNode root, List<TreeNode<Integer>> result) {
        if(root == null) return null;
        TreeNode left = getLeavesNodesInBinaryTree(root.left, result);
        TreeNode right = getLeavesNodesInBinaryTree(root.right, result);
        if(left == null && right == null) result.add(root);
        return root;
    }
}