package com.problems.epi.test.binary_search_trees.implementation;

import com.problems.epi.code.binary_search_trees.implementation.BinarySearchTree;
import com.util.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private static boolean setUpIsDone = false;
    private TreeNode<Integer> root;
    //private TreeNode<Integer> root1 = new TreeNode<>(19);
    private BinarySearchTree bst;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        if(setUpIsDone) return;
        root = new TreeNode<>(19);
        // Left subtree
        root.left = new TreeNode<>(11);
        root.left.left = new TreeNode<>(5);
        root.left.left.left = new TreeNode<>(2);
        root.left.left.left.right = new TreeNode<>(3);
        root.left.left.right = new TreeNode<>(7);
        root.left.right = new TreeNode<>(13);
        root.left.right.left = new TreeNode<>(12);
        root.left.right.right = new TreeNode<>(17);
        // Right subtree
        root.right = new TreeNode<>(29);
        root.right.right = new TreeNode<>(31);
        root.right.left = new TreeNode<>(23);

        bst = new BinarySearchTree(root, 12);
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        root = null;
    }

    @Test
    public void insertionTest() {
        bst.insert(14);
        assert(root.left.right.right.left.data == 14);
    }

    @Test
    public void deletionTest() {
        bst.delete(11);
        assert(root.left.data == 12);
    }

    @Test
    public void searchTest() {
        assert(bst.search(11) == root.left);
    }

    @Test
    public void successorTest() {
        assert(bst.successor(7).data == 11);
    }

    @Test
    public void predecessorTest() {
        assert(bst.predecessor(17).data == 13);
    }

    @Test
    public void minTest() {
        assert(bst.min().data == 2);
    }

    @Test
    public void maxTest() {
        assert( bst.max().data == 31);
    }
}
