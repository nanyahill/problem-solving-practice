package com.problems.epi.code.chapter5;

import java.util.Arrays;

/**
 * Created by Nanya on 12/5/17.
 */
public class MultiplyNumbers {

    public static int[] multiplyNumbers(int[] A, int[] B) {
        int[] res = new int[(A.length + B.length)];
        for(int i = 0; i < A.length; i++) {
            int k = i;
            for(int j = 0; j < B.length; j++) {
                res[k] = res[k] + (A[i] * B[j]);
                if(res[k] > 9) {
                    int val = res[k];
                    res[k] = val % 10;
                    if(k < res.length)res[k + 1] = res[k + 1] + (val / 10);
                }
                k++;
            }
        }
        return res;
    }

    public static int[] multiplyTwoNumbers(int[] A, int[] B) {
        int sign = A[0] < 0 || B[0] < 0 ? -1 : 1;
        int lenA = A.length, lenB = B.length;
        int[] result = new int[lenA + lenB];

        for(int i = lenA - 1; i >= 0; i--) {
            for(int j = lenB - 1; j >= 0; j--) {
                result[i + j + 1] = result[i + j + 1] + (A[i] * B[j]);
                result[i + j] = result[i + j] + (result[i + j + 1] / 10);
                result[i + j + 1] = result[i + j + 1] % 10;
            }
        }

        // Remove trailing zeroes
        int first_non_zero = 0;
        while(first_non_zero < result.length && result[first_non_zero] == 0) {
            ++first_non_zero;
        }

        //Get the subArray
        result = Arrays.copyOfRange(result, first_non_zero, result.length);

        // Add the sign
        result[0] *= sign;

        return result.length == 0 ? new int[1] : result;
    }
}
