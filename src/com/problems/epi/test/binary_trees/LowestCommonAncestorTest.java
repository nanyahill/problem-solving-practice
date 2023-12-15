package com.problems.epi.test.binary_trees;

import com.problems.epi.code.binary_search_trees.LowestCommonAncestor;
import com.problems.epi.code.binary_trees.LowestCommonAncestorInBinaryTree;
import com.problems.epi.code.binary_trees.LowestCommonAncestor_WithParentPointers;
import com.util.TreeNode;
import org.junit.Test;

public class LowestCommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(5, root);
        root.left.left = new TreeNode<>(6);
        root.left.right = new TreeNode<>(2);
        root.left.right.left = new TreeNode<>(7);
        root.left.right.right = new TreeNode<>(4);

        root.right = new TreeNode<>(1);
        root.right.right = new TreeNode<>(8);
        root.right.left = new TreeNode<>(0);

        TreeNode expected = root.left;
        TreeNode actual = LowestCommonAncestorInBinaryTree.lowestCommonAncestor_BottomUp(root, root.left.right.right, root.left);
        assert(expected == actual);
    }
    // [3,5,1,6,2,0,8,null,null,7,4]
    //5
    //4
}
