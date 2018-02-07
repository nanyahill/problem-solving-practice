package com.problems.epi.code.searching;

/**
 * Key Insight:
 * Brute Force: From 0 to k, find the square of each number and check if it is equal to k.
 * Time Complexity: O(n); Space Complexity: O(1).
 * Efficient Solution: Use binary search, starting from 0 and ending with k.
 * 1. If mid*mid < k, then all square of longegers less than or equal to mid are less than k, thus, update lo to mid + 1.
 * 2. If mid*mid > k, then all square of longegers greater than or equal to mid are greater than k, thus, update hi to mid - 1.
 * Time Complexity: O(logn); Space Complexity: O(1).
 * Optimization: The square root of a (non-negative) number N always lies between 0 and N/2.
 * Hence, the longerval for the binary search can range between 0 and k/2.
 * Note: long datatype is used because in practice when computing mathematical formulas, it is good to use long datatype to avoid overflow
 */
public class ComputeSquareRoot {

    public static long computeSquareRoot_BrutForce(long num) {
        if(num < 0) return -1; // Accepts only non-negative integers
        long res = 0;
        for(long i = 0; i < num; i++) { // can use range 0 to num/2
            if(i*i <= num) res = i;
        }
        return res;
    }

    public static long computeSquareRoot(long num) {
        if(num < 0) return -1; // Accepts only non-negative integers
        long lo = 0, hi = num;
        long res = 0;
        while(lo <= hi) {
            long mid = lo + ((hi - lo) / 2);
            if(mid*mid == num) return mid;
            else if(mid*mid < num) {
                res = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return res;
    }

    public static long computeSquareRoot_Optimization(long num) {
        if(num < 0) return -1; // Accepts only non-negative integers
        long lo = 0, hi = num / 2;
        long res = 0;
        while(lo <= hi) {
            long mid = lo + ((hi - lo) / 2);
            if(mid*mid == num) return mid;
            else if(mid*mid < num) {
                res = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return res;
    }
}
