package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

import java.util.List;

public class ComputeBinaryTreeWithPreOrderWithNull {
    public static int subTreeIdxPreOrder;
    public static int subTreeIdxPostOrder;

    public static TreeNode<Integer>
    reconstructPreorder(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) return null;
        subTreeIdxPostOrder = nums.size() - 1;
        //subTreeIdxPreOrder = 0;
        return constructBinaryTreeFromPostOrderTraversal(nums);
        //return constructBinaryTreeFromPreOrderTraversal(nums);
    }

    public static TreeNode<Integer> constructBinaryTreeFromPreOrderTraversal(List<Integer> nums) {
        Integer subTreeKey = nums.get(subTreeIdxPreOrder);
        subTreeIdxPreOrder++;
        if (subTreeKey == null) return null;
        TreeNode<Integer> root = new TreeNode<>(subTreeKey);
        root.left = constructBinaryTreeFromPreOrderTraversal(nums);
        root.right = constructBinaryTreeFromPreOrderTraversal(nums);
        return root;
    }

    public static TreeNode<Integer> constructBinaryTreeFromPostOrderTraversal(List<Integer> nums) {
        Integer subTreeKey = nums.get(subTreeIdxPostOrder);
        subTreeIdxPostOrder--;
        if (subTreeKey == null) return null;
        TreeNode<Integer> root = new TreeNode<>(subTreeKey);
        root.right = constructBinaryTreeFromPostOrderTraversal(nums);
        root.left = constructBinaryTreeFromPostOrderTraversal(nums);
        return root;
    }
}
