package com.problems.leetcode.bit_manipulation;

/**
 * Created by Nanya on 11/23/17.
 */
public class PowerOfFour {
    public static boolean powerOfFour(int num) {
        if(num <= 1) {
            return num == 1;
        }
        if(Integer.highestOneBit(num) == num){
            while(num != 0) {
                num >>>= 2;
                if(num == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean powerOfFourToo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num & 0x55555555) != 0;
    }
}
