package com.problems.epi.code.sorting.learning;

/**
 * This class implements Radix Sort. There are two kinds of Radix Sort:
 * the MSD Radix Sort (aka MSD String Sort) & the LSD Radix Sort
 * LSD RAdix sort can be applied easily to both Strings and Integers without any code modification.
 * MSD Radix Sort  can be applied to integers but would involve some bit manipulation.
 * Both use counting sort to maintain stability.
 * The difference between the methods- MSDRadixSort(...) and MSDRadixSort_Alternative(...) can be found in {@code CountingSort} class
 */
// TODO: Implement three-way radix sort (aka radix sort + quicksort)
public class RadixSort {

    /** LSD RAdix sort is mostly used for sorting strings with fixed length.
     * With respect to integers, when processing integers with number of digits k
     * k iterations would occur in order to completely sort the input.
     */
    public static String[] LSDRadixSort(String[] A, int w) {
        if(A == null || A.length == 0) return null;
        String[] aux = new String[A.length];
        for(int d = w - 1; d >= 0; d--) {

            int[] count = new int[256 + 1]; // +1 because we assume, all strings are of the same length

            // Step 1: count frequencies
            for(int i = 0; i < A.length; i++)
                count[A[i].charAt(d) + 1]++;

            // Step 2: transform counts to indices (aka prefix sum)
            for(int j = 0; j < 256; j++)
                count[j + 1] += count[j]; // 256 because array indices range from 0 - 256;

            // Step 3: distribute
            for(int k = 0; k < A.length; k++)
                aux[count[A[k].charAt(d)]++] = A[k];

            // Step 4: move items back to original array
            for(int l = 0; l < A.length; l++)
                A[l] = aux[l];
        }
        return A;
    }

    private static int charAt(String s, int d)
    {  if (d < s.length()) return s.charAt(d); else return -1;  }

    // Mostly used for sorting strings of variable-length
    public static String[] MSDRadixSort(String[] A) {
        if(A == null || A.length == 0) return null;
        String[] aux = new String[A.length]; // this can be a global variable;
        MSDRadixSort(A, 0, A.length - 1, 0, aux);
        return A;
    }

    public static void MSDRadixSort(String[] A, int lo, int hi, int d, String[] aux) {
        if(hi <= lo) return;
        int[] count = new int[256 + 2]; // +2 because need to take care of strings of length d;

        // count frequencies
        for(int i = lo; i <= hi; i++)
            count[charAt(A[i], d) + 2]++;

        // transform counts to indices (aka prefix sum)
        for(int j = 0; j < 256 + 1; j++)
            count[j + 1] += count[j]; // 256 + 1 because array indices range from 0 - 257;

        // distribute
        for(int k = lo; k <= hi; k++)
            aux[count[charAt(A[k], d) + 1]++] = A[k];

        // move items back to original array
        for(int l = lo; l <= hi; l++)
            A[l] = aux[l - lo];

        // recursively sort subarray (excludes sentinel -1)
        for(int r = 0; r < 256; r++)
            MSDRadixSort(A, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
    }

    public static void MSDRadixSort_Alternative(String[] A, int lo, int hi, int d, String[] aux) {
        // System.out.print("lo: " +lo + " hi: "+hi + " d: "+d);
        // System.out.println();
        if(hi <= lo) return;
        int[] count = new int[256];
        for(int i = lo; i <= hi; i++) {
            int c_idx = charAt(A[i], d);
            if(c_idx == -1) {
                count[0]++;
            }
            else count[c_idx]++;
        }
        for(int j  = 1; j < count.length; j++) count[j] += count[j - 1];
        for(int k = hi; k >= lo; k--) {
            int c_idx = charAt(A[k], d);
            if(c_idx == -1) {
                aux[--count[0]] = A[k];
            }
            else aux[--count[c_idx]] = A[k];
        }
        for(int l = lo; l <= hi; l++) A[l] = aux[l - lo];
        for(int r = 1; r < 255; r++) {
            MSDRadixSort_Alternative(A, lo + count[r], lo + count[r+1] - 1, d + 1, aux);
        }
    }
}
