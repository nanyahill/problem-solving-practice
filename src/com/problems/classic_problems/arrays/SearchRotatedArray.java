package com.problems.classic_problems.arrays;

public class SearchRotatedArray {

    public static int findMinimumElementIndex_Distinct(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if(nums[mid] < nums[hi]) hi = mid;
            else if(nums[mid] > nums[hi]) lo = mid + 1;
            else return mid; // return nums[mid] if asked to return element
        }
        return -1;
    }

    public static int findMinimumElementIndex_Duplicates(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if(nums[mid] == nums[hi] && mid != hi) hi--;
            else if(nums[mid] < nums[hi]) hi = mid;
            else if(nums[mid] > nums[hi]) lo = mid + 1;
            else return mid; // return nums[mid] if asked to return element
        }
        return -1;
    }

    // Gotchas: Return realmid when key is found
    public static int findElementIndex_Distinct(int[] nums, int key) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        int minIdx = findMinimumElementIndex_Distinct(nums);
        while(lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int realmid = (mid + minIdx) % nums.length;
            if(nums[realmid] == key) return realmid; // !important
		else if(nums[realmid] < key) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // Works for both distinct and duplicates
    public static int findElementIndex_Duplicates(int[] nums, int key) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if(nums[mid] == key) return mid;
            if(nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
                lo++;
                hi--;
            }
            else if(nums[lo] <= nums[mid]) {
                if(nums[lo] <= key && nums[mid] > key) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if(nums[mid] < key && nums[hi] >= key) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
