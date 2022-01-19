package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

/**
 * Key Insight: A height-balanced tree has the difference between any left subtree and right subtree is at most 1.
 * Pattern: Post-order tree traversal (see find LCA without parent pointers)
 */
public class HeightBalancedTree {

    /**
     * Brute Force Approach: Each node needs to be checked for the height of its left and right subtrees.
     * Based on a top-down approach
     * Time complexity: O(n^2)
     * Space Complexity: O(h) where h is the height of the tree
     */
    public static boolean isHeightBalanced_BruteForce(TreeNode root) {
        if (root == null) return true;
        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);
        int res = Math.abs(leftHeight - rightHeight);
        if (res <= 1 && isHeightBalanced_BruteForce(root.left) && isHeightBalanced_BruteForce(root.right)) return true;
        return false;
    }

    private static int computeHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(computeHeight(root.left), computeHeight(root.right)) + 1;
    }

    /**
     * Efficient Approach: An optimization is that when checking for the height of a subtree, its children which need to be checked (at a later time) are present.
     * Thus, the children can be checked for their left and right subtrees height while the parents are also being checked.
     * Traverse the tree in Post-order fashion. Also, known as DFS or bottom-up approach
     * Time complexity: O(n)
     * Space Complexity: O(h) where h is the height of the tree
     */
    public static boolean isHeightBalanced_Efficient(TreeNode root) {
        if (root == null) return true;
        return depth(root) != -1;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = depth(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = depth(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
