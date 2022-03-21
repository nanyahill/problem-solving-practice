package com.problems.epi.code.searching.binary_search;

/**
 * Key Insight:
 * 1. Array is sorted (Think Binary Search)
 * 2. First occurrence of a search value (Think there may be duplicates)
 * 3. If value is found, it could be the first occurrence or an earlier occurrence may be found on the left side.
 * Hence, you need to keep doing the binary search by updating the end to mid - 1;
 * Algorithm:
 ** Same binary search algorithm, except each midIndex found store and continue binary search by updating end to midIndex - 1.
 * Time Complexity: O(logn); Space Complexity: O(1).
 */
public class SearchFirstOccurenceOfK {
    
    public static int searchFirstOccurenceOfK(int[] arr, int val) {
        if (arr == null || arr.length == 0) return -1;
        int lo = 0, hi = arr.length - 1;
        int firstOccurence = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (arr[mid] == val) {
                firstOccurence = mid;
                // Nothing to the right can be a first occurrence
                hi = mid - 1;
            } else if (arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }
        return firstOccurence;
    }
}
