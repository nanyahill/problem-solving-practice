package com.problems.epi.code.binary_search_trees.variants;

import com.util.TreeNode;

public class Question14_2 {
    public static TreeNode<Integer> predecessorDuplicateInBST(TreeNode<Integer> root, int val) {
        while(root != null) {
            if(root.data < val) root = root.right;
            else if(root.data > val) root = root.left;
            else {
                TreeNode result = checkLeftSubTree(root.left, val);
                return result != null ? result : root;
            }
        }
        return root;
    }

    private static TreeNode checkLeftSubTree(TreeNode<Integer> node, int val) {
        TreeNode result = null;
        while(node != null && node.data == val) {
            result = node;
            node = node.left;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(108, "A");
        root.left = new TreeNode<>(108, "B");
        root.left.left = new TreeNode<>(-10, "C");
        root.left.left.left = new TreeNode<>(-14, "D");
        root.left.left.right = new TreeNode<>(2, "E");
        root.left.right = new TreeNode<>(108, "F");
        root.right = new TreeNode<>(285, "G");
        root.right.left = new TreeNode<>(243, "H");
        root.right.right = new TreeNode<>(285, "I");
        root.right.right.right = new TreeNode<>(401, "J");
        System.out.println(predecessorDuplicateInBST(root, 143).name);




    }
}
