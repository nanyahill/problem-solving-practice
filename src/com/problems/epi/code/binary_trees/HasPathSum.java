package com.problems.epi.code.binary_trees;

import com.util.TreeNode;

public class HasPathSum {

    public static boolean pathSum_Exists(TreeNode<Integer> root, int target) {
        if(root == null) return false;
        if(root.left == null && root.right == null && target == root.data) return true;
        return pathSum_Exists(root.left, target - root.data) || pathSum_Exists(root.right, target - root.data);
    }

}
