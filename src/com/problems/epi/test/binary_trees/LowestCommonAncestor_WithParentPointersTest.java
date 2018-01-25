package com.problems.epi.test.binary_trees;

import com.problems.epi.code.binary_trees.LowestCommonAncestor_WithParentPointers;
import com.util.TreeNode;
import org.junit.Test;

public class LowestCommonAncestor_WithParentPointersTest {

    @Test
    public void lowestCommonAncestor() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(7, root);
        root.left.left = new TreeNode<>(3, root.left);
        root.left.left.left = new TreeNode<>(12, root.left.left);

        root.left.right = new TreeNode<>(4, root.left);
        root.left.right.left = new TreeNode<>(6, root.left.right);
        root.left.right.left.left = new TreeNode<>(10, root.left.right.left);
        root.left.right.left.left.right = new TreeNode<>(11, root.left.right.left.left);

        root.right = new TreeNode<>(8, root);
        root.right.right = new TreeNode<>(9, root.right);
        root.right.right.left = new TreeNode<>(2, root.right.right);
        root.right.right.right = new TreeNode<>(1, root.right.right);

        TreeNode expected = root;
        TreeNode actual = LowestCommonAncestor_WithParentPointers.lowestCommonAncestor_BruteForce(root.right.right.right, root.left);
        assert(expected == actual);
    }
}
