package com.problems.epi.code.binary_search_trees;

import com.problems.epi.code.binary_trees.learning.TreeTraversal_Recursive;
import com.util.TreeNode;

import java.util.Arrays;
import java.util.List;

public class ReconstructBSTFromTraversalData {

    // Wrapper class to mimic pass by reference in Java
    // See link for an explanation: http://danielnugent.blogspot.com/2015/01/simulating-pass-by-reference-for.html
    static class Index {
        public int idx;
        public Index(int idx) { this.idx = idx;}
    }

    public static TreeNode reConstructBSTFromPreorder(List<Integer> preorder) {
        if(preorder == null || preorder.size() == 0) return null;
        //Integer rootIdx = 0;
        Index index = new Index(0);
        return reConstructBSTFromPreOrderUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
    }

    private static TreeNode<Integer> reConstructBSTFromPreOrderUtil(List<Integer> preorder, int min, int max, Index index) {
        if(index.idx == preorder.size()) return null;
        TreeNode<Integer> root = new TreeNode<>(preorder.get(index.idx));
        // Checking to see if current root should be on the right or left subtree
        // If root.data > max: root should be a right child of the max node
        // If root.data < min: root should be a left child of the min node
        if(root.data > max || root.data < min) return null;
        index.idx++;
        root.left = reConstructBSTFromPreOrderUtil(preorder, min, root.data, index);
        root.right = reConstructBSTFromPreOrderUtil(preorder, root.data, max, index);
        return root;
    }

    public static TreeNode reConstructBSTFromPostorder(List<Integer> postorder) {
        if(postorder == null || postorder.size() == 0) return null;
        //Integer rootIdx = 0;
        Index index = new Index(postorder.size() - 1);
        return reConstructBSTFromPostOrderUtil(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
    }

    private static TreeNode<Integer> reConstructBSTFromPostOrderUtil(List<Integer> postorder, int min, int max, Index index) {
        if(index.idx < 0) return null;
        TreeNode<Integer> root = new TreeNode<>(postorder.get(index.idx));
        if(root.data > max || root.data < min) return null;
        index.idx--;
        root.right = reConstructBSTFromPostOrderUtil(postorder, root.data, max, index);
        root.left = reConstructBSTFromPostOrderUtil(postorder, min, root.data, index);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTFromTraversalData r = new ReconstructBSTFromTraversalData();
        List<Integer> pre = Arrays.asList(3, 2, 1, 5, 4, 6);
        List<Integer> post = Arrays.asList(1, 2, 4, 6, 5, 3);
        // Preorder
        TreeNode root = reConstructBSTFromPreorder(pre);
        TreeTraversal_Recursive.preOrder(root);
        System.out.println("Pre Order: " + TreeTraversal_Recursive.listPreOrder.toString());
        // Postorder
        TreeNode root_post = reConstructBSTFromPostorder(post);
        TreeTraversal_Recursive.postOrder(root_post);
        System.out.print("Post Order: " + TreeTraversal_Recursive.listPostOrder.toString());
    }
}
