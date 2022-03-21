package com.problems.epi.code.searching.binary_search;

/**
 * Overall Key Insight:
 * - A cyclically sorted array is an array where shifting its front elements a number of times to the back of the array
 * makes the array sorted.
 * For example: {378, 478, 550, 103, 203, 220} shifting by 3 turns arrays into {103, 203, 220, 378, 478, 550}
 * Since 'sorted' appears in the problem statement- think (binary search).
 */
public class SearchCyclicallySorted {

    /**
     * Key Insight:
     * - Since the array is cyclically sorted, this means that for any position, m in the array:
     * - If A[m] < A[last element], then the minimum value MUST be in the range (0 to m).
     * - Also, if A[m] > A[last position], then the minimum value MUST be in the range (m + 1 to last position).
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     * NOTE: If duplicates were allowed, algorithm's time complexity cannot be anything less than linear time
     */
    public static int findMinimumElementIndex_Distinct(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < nums[hi]) hi = mid;
            else if (nums[mid] > nums[hi]) lo = mid + 1;
            else return mid; // return nums[mid] if asked to return element
        }
        return -1;
    }

    /** VARIANT
     * Note that when dividing up the left and right subarray,
     * the min element must be included in the boundary of each subarray because ALL of the elements in the subarray need to be considered.
     * Excluding the min element means NOT all the elements of the array are included and the target element to find may just be the min element.
     */
    public static int findElementIndex_Distinct(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int minIdx = findMinimumElementIndex_Distinct(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            int realmid = (mid + minIdx) % nums.length;
            if (nums[realmid] == target) return realmid;
            else if (nums[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // Works same as above for distinct elements as well as duplicates
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
