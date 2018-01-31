package com.problems.epi.test.binary_trees.learning;

import com.problems.epi.code.binary_trees.learning.TreeTraversal_Iterative_WithParentPointers;
import com.problems.epi.code.binary_trees.learning.TreeTraversal_Iterative_WithStack;
import com.problems.epi.code.binary_trees.learning.TreeTraversal_Recursive;
import com.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class TreeTraversalTest {

    public TreeNode<Integer> root = new TreeNode<>(5);
    {
        root.left = new TreeNode<>(7, root);
        root.left.left = new TreeNode<>(4, root.left);
        root.left.right = new TreeNode<>(3, root.left);
        root.left.right.left = new TreeNode<>(6, root.left.right);
        root.right = new TreeNode<>(8, root);
        root.right.right = new TreeNode<>(9, root.right);
        root.right.right.left = new TreeNode<>(10, root.right.right);
    }

    @Test
    public void treeTraversalRecursiveTest() {
        //Preorder Test
        TreeTraversal_Recursive.preOrder(root);
        Assert.assertArrayEquals(new Integer[]{5, 7, 4, 3, 6, 8, 9, 10}, TreeTraversal_Recursive.listPreOrder.toArray());
        //Inorder Test
        TreeTraversal_Recursive.inOrder(root);
        Assert.assertArrayEquals(new Integer[]{4, 7, 6, 3, 5, 8, 10, 9}, TreeTraversal_Recursive.listInOrder.toArray());
        //Postorder Test
        TreeTraversal_Recursive.postOrder(root);
        Assert.assertArrayEquals(new Integer[]{4, 6, 3, 7, 10, 9, 8, 5}, TreeTraversal_Recursive.listPostOrder.toArray());
    }

    @Test
    public void treeTraversalIterativeWithStackTest() {
        //Preorder Test
        Assert.assertArrayEquals(new Integer[]{5, 7, 4, 3, 6, 8, 9, 10}, TreeTraversal_Iterative_WithStack.preOrder(root).toArray());
        //Inorder Test
        Assert.assertArrayEquals(new Integer[]{4, 7, 6, 3, 5, 8, 10, 9}, TreeTraversal_Iterative_WithStack.inOrder(root).toArray());
        //Postorder Test
        Assert.assertArrayEquals(new Integer[]{4, 6, 3, 7, 10, 9, 8, 5}, TreeTraversal_Iterative_WithStack.postOrder(root).toArray());
    }

    @Test
    public void treeTraversalIterativeWithParentPointersTest() {
        //Preorder Test
        //Assert.assertArrayEquals(new Integer[]{5, 7, 4, 3, 6, 8, 9, 10}, TreeTraversal_Iterative_WithParentPointers.preOrder(root).toArray());
        //Inorder Test
        //Assert.assertArrayEquals(new Integer[]{4, 7, 6, 3, 5, 8, 10, 9}, TreeTraversal_Iterative_WithParentPointers.inOrder(root).toArray());
        //Postorder Test
        Assert.assertArrayEquals(new Integer[]{4, 6, 3, 7, 10, 9, 8, 5}, TreeTraversal_Iterative_WithParentPointers.postOrder(root).toArray());
    }
}
