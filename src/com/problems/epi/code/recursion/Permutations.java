package com.problems.epi.code.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Permutations {

    public static void permutation1(int[] a, int n, int j) {
        if(j == n) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for(int i = j;i < n;i++) {
            if(i != j) {
                System.out.print("Nan");
            }
            swap(a, i, j);  // (remove the ith element)
            permutation1(a, n, j + 1);
            swap(a, i, j);  // (restore for the next round)
        }
    }

    public static void permutationTC(int[] a, int n) {
        if(n == 1) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for(int i = 0;i < n;i++) {
            swap(a, i, n-1);  // (remove the ith element)
            permutationTC(a, n-1);
            swap(a, i, n-1);  // (restore for the next round)
        }
    }

    public static ArrayList<ArrayList<Integer>> permutationTC2(int[] a, int n) {

        ArrayList<ArrayList<Integer>> gen = new ArrayList<>();
        if(n == 1) {
            ArrayList<Integer> new_permutation = new ArrayList<>();
            new_permutation.add(a[n-1]);
            gen.add(new_permutation);
        } else {
            Iterator<ArrayList<Integer>> itr = permutationTC2(a, n-1).iterator();
            while(itr.hasNext()) {
                ArrayList<Integer> permutation = itr.next();
                // (create new permutation with this element in every position)
                for(int i = 0;i <= permutation.size();i++) {
                    ArrayList<Integer> new_permutation = new ArrayList<>(permutation);
                    new_permutation.add(i, a[n-1]);
                    gen.add(new_permutation);
                }
            }
        }
        return gen;
    }

    private static void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0) throw new IllegalStateException();
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,};
        permutation1(nums, 3, 0);
        //permutationTC(nums, 3);
        //permutationTC2(nums, 3);

    }
}
