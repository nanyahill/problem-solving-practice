package com.problems.epi.code.searching;

/**
 * Overall Key Insight:
 - A cyclically sorted array is an array where shifting its front elements a number of times to the back of the array
 makes the array sorted.
 For example: {378, 478, 550, 103, 203, 220} shifting by 3 turns arrays into {103, 203, 220, 378, 478, 550}
 Since 'sorted' appears in the problem statement- think (binary search).
 */
public class SearchCyclicallySorted {

    /**
     * Key Insight:
     - Since the array is cyclically sorted, this means that for any position, m in the array:
     - If A[m] < A[last element], then the minimum value MUST be in the range (0 to m).
     - Also, if A[m] > A[last position], then the minimum value MUST be in the range (m + 1 to last position).
     Time Complexity: O(logn)
     Space Complexity: O(1)
     */
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int m = lo + ((hi - lo) / 2);
            if(nums[m] > nums[hi]) lo = m + 1;
            else hi = m;
        }
        return lo;
    }

    /**
     * Key Insight:
     - Since the array is cyclically sorted, this means that for any position, m in the array:
     - If A[m] < A[last element], then the maximum value MUST be in the range (m + 1 to last position).
     - Also, if A[m] > A[last position], then the maximum value MUST be in the range (0 to m).
     */
    public static int findMax(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int m = lo + ((hi - lo) / 2);
            if(nums[m] < nums[hi]) lo = m + 1;
            else hi = m;
        }
        return hi;
    }

    /**
     * Note that when dividing up the left and right subarray,
     * the min element must be included in the boundary of each subarray because ALL of the elements in the subarray need to be considered.
     * Excluding the min element means NOT all the elements of the array are included and the target element to find may just be the min element.
     */
    public static int findK(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int minIdx = findMin(nums);
        int len = nums.length;
        int lo = (target <= nums[len - 1]) ? minIdx : 0; // left subarray
        int hi = (target > nums[len - 1]) ? minIdx : len - 1; // right subarray
        while(lo <= hi) {
            int m = lo + ((hi - lo) / 2);
            if(nums[m] == target) return m;
            else if(nums[m] < target) lo = m + 1;
            else hi = m - 1;
        }
        return -1;
    }
}
