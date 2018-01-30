package com.problems.epi.test.binary_trees.learning;

import com.problems.epi.code.binary_trees.learning.TreeTraversal_Iterative_WithStack;
import com.problems.epi.code.binary_trees.learning.TreeTraversal_Recursive;
import com.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class TreeTraversalTest {

    @Test
    public void treeTraversalRecursiveTest() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(7);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(3);
        root.left.right.left = new TreeNode<>(6);
        root.right = new TreeNode<>(8);
        root.right.right = new TreeNode<>(9);
        root.right.right.left = new TreeNode<>(10);
        //Preorder Test
        TreeTraversal_Recursive.preOrder(root);
        Assert.assertArrayEquals(new Integer[] { 5, 7, 4, 3, 6, 8, 9, 10 }, TreeTraversal_Recursive.listPreOrder.toArray());
        //Inorder Test
        TreeTraversal_Recursive.inOrder(root);
        Assert.assertArrayEquals(new Integer[] { 4, 7, 6, 3, 5, 8, 10, 9 }, TreeTraversal_Recursive.listInOrder.toArray());
        //Postorder Test
        TreeTraversal_Recursive.postOrder(root);
        Assert.assertArrayEquals(new Integer[]{ 4, 6, 3, 7, 10, 9, 8, 5 }, TreeTraversal_Recursive.listPostOrder.toArray());
    }

    @Test
    public void treeTraversalIterativeWithStackTest() {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(7);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(3);
        root.left.right.left = new TreeNode<>(6);
        root.right = new TreeNode<>(8);
        root.right.right = new TreeNode<>(9);
        root.right.right.left = new TreeNode<>(10);
        //Preorder Test
        TreeTraversal_Iterative_WithStack.preOrder(root);
        Assert.assertArrayEquals(new Integer[]{ 5, 7, 4, 3, 6, 8, 9, 10 }, TreeTraversal_Iterative_WithStack.preOrder(root).toArray());
        //Inorder Test
        TreeTraversal_Iterative_WithStack.inOrder(root);
        Assert.assertArrayEquals(new Integer[]{ 4, 7, 6, 3, 5, 8, 10, 9 }, TreeTraversal_Iterative_WithStack.inOrder(root).toArray());
        //Postorder Test
        TreeTraversal_Iterative_WithStack.postOrder(root);
        Assert.assertArrayEquals(new Integer[]{ 4, 6, 3, 7, 10, 9, 8, 5 }, TreeTraversal_Iterative_WithStack.postOrder(root).toArray());

        String [] test = TreeTraversal_Iterative_WithStack.inOrder(root).toArray(new String[0]);
    }
}
