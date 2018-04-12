package com.problems.epi.code.sorting.learning;

import java.util.*;

/**
 * This class implements the BucketSort Algorithm
 */
public class BucketSort {

    /**
     * This method implements the bucket sort algorithm for floating point numbers ranging from 0 to 1
     * Example: Given a large array of floating point integers lying uniformly between the lower and upper bound.
     */

    public static double[] bucketSort_Doubles(double[] nums, int bucketSize) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;

        // Pre-processing: compute min and max
        double[] minMax = computeMinAndMax(nums);
        // *10 assuming numbers are between 0 and 1
        int loBound = (int) (minMax[0] * 10);
        int hiBound = (int) (minMax[1] * 10);

        // Initialize buckets
        /** Bucketcount can be initialized to n. However, computing bucketCount
         * ensures it does not get too large. e.g when n = 1,000,000
         */
        int bucketCount = (hiBound - loBound) / bucketSize + 1; // +1 because the loBound and hiBound are inclusive of the interval
        List<List<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        // Place or distribute array elements into buckets
        // Each bucket can hold n/k values where k = bucketCount
        for (int i = 0; i < n; i++) {

            // -loBound because transposing A[i] to its correct position in the range 0...bucketCount
            // example: if elements in array range from 5 (inclusive) to 12 (inclusive), then there are 12 - 5 + 1 elements
            // then if sorted, each element will be in position A[i] - 5 (loBound) of the array.
            // This ensures values in range 0-bucketSize - 1 are in bucket 0, bucketSize - 2*bucketSize - 1 are in bucket 1...etc.
            int bucketIndex = ((int) (nums[i] * 10) - loBound) / bucketSize;
            List<Double> list = buckets.get(bucketIndex);
            if (list == null) {
                list = new ArrayList<>();
                list.add(nums[i]);
            } else
                list.add(nums[i]);
        }
        for (int j = 0; j < buckets.size(); j++)
            if(!buckets.get(j).isEmpty()) Collections.copy(buckets.get(j), insertionSort(buckets.get(j).toArray(new Double[0])));
        int idx = 0;
        for (int k = 0; k < buckets.size(); k++) {
            List<Double> bucket = buckets.get(k);
            for (Double val : bucket) nums[idx++] = val;
        }
        return nums;
    }

    /**
     * A note about bucket sizes (the size of each bucket):If the values are sparsely allocated
     * over the possible value range, a larger bucket size is better since the buckets will likely be more
     * evenly distributed. An example of this is [2303, 33, 1044], if buckets can only contain 5 different
     * values then for this example 461 buckets would need to be initialised. A bucket size of 200-1000 would
     * be much more reasonable. The inverse of this is also true; a densely allocated array like
     * [103, 99, 119, 112, 111] performs best when buckets are as small as possible.
     * Thus, it is advisable to choose a bucket size properly
     * loBound and hiBound are min and max values of the array
     */
    public static int[] bucketSort_Integers(int[] A, int loBound, int hiBound, int bucketSize) {
        if (A == null || A.length == 0) return null;
        int n = A.length;

        // Initialize buckets
        /** Bucketcount can be initialized to n. However, computing bucketCount
         * ensures it does not get too large. e.g when n = 1,000,000
         */
        int bucketCount = (hiBound - loBound) / bucketSize + 1; // +1 because the loBound and hiBound are inclusive of the interval
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        // Place or distribute array elements into buckets
        // Each bucket can hold n/k values where k = bucketCount
        for (int i = 0; i < n; i++) {

            // -loBound because transposing A[i] to its correct position in the range 0...bucketCount
            // example: if elements in array range from 5 (inclusive) to 12 (inclusive), then there are 12 - 5 + 1 elements
            // then if sorted, each element will be in position A[i] - 5 (loBound) of the array.
            // This ensures values in range 0-bucketSize - 1 are in bucket 0, bucketSize - 2*bucketSize - 1 are in bucket 1...etc.
            int bucketIndex = (A[i] - loBound) / bucketSize;
            List<Integer> list = buckets.get(bucketIndex);
            if (list == null) {
                list = new ArrayList<>();
                list.add(A[i]);
            } else
                list.add(A[i]);
        }
        for (int j = 0; j < buckets.size(); j++)
            if(!buckets.get(j).isEmpty()) Collections.copy(buckets.get(j), insertionSort(buckets.get(j).toArray(new Integer[0])));
        int idx = 0;
        for (int k = 0; k < buckets.size(); k++) {
            List<Integer> bucket = buckets.get(k);
            for (Integer val : bucket) A[idx++] = val;
        }
        return A;
    }

    private static List<Double> insertionSort(Double[] nums) {
        if (nums == null || nums.length == 0) return null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && Double.compare(nums[j], nums[j - 1]) < 0; j--)
                swap(nums, j, j - 1);
        }
        return Arrays.asList(nums);
    }

    private static List<Integer> insertionSort(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--)
                swap(nums, j, j - 1);
        }
        return Arrays.asList(nums);
    }

    private static void swap(Integer[] A, int i, int j) {
        if (A == null || A.length == 0) throw new IllegalStateException();
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static void swap(Double[] A, int i, int j) {
        if (A == null || A.length == 0) throw new IllegalStateException();
        double tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static double[] computeMinAndMax(double[] nums) {
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(Double.compare(nums[i], min) < 0) min = nums[i];
            if(Double.compare(nums[i], max) > 0) max = nums[i];
        }
        return new double[] {min, max};
    }
}
