package com.problems.epi.code.searching.general_search;

/**
 * Key Insight:
 - The array values contain exactly one number that appears twice while other appear once.
 - Also, a number is missing
 - The range of array values is the same range as the array indices - Think XOR
 Algorithm:
 - XOR all the array values with the range of values leaves you with two number- the duplicate number and 	the missing number.
 - The XOR of two numbers will have 1 bits only at those place where the two number differ in bits.
 - Hence, XOR array values and array indices that have a set this at any one of the differing bit position.
 - The result of the previous step XOR operation, yields one of the two numbers gotten in step 1.
 Note: Knowing one of the numbers doesn't tell you if it is a duplicate or missing.
 If asked to find out which number is obtained in the previous step, you can definitely know the duplicate number if is present 	as one of the array values. If not, then the number is the missing number.
 */
public class DuplicateAndMissing {
    public static int[] findDuplicateAndMissingNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int  dup_and_missing = 0;
        for(int i = 0; i < nums.length; i++) {
            dup_and_missing ^= nums[i] ^ i;
            //xorElts = xorElts ^ nums[i];
            //xorIndicies = xorIndicies ^ i;
        }
        int bitMask = dup_and_missing & ~(dup_and_missing - 1);
        int dupMiss = 0;
        for(int j = 0; j < nums.length; j++) {
            if((bitMask & j) != 0) dupMiss ^= j;
            if((bitMask & nums[j]) != 0) dupMiss ^= nums[j];
        }
        /// If dupMiss is the duplicate, it will be found as one of the array values
        for(Integer num : nums) {
            if(num == dupMiss) return new int[] {dupMiss, dupMiss ^ dup_and_missing};
        }
        return new int[] {dupMiss ^ dup_and_missing, dupMiss};
    }
}
