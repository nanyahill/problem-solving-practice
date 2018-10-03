package com.problems.ctci.chapter8;

public class Question8_3 {

    public static int findMagicIndex(int[] nums) {
        return findMagicIndex(nums, 0, nums.length - 1);
    }

    private static int findMagicIndex(int[] nums, int lo, int hi) {
        if(hi < lo) return -1;
        int mid = lo + ((hi - lo)/2);
        if(nums[mid] == mid) return mid;
        int leftEndIndex = Math.min(nums[mid], mid - 1);
        int left = findMagicIndex(nums, lo, leftEndIndex);
        if(left >= 0) return left; // magic index has been found in left half
        int rightStartIndex = Math.max(nums[mid], mid + 1);
        int right = findMagicIndex(nums, rightStartIndex, hi);
        return right;
    }
}
