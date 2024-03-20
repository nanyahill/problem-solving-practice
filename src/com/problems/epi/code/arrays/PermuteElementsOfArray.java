package com.problems.epi.code.arrays;

public class PermuteElementsOfArray {

    /**
     * This problem still takes me a while to undertsand.
     * An elegant solution can be found here
     * https://leetcode.com/problems/build-array-from-permutation/solutions/1316500/java-solution-using-o-1-space-with-explanation/
     * Video: https://www.youtube.com/watch?v=1svjL7Docuo
     * I will skip for now because it is tagged as easy. I will be on the look out if I see a problem that uses it as a basis for its solution.
     */
    public static char[] applyPermutation(char[] A, int[] P) {
        if (A == null || P == null || A.length == 0 || P.length == 0)
            return null;
        for (int i = 0; i < A.length; i++) {
            while (P[i] != i) {
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
