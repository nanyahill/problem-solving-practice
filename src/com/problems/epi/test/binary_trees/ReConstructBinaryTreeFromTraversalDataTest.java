package com.problems.epi.test.binary_trees;

import com.problems.epi.code.binary_trees.ReConstructBinaryTreeFromTraversalData;
import com.problems.epi.code.binary_trees.learning.TreeTraversal_Recursive;
import com.util.TreeNode;
import org.junit.Test;

public class ReConstructBinaryTreeFromTraversalDataTest {

    @Test
    public void buildBinaryTreeTest() {
        int[] inorder = {1, 2, 3};
        int[] preorder = {1, 2, 3};
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(3);

        TreeNode actual = ReConstructBinaryTreeFromTraversalData.buildBinaryTree(inorder, preorder);
        assert(expected.right.right.data == actual.right.right.data);
        TreeTraversal_Recursive.inOrder(actual);
        System.out.println();
        TreeTraversal_Recursive.inOrder(expected);
    }
}
