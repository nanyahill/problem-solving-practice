package com.problems.leetcode.code.bit_manipulation;

/**
 * Created by Nanya on 11/21/17.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        final int NO_OF_BITS = 32;
        int start = 0;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < NO_OF_BITS; i++) {
            if(((x >>> i) & 1) != ((y >>> i) & 1)){
                if(start == 0) {
                    start = i + 1;
                }
                else if(end == Integer.MIN_VALUE) {
                    end = i + 1;
                    return end - start;
                }
            }
        }
        return start;
    }

    public static int hammingDistanceToo(int x, int y) {
        int mask = x ^ y;
        int count = 0;
        while(mask != 0) {
            mask &= (mask - 1);
            count++;
        }
        return count;
    }
}
