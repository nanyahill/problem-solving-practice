package com.problems.epi.test.binary_trees;

import com.problems.epi.code.binary_trees.HeightBalancedTree;
import com.util.TreeNode;
import org.junit.Test;

public class HeightBalancedTreeTest {

    @Test
    public void isHeightBalancedTest() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(7);
        root.left.left = new TreeNode<>(3);
        root.left.left.left = new TreeNode<>(12);

        root.left.right = new TreeNode<>(4);
        root.left.right.left = new TreeNode<>(6);
        root.left.right.left.left = new TreeNode<>(10);
        root.left.right.left.left.right = new TreeNode<>(11);

        root.right = new TreeNode<>(8);
        root.right.right = new TreeNode<>(9);
        root.right.right.left = new TreeNode<>(2);
        root.right.right.right = new TreeNode<>(1);

        boolean expected = false;
        assert(expected == HeightBalancedTree.isHeightBalanced_Efficient(root));
    }
}
