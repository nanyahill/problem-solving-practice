package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains how to find the LCA in Binary Trees for the following cases:
 *      - Without Parent Pointers (top down vs bottom up)
 *      - With Parent Pointers (with extra space vs without extra space)
 * Note this class was not exactly a problem in EPI. The class consists of two problems in EPI (with/without parents)
 * Pattern: Post-order tree traversal (see isTreeHeightBalanced)
 *
 * Key Ideas:
 * In general, LCA problems boils down to finding the location of n1 and n2.
 * There are three cases that need to be considered
 *      - Either one of the given nodes is found- return the given node found (i.e. root == p || root == q)
 *      - Both of the nodes are found- return the root node (i.e left != null && right != null)
 *      - No nodes are found- return null (both left and right are null)
 */
public class LowestCommonAncestorInBinaryTree {

    private static boolean pFound;
    private static boolean qFound;
    /** LCA in Binary Tree Top-Down Approach
     * Assumes nodes exist in the tree
     *  Note: Does not pass EPI test case where the p and q point to the same node
     *  Result is the root but EPI expects it to be the node itself
     *  Example case: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]	16	16	(result:16)
     * Time Complexity: O(n^2), Space Complexity: O(1)
    */
    public static TreeNode lowestCommonAncestor_TopDown(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return root;
        int countOfMatches = countMatches(root.left, p, q);
        if (countOfMatches == 2) return lowestCommonAncestor_TopDown(root.left, p, q);
        else if (countOfMatches == 1) return root;
        else return lowestCommonAncestor_TopDown(root.right, p, q); // countMatches is 0
    }

    private static int countMatches(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return 0;
        int matches = countMatches(root.left, p, q) + countMatches(root.right, p, q);
        if (root == p || root == q) return 1 + matches;
        else return matches;
    }

    /**
     * LCA in Binary Tree Bottom-Up Approach
     * When the nodes exist in the tree.
     * Time Complexity: O(n), Space Complexity: O(h)
     * Similar to leetcode #236
     *
     *  * Key Ideas:
     *  * In general, LCA problems boils down to finding the location of n1 and n2.
     *  * There are three cases that need to be considered
     *  *      - Either one of the given nodes is found- return the given node found (i.e. root == p || root == q)
     *  *      - Both of the nodes are found- return the root node (i.e left != null && right != null)
     *  *      - No nodes are found- return null (both left and right are null)
     *  */
    public static TreeNode lowestCommonAncestor_BottomUp(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if(root == p || root == q) return root; // don't forget this line ! // p or q could be an ancestor of itself
        TreeNode left = lowestCommonAncestor_BottomUp(root.left, p, q);
        TreeNode right = lowestCommonAncestor_BottomUp(root.right, p, q);
        if (left != null && right != null) return root;
        return right != null ? right : left;
    }

    /**
     * When the nodes may/may not exist in the tree
     * Similar to Leetcode #1644 (if wither p or q is not found, return null)
     */
    public static TreeNode lowestCommonAncestor_MayExist_BottomUp(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        Result result = lowestCommonAncestor_MayExist_BottomUpUtil(root, p, q);
        return result.ancestor;
    }

    private static Result lowestCommonAncestor_MayExist_BottomUpUtil(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return new Result(0, null);
        Result leftResult = lowestCommonAncestor_MayExist_BottomUpUtil(root.left, p, q);
        if(leftResult.count == 2) return leftResult;
        Result rightResult = lowestCommonAncestor_MayExist_BottomUpUtil(root.right, p, q);
        if(rightResult.count == 2) return rightResult;
        int count = leftResult.count + rightResult.count + (root == p ? 1 : 0) + (root == q ? 1 : 0);
        return new Result(count, count == 2 ? root : null);
    }

    public static class Result {
        int count; // how many of two nodes were found in subtree
        TreeNode ancestor; // their LCA, if both nodes were present.
        public Result(int count, TreeNode ancestor) {
            this.count = count;
            this.ancestor = ancestor;
        }
    }

    /**
     * When the nodes may/may not exist in the tree
     * Does not use any extra object only two boolean variables
     * Similar to Leetcode #1644 (if either p or q is not found, return null)
     */
    public static TreeNode lowestCommonAncestor_MayExist_BottomUp2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        TreeNode result = lowestCommonAncestor_MayExist_BottomUpUtil2(root, p, q);
        return pFound && qFound ? result : null;
    }

    private static TreeNode lowestCommonAncestor_MayExist_BottomUpUtil2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode leftResult = lowestCommonAncestor_MayExist_BottomUpUtil2(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor_MayExist_BottomUpUtil2(root.right, p, q);
        if(root == p) {
            pFound = true;
            return root;
        }
        if(root == q) {
            qFound = true;
            return root;
        }
        if(leftResult != null && rightResult != null) return root;
        return rightResult == null ? leftResult : rightResult;
    }
}
