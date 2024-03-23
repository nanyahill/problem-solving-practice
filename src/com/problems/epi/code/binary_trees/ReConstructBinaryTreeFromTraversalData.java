package com.problems.epi.code.binary_trees;

import com.util.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Key-Insight: The tree’s root always coincides with the first element in preorder traversal.
 * This must be true because in preorder traversal you always traverse the root node before its children.
 * Since the problem gives an inorder traversal (LCR) and a pre-order traversal (CLR),
 * we use the arrangment of the preorder to build the tree from top-down
 * while using the inorder traversal to know what side (left or right) of the tree to place the node.
 * Time complexity: O(n)
 * Space Complexity: O(n)
 * Note space complexity can be O(1) by using linear search but that increases the time complexity to O(n^2)
 * due to the linear search of the inorder index and the worst case of a skewed tree.
 */
public class ReConstructBinaryTreeFromTraversalData {

    public static TreeNode<Integer> buildBinaryTree(int[] inorder, int[] preorder) {
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildBinaryTreeHelper(0, 0, inorder.length - 1, preorder, inorder, inMap);
    }

    public static TreeNode<Integer> buildBinaryTreeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode<Integer> root = new TreeNode<>(preorder[preStart]);
        int inIndex = inMap.get(root.data);
        int leftSubTreeSize = inIndex - inStart;
        root.left = buildBinaryTreeHelper(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
        root.right = buildBinaryTreeHelper(preStart + leftSubTreeSize + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
        return root;
    }
}
