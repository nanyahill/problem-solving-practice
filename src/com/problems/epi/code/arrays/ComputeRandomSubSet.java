package com.problems.epi.code.arrays;

import java.util.*;

/**
 * Created by Nanya on 12/19/17.
 */
public class ComputeRandomSubSet {

    /**
     * Using Arrays
     * Time complexity: O(n) + O(k)
     * Space Complexity: O(n) + O(k)
     * @param n
     * @param k
     * @return
     */
    public static int[] computeRandomCombination(int n, int k) {
        if(n < 0 || k < 0) return null;

        int[] n_array = new int[n];
        for(int i = 0; i < n; i++) n_array[i] = i;

        Random	rand = new Random();
        int[] k_array = new int[k];
        for(int j = 0; j < k; j++) {
            int r_int = j + rand.nextInt(n - j);
            int tmp = n_array[r_int];
            n_array[r_int] = n_array[j];
            n_array[j] = tmp;
            k_array[j] = n_array[j];
        }
        return k_array;
    }

    /** Using HashTables
     * Time Complexity: O(k)
     * Space complexity: O(k)
     * @param n
     * @param k
     * @return
     */

    public static int[] computeRandomCombinationWithHashTable(int n, int k) {
        if(n < 0 || k < 0) return null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random rand = new Random();

        for(int i = 0; i < k; i++) {
            int r_int = i + rand.nextInt(n - i);
            Integer r_val = map.get(r_int);
            Integer i_val = map.get(i);
            if(r_val == null && i_val == null) {
                map.put(i, r_int);
                map.put(r_int, i);
            }
            else if(r_val == null && i_val != null) {
                map.put(i, r_int);
                map.put(r_int, i_val);
            }
            else if(r_val != null && i_val == null) {
                map.put(i, r_val);
                map.put(r_int, i);
            }
            else {
                map.put(i, r_val);
                map.put(r_int, i_val);
            }
        }

        int[] k_array = new int[k];
        for(int j = 0; j < k; j++) {
            k_array[j] = map.get(j);
        }
        return k_array;
    }

    /**
     *  Using randomSampling method from OfflineSampling class
     */
    public static int[] computeRandomCombinationToo(int n, int k) {
        if(n < 0 || k < 0) return null;

        int[] n_array = new int[n];
        for(int i = 0; i < n; i++) n_array[i] = i;
        OfflineSampling.randomSampling(n_array, k);

        int[] k_array = new int[k];
        for(int j = 0; j < k; j++) {
            k_array[j] = n_array[j];
        }
        return k_array;
    }

    // Using a list. Training on how to convert a list to array
    public static Integer[] computeRandomCombination3(int n, int k) {
        if(n < 0 || k < 0) return null;

        //int[] n_array = new int[n];
        List<Integer> n_list = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++) n_list.add(i);


        Random	rand = new Random();
        //int[] k_array = new int[k];
        List<Integer> k_list = new ArrayList<Integer>(k);
        for(int j = 0; j < k; j++) {
            int r_int = j + rand.nextInt(n - j);
            Collections.swap(n_list, j, r_int);
            k_list.add(n_list.get(j));
        }
        return k_list.toArray(new Integer[k_list.size()]);
        //return k_list.toArray(new Integer[0]); // same as above
    }
}
