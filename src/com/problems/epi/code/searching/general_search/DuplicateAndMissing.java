package com.problems.epi.code.searching.general_search;

import java.util.List;

/**
 * Key Insight:
 * - The array values contain exactly one number that appears twice while other appear once.
 * - Also, a number is missing
 * - The range of array values is the same range as the array indices - Think XOR
 * Algorithm:
 * - XOR all the array values with the range of values leaves you with two number- the duplicate number and 	the missing number.
 * - The XOR of two numbers will have 1 bits only at those place where the two number differ in bits.
 * - Hence, XOR array values and array indices that have a set this at any one of the differing bit position.
 * - The result of the previous step XOR operation, yields one of the two numbers gotten in step 1.
 * Note: Knowing one of the numbers doesn't tell you if it is a duplicate or missing.
 * If asked to find out which number is obtained in the previous step, you can definitely know the duplicate number if is present 	as one of the array values. If not, then the number is the missing number.
 */
public class DuplicateAndMissing {
    public static int[] findDuplicateAndMissingNumbers(List<Integer> A) {
        if (A == null || A.size() == 0) return null;
        int xorResult = 0;
        for (int i = 0; i < A.size(); i++) xorResult ^= i ^ A.get(i);
        int mask = xorResult & (-xorResult);
        int missOrDup = 0;
        for (int i = 0; i < A.size(); i++) {
            if ((mask & A.get(i)) != 0) missOrDup ^= A.get(i);
            if ((mask & i) != 0) missOrDup ^= i;
        }
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == missOrDup) return new int[] {missOrDup, xorResult ^ missOrDup};
        }
        return new int[] {xorResult ^ missOrDup, missOrDup};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(returnMissing(nums));

    }
}
