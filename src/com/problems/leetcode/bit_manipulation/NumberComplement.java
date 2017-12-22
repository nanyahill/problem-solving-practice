package com.problems.leetcode.bit_manipulation;

/**
 * Created by Nanya on 11/21/17.
 */
public class NumberComplement {
    public static int flipBits(int num) {
        final int NO_OF_BITS = (int) (Math.log(num) / Math.log(2)) + 1;
        for(int i = 0; i < NO_OF_BITS; i++) {
            num ^= (1 << i);
        }
        return num;
    }

    public static int flipBitsToo(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
}
