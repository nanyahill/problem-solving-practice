package com.problems.epi.code.binary_search_trees.implementation;

import com.util.TreeNode;

import java.util.NoSuchElementException;

/**
 * A Binary Search Tree
 * Time complexity for all operations: O(h)
 * where h = height of the tree.
 */
public class BinarySearchTree {
    private TreeNode root;
    private int size = 0;

    public BinarySearchTree(int val) {
        root = new TreeNode(val);
        size++;
    }

    public BinarySearchTree() {}

    public BinarySearchTree(TreeNode<Integer> root, int size) {
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
        return min_Recursive(root);
    }

    private static TreeNode<Integer> min_Recursive(TreeNode root) {
        if(root == null) return root;
        if(root.left == null) return root;
        else return min_Recursive(root.left);
    }

    private static TreeNode min_Iterative(TreeNode root) {
        if(root == null) return root;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode<Integer> max() {
        if(isEmpty()) throw new NoSuchElementException();
        return max_Recursive(root);
    }

    private static TreeNode max_Recursive(TreeNode root) {
        if(root == null) return root;
        if(root.right == null) return root;
        else return max_Recursive(root.right);
    }

    private static TreeNode max_Iterative(TreeNode root) {
        if(root == null) return root;
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }

    /*******************************************************
     *             Successor & Predecessor
     *******************************************************/
    public TreeNode<Integer> successor(int val) {
        if(isEmpty()) throw new NoSuchElementException();
        return successor_Recursive(root, val, null);
    }

    private TreeNode successor_Recursive(TreeNode<Integer> root, int val, TreeNode<Integer> succ) {
        if(root == null) return null;
        if(root.data > val) {
            // succ = root; can just pass in root
            succ = successor_Recursive(root.left, val, root);
        }
        else if(root.data < val) succ = successor_Recursive(root.right, val, succ);
        else {
            // Since the node has been found, its successor is the minimum node in its right subtree
            if(root.right != null) return min_Recursive(root.right);
            return succ;
        }
        return succ;
    }

    // Note: there is no need for a temp variable (e.g. curr)
    // because even though root is always reassigned in the loop
    // it does not affect the global root variable.
    // Clear example of Java passing by value and not by reference
    private TreeNode successor_Iterative(TreeNode<Integer> root, int val) {
        TreeNode succ = null;
        while(root != null) {
            if(root.data > val) {
                succ = root;
                root = root.left;
            }
            else root = root.right;
        }
        return succ;
    }

    public TreeNode<Integer> predecessor(int val) {
        if(isEmpty()) throw new NoSuchElementException();
        return predecessor_Recursive(root, val, null);
    }

    private TreeNode predecessor_Recursive(TreeNode<Integer> root, int val, TreeNode<Integer> pred) {
        if(root == null) return null;
        if(root.data < val) {
            // pred = root; can just pass in root
            pred = predecessor_Recursive(root.right, val, root);
        }
        else if(root.data > val) pred = predecessor_Recursive(root.left, val, pred);
        else {
            // Since the node has been found, its predecessor is the maximum node in its left subtree
            if(root.left != null) return max_Recursive(root.left);
            return pred;
        }
        return pred;
    }

    private TreeNode predecessor_Iterative(TreeNode<Integer> root, int val) {
        TreeNode pred = null;
        while(root != null) {
            if(root.data < val) {
                pred = root;
                root = root.right;
            }
            else root = root.left;
        }
        return pred;
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
        if(root == null) return new TreeNode(val);
        if(root.data > val) root.left = insert_Recursive(root.left, val);
        else if (root.data < val) root.right = insert_Recursive(root.right, val);
        else root.data = val;
        return root;
    }

    private TreeNode insert_Iterative(TreeNode<Integer> root, int val) {
        TreeNode<Integer> p = null;
        while(root != null) {
            p = root;
            if(root.data > val) root = root.left;
            else if (root.data < val) root = root.right;
            else break;
        }
        if(p.data > val) p.left = new TreeNode(val);
        else if (p.data < val) p.right = new TreeNode(val);
        else p.data = val;
        return root;
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
        if(root == null) return null;
        if(root.data > val) root.left = delete_Recursive(root.left, val);
        else if(root.data < val) root.right = delete_Recursive(root.right, val);
        else {
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;
            // Shorter way
            root.data = min_Recursive(root.right).data;
            root.right = delete_Recursive(root.right, root.data);

            // Longer way
//            TreeNode t = root;
//            root = min_Recursive(t.right);
//            root.right = delete_Recursive(t.right, root.data);
//            root.left = t.left;
        }
        return root;
    }

    /*******************************************************
     *                    Searching
     *******************************************************/
    public TreeNode<Integer> search(int val) {
        if(isEmpty()) throw new IllegalStateException();
        return search_Recursive(root, val);
    }

    private TreeNode search_Recursive(TreeNode<Integer> root, int val) {
        if(root == null) return null;
        if(root.data > val) return search_Recursive(root.left, val);
        else if(root.data < val) return search_Recursive(root.right, val);
        else return root;
    }

    private TreeNode search_Iterative(TreeNode<Integer> root, int val) {
        TreeNode<Integer> curr = root;
        while(curr != null) {
            if(curr.data > val) curr = curr.left;
            else if(curr.data < val) curr = curr.right;
            else return curr;
        }
        return curr;
    }
}
