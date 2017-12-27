package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 10/24/17.
 */
public class PropagateBits {
    public static String propagateBits(int num) {
        if (num < 0) {
            return "";
        }

        int len = Integer.toBinaryString(num).length();
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            if ((num & (1 << i)) != 0) {
                for (int j = i - 1; j >= 0; j--) {
                    num |= 1 << j;
                }
                return Integer.toBinaryString(num);
            }
        }
        return "";
    }

    public static void test(int x) {
        for (int i = 31; i >= 0; i--) {
            if ((x & (1 << i)) != 0) System.out.print("1");
            else System.out.print("0");
        }
    }


    public static void main(String[] args) {
        int num = 4;
        test(num);
        System.out.println();
        System.out.println("Input: " + Integer.toBinaryString(num));
        System.out.print("Ouput: " + propagateBits(num));
    }
}
