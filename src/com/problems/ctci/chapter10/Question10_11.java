package com.problems.ctci.chapter10;

import java.util.Collections;
import java.util.List;

public class Question10_11 {
    public static void peaksAndValleys(List<Integer> A) {
        if(A == null || A.size() == 0) return;
        for(int i = 0; i < A.size() - 1; i++) {
            if(i % 2 == 0 && A.get(i) > A.get(i + 1)) {
                Collections.swap(A, i, i+ 1);
            }
            else if (i % 2 != 0 && A.get(i) < A.get(i + 1)) {
                Collections.swap(A, i, i + 1);
            }
        }
    }

}
