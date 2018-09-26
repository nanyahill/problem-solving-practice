package com.problems.epi.code.binary_trees.learning;

import com.util.TreeNode;

import java.util.NoSuchElementException;

/**
 * A Binary Tree
 * Time complexity for all operations: O(n) because there is no order to tree data
 * TODO: Have a method build binary tree from an array.
 */
public class BinaryTree {
    private TreeNode root;
    private int size = 0;

    public BinaryTree(int val) {
        root = new TreeNode(val);
        size++;
    }

    public BinaryTree() {}

    public BinaryTree(TreeNode<Integer> root, int size) {
        this.root = root;
        this.size = size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() { return size; }

    /*******************************************************
     *                 Minimum & Maximum
     *******************************************************/
    public TreeNode<Integer> min() {
        if(isEmpty()) throw new NoSuchElementException();
        TreeNode minNode = root;
        return min_Recursive(root, minNode);
    }

    private static TreeNode min_Recursive(TreeNode<Integer> root, TreeNode<Integer> minNode) {
        if(root == null) return null;
        if(root.data < minNode.data) minNode = root;
        min_Recursive(root.left, minNode);
        min_Recursive(root.right, minNode);
        return minNode;
    }

    private static TreeNode min_Iterative(TreeNode root) {
        ///TODO can be implemented using a queue or dfs tree traversal
        return null;
    }

    public TreeNode<Integer> max() {
        if(isEmpty()) throw new NoSuchElementException();
        TreeNode maxNode = root;
        return max_Recursive(root, maxNode);
    }

    private static TreeNode max_Recursive(TreeNode<Integer> root, TreeNode<Integer> maxNode) {
        if(root == null) return null;
        if(root.data > maxNode.data) maxNode = root;
        max_Recursive(root.left, maxNode);
        max_Recursive(root.right, maxNode);
        return maxNode;
    }

    private static TreeNode max_Iterative(TreeNode root) {
        ///TODO can be implemented using a queue or dfs tree traversal
        return null;
    }

    /*******************************************************
     *                    Insertion
     *******************************************************/
    public void insert(int val) {
        if(isEmpty()) root = new TreeNode(val);
        else root = insert_Recursive(root, val);
        size++;
    }

    private TreeNode insert_Recursive(TreeNode<Integer> root, int val) {
        // TODO
        return null;
    }

    private TreeNode insert_Iterative(TreeNode<Integer> root, int val) {
        // TODO
        return null;
    }

    /*******************************************************
     *                     Deletion
     *******************************************************/
    public TreeNode<Integer> delete(int val) {
        if(isEmpty()) throw new IllegalStateException();
        root = delete_Recursive(root, val);
        size--;
        return root;
    }

    private TreeNode delete_Recursive(TreeNode<Integer> root, int val) {
        // TODO
        return null;
    }

    /*******************************************************
     *                    Searching
     *         Use any of the tree traversal algorithms
     *******************************************************/
    public TreeNode<Integer> search(int val) {
        if(isEmpty()) throw new IllegalStateException();
        return search_Recursive(root, val);
    }

    private TreeNode search_Recursive(TreeNode<Integer> root, int val) {
        // TODO
        return null;
    }

    private TreeNode search_Iterative(TreeNode<Integer> root, int val) {
        // TODO
        return null;
    }
}

