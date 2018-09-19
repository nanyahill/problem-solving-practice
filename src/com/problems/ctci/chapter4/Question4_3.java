package com.problems.ctci.chapter4;

import com.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Question4_3 {

    public static List<LinkedList<TreeNode>> getDepthNodesInBinaryTree(TreeNode root) {
        List<LinkedList<TreeNode>> result = new LinkedList<>();
        if(root == null) return result;
        getDepthNodesInBinaryTree_DFS(root, result, 0);
        return result;
    }

    private static void getDepthNodesInBinaryTree_DFS(TreeNode root, List<LinkedList<TreeNode>> result, int level) {
        if(root == null) return;
        LinkedList<TreeNode> curr = null;
        if(result.size() == level) {
            curr = new LinkedList<>();
            result.add(curr);
        }
        else curr = result.get(level);
        curr.add(root);
        getDepthNodesInBinaryTree_DFS(root.left, result, level + 1);
        getDepthNodesInBinaryTree_DFS(root.right, result, level + 1);
    }

    private static List<List<TreeNode>> getDepthNodesInBinaryTree_BFS(TreeNode root) {
        List<List<TreeNode>> result = new LinkedList<>();
        LinkedList<TreeNode> curr = new LinkedList<>();
        if(root == null) return result;
        curr.add(root);
        while(curr.size() > 0) {
            result.add(curr);
            LinkedList<TreeNode> parents = curr;
            curr = new LinkedList<>();
            for(TreeNode parent : parents) {
                if(parent.left != null) curr.add(parent.left);
                if(parent.right != null) curr.add(parent.right);
            }
        }
        return result;
    }
}
