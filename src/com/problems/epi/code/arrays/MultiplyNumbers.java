package com.problems.epi.code.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyNumbers {

    public static int[] multiplyNumbers(int[] A, int[] B) {
        int[] res = new int[(A.length + B.length)];
        for (int i = 0; i < A.length; i++) {
            int k = i;
            for (int j = 0; j < B.length; j++) {
                res[k] = res[k] + (A[i] * B[j]);
                if (res[k] > 9) {
                    int val = res[k];
                    res[k] = val % 10;
                    if (k < res.length) res[k + 1] = res[k + 1] + (val / 10);
                }
                k++;
            }
        }
        return res;
    }

        public static List<Integer> multiplyTwoNumbers(List<Integer> nums1, List<Integer> nums2) {
            int sign = nums1.get(0) < 0 ^ nums2.get(0) < 0 ? -1 : 1;
            nums1.set(0, Math.abs(nums1.get(0)));
            nums2.set(0, Math.abs(nums2.get(0)));
            int m = nums1.size();
            int n = nums2.size();
            int[] result = new int[m + n];
            int sum = 0;
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    int multiply = nums1.get(i) * nums2.get(j);
                    int p1 = i + j;
                    int p2 = i + j + 1;
                    sum = result[p2] + multiply;
                    result[p1] += sum / 10;
                    result[p2] = (sum) % 10;
                }
            }
            List<Integer> resultList = Arrays.stream(result).boxed().collect(Collectors.toList());
            int firstNonZero = 0;
            while(firstNonZero < resultList.size() && resultList.get(firstNonZero) == 0) firstNonZero++;
            resultList = resultList.subList(firstNonZero, resultList.size());
            if(resultList.isEmpty()) return List.of(0);
            resultList.set(0, resultList.get(0) * sign);
            return resultList;
        }

        public static void main(String[] args) {
            List<Integer> num1 = Arrays.asList(2);
            List<Integer> num2 = Arrays.asList(3);
            System.out.println(multiplyTwoNumbers(num1, num2));
        }
}
