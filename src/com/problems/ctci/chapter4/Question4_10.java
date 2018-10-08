package com.problems.ctci.chapter4;

import com.util.TreeNode;

public class Question4_10 {

    public static boolean checkSubTree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if(t2 == null) return true;
        return checkSubTreeHelper(t1, t2);
    }

    private static boolean checkSubTreeHelper(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if(t1 == null) return false;
        if(t1.data == t2.data && isIdentical(t1, t2)) return true;
        return checkSubTreeHelper(t1.left, t2) || checkSubTreeHelper(t1.right, t2);
    }

    private static boolean isIdentical(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.data == t2.data) && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }
}
