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
 * NOTE: The methods below achieve the same goal and take into account non-zero minimum
 */

/****************************************************************************************/
/** Note that the countingSort(...) mainly differs from countingSortSedgewick(...) in:
 * The count frequency step: countingSortSedgewick(...) offsets each element by 1. For example, frequency count of a value 0 is stored in array index 1.
 * The accumulate step is essentially the same- a prefix sum
 * The distribute/move step:
 * ************countingSort(...) Iterate from the right to left of the input array. Before each placement, decrement the count value.
 * ************countingSortSedgewick(...) Iterate from the left to right of the input array. After each placement, increment the count value.
 */
/***************************************************************************************/
public class CountingSort {

    // This method works well with data with metadata (e.g. database keys).
    // Still works for data with no metadata
    // min and max is to take care of negative integers (my thoughts)
    // As implemented in CLRS
    // Entries of count[] after accumulate step are the position/place the current index should be placed in the final array.
    // For example, count[2] = 3 means 2 would be placed in the 3rd position in the output array, i.e. output[2]
    public static int[] countingSort(int[] A, int min, int max) {
        if(A == null || A.length == 0) return null;
        int[] count = new int[max - min + 1];
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) count[A[i] - min]++;
        // Perform running sum to obtain the position of array values
        for(int j = 1; j < count.length; j++) count[j] = count[j] + count[j - 1]; // prev = count[j -1]
        // Starts from behind to maintain stability
        for(int k = result.length - 1; k >= 0; k--) {
            result[--count[A[k] - min]] = A[k];
        }
        return result;
    }

    // This method works well with data with metadata (e.g. database keys).
    // Still works for data with no metadata
    // min and max is to take care of negative integers (my thoughts)
    // As implemented in Algorithms, Sedgewick & Wayne
    // Entries of count[] after accumulate step are number of elements less than the current index.
    // For example: If count[2] = 3, then there are three elements less than value of 2. count[0] is usually 0.
    public static int[] countingSortSedgewick(int[] A, int min, int max) {
        // min == 1 and max == 9
        if(A == null || A.length == 0) return null;
        int[] count = new int[max - min + 2];
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) count[(A[i] - min) + 1]++;
        for(int j = 0; j < count.length - 1; j++) count[j + 1] += count[j]; // prev = count[j]
        for(int k = 0; k < A.length; k++) result[count[(A[k] - min)]++] = A[k];
        return result;
    }

    // This method works well with data with no metadata (e.g. simple integers)
    public static int[] countingSort_Alternative(int[] A, int min, int max) {
        if(A == null || A.length == 0) return null;
        int[] count = new int[max - min + 1];
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) count[A[i] - min]++;
        int j = 0;
        for(int k = 0; k < count.length; k++) {
            int cnt = count[k];
            while (cnt > 0) {
                result[j++] = k + min;
                --cnt;
            }
        }
        return result;
    }
}
