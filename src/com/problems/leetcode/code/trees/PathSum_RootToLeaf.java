package com.problems.leetcode.code.trees;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_RootToLeaf {

    public static boolean pathSum_Exists(TreeNode<Integer> root, int target) {
        if(root == null) return false;
        if(root.left == null && root.right == null && target == root.data) return true;
        return pathSum_Exists(root.left, target - root.data) || pathSum_Exists(root.right, target - root.data);
    }

    public static List<List<Integer>> pathSum_AllPaths(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum_AllPaths(root, target, new ArrayList<>(), result);
        return result;
    }

    private static void pathSum_AllPaths(TreeNode<Integer> root, int target, List<Integer> tmp, List<List<Integer>> result) {
        if(root == null) return;
        tmp.add(root.data);
        if(root.left == null && root.right == null && target == root.data) {
            result.add(new ArrayList<>(tmp));
            // Un-comment below code for an alternative way to write the code.
            //tmp.remove(tmp.size() - 1);
            //return;
        }
        pathSum_AllPaths(root.left, target - root.data, tmp, result);
        pathSum_AllPaths(root.right, target - root.data, tmp, result);
        tmp.remove(tmp.size() - 1);
    }

    public static int pathSum_CountPaths(TreeNode<Integer> root, int target) {
        if(root == null) return 0;
        if(root.left == null && root.right == null && target == root.data) return 1;
        return pathSum_CountPaths(root.left, target - root.data) + pathSum_CountPaths(root.right, target - root.data);
    }
}
