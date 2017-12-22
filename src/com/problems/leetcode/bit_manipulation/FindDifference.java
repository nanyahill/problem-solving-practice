package com.problems.leetcode.bit_manipulation;

import java.util.Arrays;

/**
 * Created by Nanya on 11/22/17.
 */
public class FindDifference {

    public static char findDiff1(String s, String t) {
        int t_sum = 0;
        for(int i = 0; i < t.length(); i++) {
            t_sum += t.charAt(i);
        }
        for(int j = 0; j < s.length(); j++) {
            t_sum -= s.charAt(j);
        }
        return (char) t_sum;
    }

    public static char findDiff2(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        for(int i = 0; i < s_array.length; i++) {
            if(((int)s_array[i] ^ (int) t_array[i]) != 0) {
                return t_array[i];
            }
        }
        return t_array[t_array.length - 1];
    }

    public static void printBinaryNumber(int num) {
        if(num == 0) System.out.print(0);
        while (num != 0) {
            System.out.print(num & 1);
            num >>>= 1;
        }
    }

    public static char findDiff3(String s, String t) {
        int diff = 0;
        for(int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i);
            diff ^= t.charAt(i);
        }
        return (char) diff;
    }
}
