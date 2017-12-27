package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 10/25/17.
 */
public class FindModulus {
    // b must be one of 1, 2, 4, 8, 16, etc...
    public static int findModulus(int a, int b) {
        return a & (b - 1);
    }

    public static void main(String[] args) {
        System.out.println(findModulus(7, 1));
    }
}
