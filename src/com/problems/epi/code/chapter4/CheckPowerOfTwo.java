package com.problems.epi.code.chapter4;

/**
 * Created by Nanya on 10/25/17.
 */
public class CheckPowerOfTwo {
    public static boolean checkPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;

    }

    public static void main(String[] args) {

        System.out.print(checkPowerOfTwo(1));
        int[] in = {0, 1, 3};
        System.out.print(missingNumberToo(in));
        //System.out.print(1);
    }
    public static int missingNumber(int[] nums) {
        int len = nums.length + 1;
        int sum = (len * (len + 1)) / 2;
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static int missingNumberToo(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
