package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalWithParent {
    // @include
    public static List<Integer> inorderTraversal(TreeNode<Integer> tree) {
        TreeNode<Integer> prev = null, curr = tree;
        List<Integer> result = new ArrayList<>();

        while (curr != null) {
            TreeNode<Integer> next;
            if (curr.parent == prev) { // Working on left subtree using DFS to find leftmost node
                // We came down to curr from prev.
                if (curr.left != null) { // Keep going left.
                    next = curr.left;
                } else { // Found leftmost node
                    result.add(curr.data);
                    // Done with left, so go right if right is not empty.
                    // Otherwise, go up.
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) { // Returning from the left subtree
                result.add(curr.data);
                // Done with left, so go right if right is not empty. Otherwise, go up.
                next = (curr.right != null) ? curr.right : curr.parent;
            } else { // Done with both children, so move up.
                next = curr.parent;
            }

            prev = curr;
            curr = next;
        }
        return result;
    }
    // @exclude

    public static void main(String[] args) {
        //      3
        //    2   5
        //  1    4 6
//        TreeNode<Integer> root = new TreeNode<>(3, null, null);
//        root.parent = null;
//        List<Integer> result = inorderTraversal(root);
//        List<Integer> goldenRes = Arrays.asList(3);
//        assert (goldenRes.equals(result));
//
//        root.left = new TreeNode<>(2, null, null);
//        root.left.parent = root;
//        root.left.left = new TreeNode<>(1, null, null);
//        root.left.left.parent = root.left;
//
//        result = inorderTraversal(root);
//        goldenRes = Arrays.asList(1, 2, 3);
//        assert (goldenRes.equals(result));
//
//        root.right = new TreeNode<>(5, null, null);
//        root.right.parent = root;
//        root.right.left = new TreeNode<>(4, null, null);
//        root.right.left.parent = root.right;
//        root.right.right = new TreeNode<>(6, null, null);
//        root.right.right.parent = root.right;
//
//        result = inorderTraversal(root);
//        goldenRes = Arrays.asList(1, 2, 3, 4, 5, 6);
//        assert (goldenRes.equals(result));
    }
}
