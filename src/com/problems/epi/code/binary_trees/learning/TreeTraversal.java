package com.problems.epi.code.binary_trees.learning;

import com.util.TreeNode;

public class TreeTraversal {

    public static void treeTraversal(TreeNode<Integer> root) {
        if(root != null) {
            //System.out.println("PreOrder: " + root.data);
            treeTraversal(root.left);
            //System.out.println("Inorder: " + root.data);
            treeTraversal(root.right);
            System.out.println("PostOrder: " + root.data);
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
        treeTraversal(root);

    }
}
