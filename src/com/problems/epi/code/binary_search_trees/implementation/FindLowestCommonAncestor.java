package com.problems.epi.code.binary_search_trees.implementation;

import com.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindLowestCommonAncestor {

    // LCA in BST Iterative method
    // Time Complexity: O(h), Space Complexity: O(1)
    public static TreeNode findLCAInBST_Iterative(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == null || q == null) return null;
        TreeNode lca = null;
        while (root != null) {
                if (root.data > Math.max(p.data, q.data)) root = root.left;
            else if (root.data < Math.min(p.data, q.data)) root = root.right;
            else {
                lca = root;
                break;
            }
        }
        return lca;
    }

    // LCA in BST Recursive method
    // Time Complexity: O(h), Space Complexity: O(1)
    public static TreeNode findLCAInBST_Recursive(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == null || q == null) return null;
        if (root.data > Math.max(p.data, q.data)) return findLCAInBST_Recursive(root.left, p, q);
        else if (root.data < Math.min(p.data, q.data)) return findLCAInBST_Recursive(root.right, p, q);
        else return root;
    }

    // LCA in Binary Tree Top-Down Approach
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public static TreeNode findLCAInBT_TopDown(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        int countOfMatches = countMatches(root.left, p, q);
        if (countOfMatches == 2) return findLCAInBT_TopDown(root.left, p, q);
        else if (countOfMatches == 1) return root;
        else return findLCAInBT_TopDown(root.right, p, q); // countMatches is 0
    }

    private static int countMatches(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return 0;
        int matches = countMatches(root.left, p, q) + countMatches(root.right, p, q);
        if (root == p || root == q) return 1 + matches;
        else return matches;
    }

    // LCA in Binary Tree Bottom-Up Approach
    // Time Complexity: O(n), Space Complexity: O(1)
    public static TreeNode findLCAInBT_BottomUp(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if(root == p || root == q) return root; // don't forget this line !
        TreeNode left = findLCAInBT_BottomUp(root.left, p, q);
        TreeNode right = findLCAInBT_BottomUp(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // LCA in Binary Tree with parent pointers extra space
    // Time Complexity: O(h), Space Complexity: O(h)
    public static TreeNode findLCAInBT_ParentPointers_ExtraSpace(TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        Set<TreeNode> set = new HashSet<>();
        while (p != null || q != null) {
            if (p != null) {
                if(!set.add(p)) return p;
                p = p.parent;
            }
            if (q != null) {
                if(!set.add(q)) return q;
                q = q.parent;
            }
        }
        return null;
    }

    // LCA in Binary Tree with parent pointers without extra space
    // Time Complexity: O(logn), Space Complexity: O(1)
    public static TreeNode findLCAInBT_ParentPointers_WithoutSpace(TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        int depth_p = getDepth(p);
        int depth_q = getDepth(q);
        int diff = Math.abs(depth_p - depth_q);
        // Instead of having two if statements to check depth,
        // you can pick a node that would always be the deeper one
        // The nodes can be swapped if otherwise
        if (depth_p > depth_q) {
            while (diff > 0) {
                p = p.parent;
                diff--;
            }
        }
        if (depth_p < depth_q) {
            while (diff > 0) {
                q = q.parent;
                diff--;
            }
        }
        while (p != null && q != null) {
            if (p == q) return p;
            p = p.parent;
            q = q.parent;
        }
        return null;
    }

    private static int getDepth(TreeNode n) {
        int depth = 0;
        while (n != null) {
            depth++;
            n = n.parent;
        }
        return depth;
    }
}
