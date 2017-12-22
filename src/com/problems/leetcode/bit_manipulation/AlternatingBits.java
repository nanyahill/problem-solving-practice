package com.problems.leetcode.bit_manipulation;

/**
 * Created by Nanya on 11/21/17.
 */
public class AlternatingBits {
    public static boolean checkAltBits(int num) {
        if(num <= 0) {
            return false;
        }
        int curr = 0;
        int prev = -1;
        while(num != 0) {
            curr = num & 1;
            if(curr == prev) {
                return false;
            }
            prev = curr;
            num >>>= 1;
        }
        return true;
    }

    public static boolean checkAltBitsToo(int num) {
        if (num <= 0) {
            return false;
        }
        int curr = num & 1;
        int next = 0;
        num >>>= 1;
        while (num != 0) {
            next = num & 1;
            if (next == curr) {
                return false;
            }
            curr = next;
            num >>>= 1;
        }
        return curr != next;
    }
}
