package com.problems.more_epi_related_practice.code.binary_trees;

import com.util.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode<Integer> root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
