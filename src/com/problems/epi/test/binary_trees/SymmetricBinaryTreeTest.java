package com.problems.epi.test.binary_trees;

import com.problems.epi.code.binary_trees.SymmetricBinaryTree;
import com.util.TreeNode;
import org.junit.Test;

public class SymmetricBinaryTreeTest {

    @Test
    public void isSymmetricTest() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(7);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);

//        root.left.left.left = new TreeNode<>(12);
//        root.left.right.left = new TreeNode<>(6);
//        root.left.right.left.left = new TreeNode<>(10);
//        root.left.right.left.left.right = new TreeNode<>(11);

        root.right = new TreeNode<>(7);
        root.right.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(4); // change the heap value of this node to test for false symmetricity

        boolean expected = true;
        boolean actual = SymmetricBinaryTree.isSymmetric_Recursive(root);
        assert (expected == actual);
    }
}
