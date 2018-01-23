package com.util;

/**
 * A class used to solve Binary Tree related problems
 */
public class TreeNode<T> {

    public T data;
    public TreeNode<T> left = null;
    public TreeNode<T> right = null;

    public TreeNode (T data) {
        this.data = data;
    }

    public TreeNode (T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
