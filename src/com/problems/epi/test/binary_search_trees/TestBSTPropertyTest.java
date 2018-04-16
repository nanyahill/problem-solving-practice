package com.problems.epi.test.binary_search_trees;

import com.problems.epi.code.binary_search_trees.TestBSTProperty;
import com.util.TreeNode;
import org.junit.Test;

public class TestBSTPropertyTest {

    @Test
    public void testBSTTest() {
        TreeNode<Integer> root = new TreeNode<>(11);
        root.left = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(7);

        root.right = new TreeNode<>(19);
        root.right.left = new TreeNode<>(17);
        root.right.right = new TreeNode<>(23);
        // used for testing false bst
        //root.right.right.left = new TreeNode<>(2);
        //root.right.right.right = new TreeNode<>(1);

        boolean expected = true;
        assert(expected == TestBSTProperty.testBST_Alternative(root));

    }
}
