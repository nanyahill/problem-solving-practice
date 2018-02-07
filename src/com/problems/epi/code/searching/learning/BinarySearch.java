package com.problems.epi.code.searching.learning;

/**
 * This class implements the binary search algorithm using iteratve and recursive techniques
 * Time Complexity: O(logn); Space Complexity: O(1).
 */
public class BinarySearch {

    public static int binarySearch_Iterative(Integer[] arr, Integer val) {
        if(arr == null || arr.length == 0) return -1;
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if(arr[mid] == val) return mid;
            else if(arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static int binarySearch_Recursive(Integer[] arr, Integer val, int lo, int hi) {
        if(arr == null || arr.length == 0) return -1;
        if(lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if(arr[mid] == val) return mid;
            else if(arr[mid] < val) return binarySearch_Recursive(arr, val, mid + 1, hi);
            else return binarySearch_Recursive(arr, val, lo, mid - 1);
        }
        return -1;
    }
}
