package com.problems.epi.code.binary_trees.learning;

import com.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * This iteratively traverses a tree in three different orders using a stack
 * Time complexity: O(n)
 * Space Complexity: O(logn); in worst case (skewed tree): O(n)
 */
public class TreeTraversal_Iterative_WithStack {

    public static List<Integer> preOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.data);
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            root = root.right;
        }
        return res;
    }

    public static List<Integer> inOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            res.add(root.data);
            root = root.right;
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.peekFirst().right;
            if (root == null) {
                TreeNode<Integer> node = stack.removeFirst();
                res.add(node.data);
                while (!stack.isEmpty() && node == stack.peekFirst().right) {
                    node = stack.removeFirst();
                    res.add(node.data);
                }
            }
        }
        return res;
    }
}
