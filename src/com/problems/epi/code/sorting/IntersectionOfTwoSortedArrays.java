package com.problems.epi.code.sorting;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

/**
 * Problem Type: Sorting, Arrays
 */
public class IntersectionOfTwoSortedArrays {

    /**
     * Brute Force: For each element in array compare with every other elements of the second array.
     * Time: O(mn), Space: O(1)
     Key Insight:
     - Two arrays are sorted in the same order (Think Binary Search)
     - Based on the possible lengths of the two arrays, different solutions are possible:
     - Iterate over shorter array and search for each element in longer array using Binary Search
     Time Complexity; O(nlogm) where n = length of shorter array, m = length of longer array
     Space Complexity: O(1)
     - Store the shorter array in a set (or hashtable) ad iterate over longer array and check if element is in the set
     - Be mindful of duplicates, always check the previous elements for i > 0
     - Time Complexity: O(m + n), Space: O(n)
     - Best Approach: Two pointer technique
     - Have two pointers that move insync in each array.
     - If the elements are equal add to the new array (mindful of duplicates)
     - If element in i is less than element in j, move i ahead because there is no element equal to that smaller element in the array iterated using j.
     - If element in j is less than element in i, move j ahead because there is no element equal to that smaller element in the array iterated using i.

     CAUTION: You may be forced to use a list and then convert to an int array (not Integer array) by iterating over the list,
                IF you are asked to return an int[]

     NOTE: A variant is what if the two arrays are unsorted. Possible Solutions:
     1) Store one of the array in a hashset and iterate over the second and store similar elements in a result set. Time and Space :O(n)
     2) Sort one of the arrays and then for each element in the unsorted array search for it using binary search. This approach is best if one array is much larger than the other. Sort the larger and iterate over the shorter. (Onlogn)
     3) Sort the two arrays and use two pointer technique as described above. Time: O(nlogn)
     */

    public static int[] findIntersection_BruteForce(int[] A, int[] B) {
        if(A == null || B == null) return null;
        int lenA = A.length, lenB = B.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < lenA; i++) {
            if(i > 0 && A[i] == A[i -1]) continue;
            for(int j = 0; j < lenB; j++) {
                if(A[i] == B[j]) {
                    result.add(A[i]);
                    break;
                }
            }
        }
        int[] intersect = new int[result.size()];
        for(int j = 0; j < result.size(); j++) intersect[j] = result.get(j);
        return intersect;
    }

    public static int[] findIntersection_Efficient(int[] A, int[] B) {
        if(A == null || B == null) return null;
        int lenA = A.length, lenB = B.length;
        final int MAX_DIFF = 50;
        List<Integer> result = new ArrayList<>(); // easier to use a list then convert it to an array before returning
        if(Math.abs(lenA - lenB) <= MAX_DIFF) {
            return findIntersection_UsingBinarySearch(lenA > lenB ? B : A, lenA > lenB ? A : B);
        }
        int i = 0, j = 0;
        while(i < lenA && j < lenB) {
            if((i == 0 || (A[i] != A[i - 1])) && A[i] == B[j]) {
                result.add(A[i]);
                i++; j++;
            }
            else if(A[i] < B[j]) i++;
            else j++;
        }
        int[] intersect = new int[result.size()];
        for(int k = 0; k < result.size(); k++) intersect[k] = result.get(k);
        return intersect;
    }

    private static int[] findIntersection_UsingBinarySearch(int[] shorter_array, int[] longer_array) {
        if(shorter_array == null || longer_array == null) return null;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < shorter_array.length; i++) {
            if(i == 0 || shorter_array[i] != shorter_array[i - 1]) {
                // Arrays.binarySearch() returns the position index
                if(Arrays.binarySearch(longer_array, shorter_array[i]) >= 0) {
                    result.add(shorter_array[i]);
                }
            }
        }
        int[] intersect = new int[result.size()];
        for(int k = 0; k < result.size(); k++) intersect[k] = result.get(k);
        return intersect;
    }

    // Time: O(n); Space: O(n)
    public static int[] findIntersection_NoDuplicatesAndUnsorted(int[] A, int[] B) {
        if(A == null || B == null) return null;
        int lenA = A.length, lenB = B.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>(); //HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < lenA; i++) set.add(A[i]);
        for(int j = 0; j < lenB; j++) {
            // result can just be defined as a Set to avoid the second condition in the if statement
            // you cannot iterate over a set without the iterator
            if(set.contains(B[j]) && !result.contains(B[j])) result.add(B[j]);
        }
        int[] intersect = new int[result.size()];
        for(int k = 0; k < result.size(); k++) intersect[k] = result.get(k);
        return intersect;
    }

    // Time: O(n); Space: O(n)
    public static int[] findIntersection_AllowDuplicatesAndUnSorted(int[] A, int[] B) {
        if(A == null || B == null) return new int[0];
        int lenA = A.length, lenB = B.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < lenA; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            }
            else map.put(A[i],1);
        }
        for(int j = 0; j < lenB; j++) {
            if(map.containsKey(B[j]) && map.get(B[j]) > 0) {
                result.add(B[j]);
                map.put(B[j], map.get(B[j]) - 1);
            }
        }
        int[] intersect = new int[result.size()];
        for(int k = 0; k < result.size(); k++) intersect[k] = result.get(k);
        return intersect;
    }
}
