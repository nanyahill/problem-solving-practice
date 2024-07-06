package com.problems.more_epi_related_practice.code.binary_search;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int indexOfMinimumElemntInRotatedArray = findMinRotatedArray(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int adjustedMid = ((mid + indexOfMinimumElemntInRotatedArray) % nums.length);
            if (nums[adjustedMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[((lo + indexOfMinimumElemntInRotatedArray) % nums.length)] == target ? ((lo + indexOfMinimumElemntInRotatedArray) % nums.length) : -1;
    }

    private int findMinRotatedArray(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else lo = mid + 1;
        }
        return lo;
    }
}
