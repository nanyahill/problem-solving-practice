package com.problems.epi.test.binary_search_trees;

import com.problems.epi.code.binary_search_trees.implementation.SearchFirstGreaterValueInBST;
import com.util.TreeNode;
import org.junit.Test;

public class SearchFirstGreaterValueInBSTTest {

    @Test
    public void searchFirstGreaterValue() {
        TreeNode<Integer> root = new TreeNode<>(11);
        root.left = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(7);

        root.right = new TreeNode<>(19);
        root.right.left = new TreeNode<>(17);
        root.right.right = new TreeNode<>(23);

        int expected = 19;
        int actual = SearchFirstGreaterValueInBST.searchFirstGreaterValueInBST_Recursive(root, 17).data;
        assert(expected == actual);
    }
}
