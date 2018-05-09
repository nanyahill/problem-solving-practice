package com.problems.epi.code.binary_search_trees;

import com.util.TreeNode;

/**
 * Time Complexity: O(n), Space Complexity: O(1)
 */
public class MinimumHeightBSTFromSortedArray {

    public static TreeNode constructBSTFromSortedArray(int[] nums) {
        if(nums == null) return null;
        return constructBSTFromSortedArray(nums, 0, nums.length - 1);
    }

    private static TreeNode constructBSTFromSortedArray(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = ((end - start) / 2) + start; // instead of (start + end / 2) which can cause integer overflow
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBSTFromSortedArray(nums, start, mid - 1);
        root.right = constructBSTFromSortedArray(nums, mid + 1, end);
        return root;
    }
}
