package com.problems.epi.code.arrays;

import java.util.List;

/**
 * Created by Nanya on 12/4/17.
 */
public class PlusOne {

    public static List<Integer> plusOne(List<Integer> digits) {
        int n = digits.size() - 1;
        digits.set(n, digits.get(n) + 1);
        for(int i = n; i > 0; --i) {
            int num = digits.get(i);
            if(num == 10) {
                digits.set(i, 0);
                digits.set(i - 1, digits.get(i - 1) + 1);
            }
        }

        if(digits.get(0) == 10) {
            digits.set(0, 1);
            digits.add(0);
        }

        return digits;
    }

    public static int[] plusOneAnother(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
