package com.problems.epi.code.chapter5;

/**
 * Created by Nanya on 12/8/17.
 */
public class PermuteElementsOfArray {

    public static char[] applyPermutation(char[] A, int[] P) {
        if(A == null || P == null || A.length == 0 || P.length == 0)
            return null;
        for(int i = 0; i < A.length; i++) {
            while(P[i] != i) {
                // Store tmp variables
                int p_tmp = P[P[i]];
                char a_tmp = A[P[i]];

                // Update
                A[P[i]] = A[i];
                P[P[i]] = P[i];

                // Restore
                P[i] = p_tmp;
                A[i] = a_tmp;

                // The above can be written with a suitable swap function
                // swap(A, A[i], A[P[i]]);
                // swap(P, P[i], P[P[i]]);
            }
        }
        return A;
    }

    private static void swap(String[] A, int des, int src) {
        String tmp = A[des];
        A[des] = A[src];
        A[src] = tmp;
    }
}
