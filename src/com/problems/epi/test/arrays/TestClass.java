package com.problems.epi.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nanya on 12/7/17.
 */
public class TestClass {

    public static void applyPermutation(List<Integer> perm, List<Character> A) {
        for (int i = 0; i < A.size(); ++i) {
            // Check if the element at index i has not been moved by checking if
            // perm.get(i) is nonnegative.
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                // Subtracts perm.size() from an entry in perm to make it negative,
                // which indicates the corresponding move has been performed.
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }

        // Restore perm.
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }

    public static void main(String[] args) {
        int[] arr = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 };
        int[] arr2 = { 1,3,5,4,2,3,4,5 };
        int[] nums = { 3, 5, 2, 4, 2, 2, 1, 2 };
        //partitionaArray(nums, 7);
        applyPermutation(new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 3, 2, 0, 1})), new ArrayList<Character>(Arrays.asList(new Character[] {'a', 'b', 'c', 'd', 'e'})));
    }

    private static void swap(int[] nums, int src, int dest) {
        int tmp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = tmp;
    }

    public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static int longestContinousSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i - 1]) {
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
            else count++;
        }
        return Math.max(count, maxCount);
    }

    public static int maxSubArrayBF(int[] array) {
        int best = 0;
        for (int a = 0; a < array.length; a++) {
            int sum = 0;
            for (int b = a; b < array.length; b++) {
                sum += array[b];
                best = Math.max(best,sum);
            }
        }
        return best;
    }

    public static List<Integer> enumerateAllPrimes(int num) {
        if(num <= 1) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 2; i <= num; i++) {
            boolean isPrime = true;
            for(int j = 2; j * j <= num; j++) {
                if(i % j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) result.add(i);
        }
        return result;
    }

    public static List<Integer> enumerateAllPrimes2(int num) {
        if(num <= 1) {
            return new ArrayList<Integer>();
        }
        //List<Boolean> lookUpTable = new ArrayList<Boolean>();
        List<Boolean> lookUpTable = new ArrayList<Boolean> (Collections.nCopies(num + 1, true));
        List<Integer> res = new ArrayList<Integer>();
        lookUpTable.set(0, false);
        lookUpTable.set(1, false);
        for(int i = 2; i <= num; i++) {
            if(lookUpTable.get(i)) {
                res.add(i);
            }
            for(int j = 2*i; j <= num; j+=i) {
                lookUpTable.set(j, false);
            }
        }
        return res;
    }
}
