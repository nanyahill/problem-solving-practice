package com.problems.epi.code.arrays;

import java.util.Collections;
import java.util.List;

public class ComputeAlternation {

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
