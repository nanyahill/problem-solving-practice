package com.problems.epi.code.sorting;

/**
 * Key Insight:
 - The two arrays are sorted (this is not a searching problem so no need to think of binary search).
 - This is a typical sorting problem. (Ask- What order should the final result be?- ascending or descending).
 - The end of one of the array has empty slots (Think can we fill in from the back?)
 - The length of the part of array A that has elements is given as well as the length of array B (Think- could use lengths in some way, for e.g. from the back).
 Algorithm:
 1) Iterate over elements from the back from each array, until the end of both array
 - A small trick that can make the while loop a one liner is to use a ternary operator.
 2) If a larger element is found, place it at the back of array A.
 3) Another insight to this problem is that- when the second array is completely traversed, the problem has been solved.
    Hence, you can have a while loop that just checks when array B is completely traversed.
    Although, make sure to check for the end of A inside this loop.
 */
public class MergeTwoSortedArrays {
    public static void mergeTwoSortedArrays(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) return;
        int idx = A.length - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) A[idx--] = B[j--];
            else A[idx--] = A[i--];
        }
        while (j >= 0) A[idx--] = B[j--];
        while (i >= 0) A[idx--] = A[i--]; // Not needed as arrays at the front of A is already sorted
    }

    public static void mergeTwoSortedArrays_Optimization(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) return;
        int idx = A.length - 1;
        int i = m - 1, j = n - 1;
        while (j >= 0) {
            if (i >= 0 && A[i--] >= B[j]) A[idx--] = A[i--];
            else A[idx--] = B[j--];
        }
    }

    public static void mergeTwoSortedArrays_OneLinerLoop(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) return;
        int idx = A.length - 1;
        int i = m - 1, j = n - 1;
        while (j >= 0) A[idx--] = (i < 0 || B[j] >= A[i]) ? B[j--] : A[i--];
        //while (j >= 0) A[idx--] = B[j--];
    }

}
