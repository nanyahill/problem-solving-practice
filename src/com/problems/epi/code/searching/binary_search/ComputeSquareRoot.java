package com.problems.epi.code.searching.binary_search;

/**
 * Key Insight:
 * Brute Force: From 0 to k, find the square of each number and check if it is equal to k.
 * Time Complexity: O(n); Space Complexity: O(1).
 * Efficient Solution: Use binary search, starting from 0 and ending with k.
 * 1. If mid*mid < k, then all square of integers less than or equal to mid are less than k, thus, update lo to mid + 1.
 * 2. If mid*mid > k, then all square of integers greater than or equal to mid are greater than k, thus, update hi to mid - 1.
 * Time Complexity: O(logn); Space Complexity: O(1).
 * Optimization: The square root of a (non-negative) number N always lies between 0 and N/2.
 * Hence, the interval for the binary search can range between 0 and k/2.
 * Note: long datatype is used because in practice when computing mathematical formulas, it is good to use long datatype to avoid overflow
 */
public class ComputeSquareRoot {

    public static int computeSquareRoot_BrutForce(int num) {
        if (num < 0) return -1; // Accepts only non-negative integers
        int res = 0;
        for (int i = 0; i <= Math.ceil(num * 0.5); i++) { // square root of num can be at most Math.ceil(num/2)
            long isSquared = (long) i * i;
            if (isSquared <= num) res = i;
        }
        return res;
    }

    public static int computeSquareRoot(int num) {
        if (num < 0) return -1; // Accepts only non-negative integers
        int lo = 0, hi = num;
        int res = 0;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            long midsquared = (long) mid * mid;
            if (midsquared == num) return mid;
            else if (midsquared < num) {
                res = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return res;
    }

    // Uses advanced binary search template
    public static int computeSquareRootAdvancedBinarySearchTemplate(int num) {
        if (num < 0) return -1;
        long lo = 0, hi = (long) num + 1;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long midSquared = mid * mid;
            if (midSquared > num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo - 1;
    }
}
