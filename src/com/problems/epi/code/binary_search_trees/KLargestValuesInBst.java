package com.problems.epi.code.binary_search_trees;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KLargestValuesInBst {
    ///@EpiTest(testfile = "k_largest_values_in_bst.tsv")
    public static List<Integer> findKLargestInBst(TreeNode<Integer> tree, int k) {
        List<Integer> kLargestElements = new ArrayList<>();
        findKLargestInBstHelper(tree, k, kLargestElements);
        return kLargestElements;
    }

    private static void findKLargestInBstHelper(TreeNode<Integer> tree, int k,
                                                List<Integer> kLargestElements) {
        if(tree == null) return;
        // Perform reverse inorder traversal.
        if (tree != null && kLargestElements.size() < k) {
            findKLargestInBstHelper(tree.right, k, kLargestElements);
            kLargestElements.add(tree.data);
            if (kLargestElements.size() < k) {
                kLargestElements.add(tree.data);
                findKLargestInBstHelper(tree.left, k, kLargestElements);
            }
        }
    }

    public static List<Integer> findKSmallestInBst(TreeNode<Integer> tree, int k) {
        List<Integer> kSmallestElements = new ArrayList<>();
        findKSmallestInBstHelper(tree, k, kSmallestElements);
        return kSmallestElements;
    }

    private static void findKSmallestInBstHelper(TreeNode<Integer> tree, int k,
                                                List<Integer> kSmallestElements) {
        if(tree == null) return;
        // Perform reverse inorder traversal.
        if (tree != null && kSmallestElements.size() < k) {
            findKSmallestInBstHelper(tree.left, k, kSmallestElements);
            if (kSmallestElements.size() < k) {
                kSmallestElements.add(tree.data);
                findKSmallestInBstHelper(tree.right, k, kSmallestElements);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(1);
        root.left.left.right = new TreeNode<>(2);
        //root.left.left.left = new TreeNode<>(-1);

        root.left.right = new TreeNode<>(4);

        root.right = new TreeNode<>(8);
        root.right.right = new TreeNode<>(12);
        root.right.right.left = new TreeNode<>(10);
        root.right.right.left.right = new TreeNode<>(11);
        root.right.right.left.left = new TreeNode<>(9);

        for(Integer val : findKSmallestInBst(root, 3)) {
            System.out.print(val + ", ");
        }
    }
}
