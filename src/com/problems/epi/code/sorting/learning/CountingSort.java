package com.problems.epi.code.sorting.learning;

import java.util.Arrays;

/**
 * Key Ideas:
 - Works only on an integer-based array within a GIVEN range. (Range must be given!)
 - Elements of the input array map to the index of a temporary array (aka count array)
 - Each index of the count array stores the count of that index, that is, the frequency which the index appears as a value in the input.
 - A prefix-sum (running sum) is performed for elements in the count array to determine the starting position/place of the element in the sorted array.
 For example, count[i] = 3 means that value i in the input array should be in the third place in sorted array (i.e. position 2 using zero-based array indexing)
 - Overall there are three arrays- teh input array of size n, the count array of size k, the sorted array of size n.
 * Time complexity: O(n + k) where k is the size of the range.
 * Space Complexity: O(k)
 * NOTE: The methods below acheive the same goal and take into account non-zero minimum
 */
public class CountingSort {

    public static int[] countingSort(int[] A, int min, int max) {
        if(A == null || A.length == 0) return null;
        int[] countArray = new int[max - min + 1];
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) countArray[A[i] - min]++;
        for(int j = 1; j < countArray.length; j++) countArray[j] = countArray[j] + countArray[j - 1];
        for(int k = 0; k < result.length; k++) {
            result[--countArray[A[k] - min]] = A[k];
        }
        return result;
    }

    public static int[] countingSort_Alternative(int[] A, int min, int max) {
        if(A == null || A.length == 0) return null;
        int[] countArray = new int[max - min + 1];
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) countArray[A[i] - min]++;
        int j = 0;
        for(int k = 0; k < countArray.length; k++) {
            int count = countArray[k];
            while (count > 0) {
                result[j++] = k + min;
                --count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 9, 4, 1, 7, 9, 1, 2, 0, 1, 0, 3 };

        int[] B = { -5, -2, 9, 0, -1, 2, 3, 5, -4, 6, 8 };
        System.out.print(Arrays.toString(countingSort(B, -5, 9)));
    }
}
