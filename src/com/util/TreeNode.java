package com.util;

/**
 * A class used to solve Binary Tree related problems
 */
public class TreeNode<T> {

    public String name;
    public T data;
    public TreeNode<T> parent = null;
    public TreeNode<T> left = null;
    public TreeNode<T> right = null;
    public TreeNode<T> next = null;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T data, TreeNode<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public TreeNode(T data, String name) {
        this.data = data;
        this.name = name;
    }
}
