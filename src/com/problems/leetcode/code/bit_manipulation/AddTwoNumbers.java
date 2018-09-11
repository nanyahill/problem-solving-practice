package com.problems.leetcode.code.bit_manipulation;

/**
 * Created by Nanya on 12/4/17.
 */
public class AddTwoNumbers {
    public static int addTwoNumbers(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = b << 1;
        }
        return a;
    }
}
