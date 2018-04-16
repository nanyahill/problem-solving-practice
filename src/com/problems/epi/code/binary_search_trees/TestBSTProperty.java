package com.problems.epi.code.binary_search_trees;

import com.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Key Insight:
 - BST property is a global property, hence any binary tree can have this property, i.e. left <= curr < right
 - However, more precisely defined-
    - All left nodes of a BST is less than the max seen so far AND greater than or equal to the min seen so far, i.e. min < left < max
    - All right nodes of a BST is greater than the min seen so far AND less than the max seen so far, i.e. min < right < max.
    - Overall, each node value in the tree is within a range of min and max that is updated as the tree is traversed.
 Good Strategy: Draw out a sample BST and try to determine the min and max values for each node.
 Note: Use a MIN_VALUE and MAX_VALUE for starting ranges. Use long datatype to accommodate for wider range of integer values.
 */
public class TestBSTProperty {

    // Recursive method
    // Time: O(n), Space: O(logn) call stack
    // Note: long is used because it is possible that a node can have value = Integer.MAX_VALUE
    public static boolean testBST(TreeNode<Integer> root) {
        if (root == null) return true;
        return testBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean testBST(TreeNode<Integer> root, long min, long max) {
        if (root == null) return true;
        if (root.data > max || root.data < min) return false;
        return testBST(root.left, min, root.data) && testBST(root.right, root.data, max);
    }

    // Iterative method uses level-order traversal (BFS)
    // Time: O(n), Space: O(n)
    // Another method is to use a stack same idea as recursion
    public static boolean testBST_Alternative(TreeNode<Integer> root) {
        if (root == null) return true;
        Deque<QueueEntry> queue = new ArrayDeque<>();
        queue.add(new QueueEntry(root, Long.MIN_VALUE, Long.MAX_VALUE));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                QueueEntry entry = queue.removeFirst();
                TreeNode<Integer> node = entry.node;
                if (node.data >= entry.max || node.data <= entry.min) return false;
                if (node.left != null) queue.add(new QueueEntry(node.left, entry.min, node.data));
                if (node.right != null) queue.add(new QueueEntry(node.right, node.data, entry.max));
            }
        }
        return true;
    }

    static class QueueEntry {
        TreeNode<Integer> node;
        long min;
        long max;

        public QueueEntry(TreeNode<Integer> node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}
