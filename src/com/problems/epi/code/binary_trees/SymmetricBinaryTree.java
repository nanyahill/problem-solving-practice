package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

import java.util.*;

/**
 * Key Insight: What is a symmetric tree: A symmetric tree is one in which if a line is drawn vertically throw the root,
 * the left subtree is a mirror image of the right subtree.
 * What is a mirror image: Any left subtree is equal to any right subtree at the same level.
 * Overall, just think of a mirror. What is the reflection for each node of the tree?
 * Note that for root, it is the same as in a mirror. Unlike left arm appearing as right arm.
 */
public class SymmetricBinaryTree {

    /**
     * Recursive: Compare each subtree recursively. Checking the condition of symmetricity:
     * 1. Their two roots have the same value.
     * 2. The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
     * Time Complexity: O(n)
     * Space Complexity: O(n)- worst case of a linear tree; call stack is O(n)
     */
    public static boolean isSymmetric_Recursive(TreeNode root) {
        return checkSubTree(root, root);
    }

    private static boolean checkSubTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left != null && right != null) {
            return (left.data == right.data) && (checkSubTree(left.left, right.right)) && (checkSubTree(left.right, right.left));
        }
        return false;
    }

    /**
     * Iterative: Since this resembles a depth order travesal (BFS), then you can use a queue, to process each level one after another.
     * Always checking if the left.val == right.val for all subtrees in the tree.
     * Note that the solution is cleaner if the queue data structure allows null insertions.
     */

    // LinkedLists allow null insertions
    public static boolean isSymmetric_Iterative_UsingLinkedList(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            // Takes care of cases- leaf(children are both null) nodes.
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.data != t2.data) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    // ArrayDeque does not allow null insertions
    public static boolean isSymmetric_Iterative_UsingDeque(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null || root.right == null) return false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollFirst();
            if (left.data != right.data) return false;

            // All these ifs because ArrayDeque does not accept null insertions. Throws NullPointer exception
            if ((left.left == null && right.right != null) || (left.left != null && right.right == null))
                return false;
            if ((left.right == null && right.left != null) || (left.right != null && right.left == null))
                return false;
            if (left.left != null) queue.offerLast(left.left);
            if (right.right != null) queue.offerLast(right.right);
            if (left.right != null) queue.offerLast(left.right);
            if (right.left != null) queue.offerLast(right.left);
        }

        return true;
    }
}
