package com.problems.epi.code.binary_trees.learning;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This recursively traverses a tree in three different orders
 * Time complexity: O(n)
 * Space Complexity: O(logn); in worst case (skewed tree): O(n)
 */
public class TreeTraversal_Recursive {

    public static List<Integer> listPreOrder = new ArrayList<>();
    public static List<Integer> listInOrder = new ArrayList<>();
    public static List<Integer> listPostOrder = new ArrayList<>();

    public static void preOrder(TreeNode<Integer> root) {
        if (root != null) {
            listPreOrder.add(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode<Integer> root) {
        if (root != null) {
            inOrder(root.left);
            listInOrder.add(root.data);
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode<Integer> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            listPostOrder.add(root.data);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(7);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(3);
        root.left.right.left = new TreeNode<>(6);
        root.right = new TreeNode<>(8);
        root.right.right = new TreeNode<>(9);
        root.right.right.left = new TreeNode<>(10);
        preOrder(root);
        System.out.println(listPreOrder);
        inOrder(root);
        System.out.println(listInOrder);
        postOrder(root);
        System.out.print(listPostOrder);
    }
}
