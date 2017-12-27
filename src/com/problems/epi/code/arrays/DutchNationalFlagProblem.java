package com.problems.epi.code.arrays;

import java.util.*;

/**
 * Created by Nanya on 11/29/17.
 */
public class DutchNationalFlagProblem {

    enum Color { RED, WHITE, BLUE };
    //enum keys { 23 };

    /**
     * This menthod could work for Variant 1 as well
     * @param nums
     * @param pivot
     */

    public static void dutchFlagPartition(List<Color> nums, int pivot) {
            int equal = 0, smaller = 0, larger = nums.size();
            while (equal < larger) {
                if (nums.get(equal).ordinal() < pivot) {
                    Collections.swap(nums, equal++, smaller++);
                } else if (nums.get(equal).ordinal() == pivot) {
                    equal++;
                } else {
                    Collections.swap(nums, equal, --larger);
                }
            }
    }

    public static void dutchFlagPartition2(int[] nums, int index) {
        int equal = 0, smaller = 0, larger = nums.length;
        int pivot = nums[index];
        while (equal < larger) {
            if (nums[equal] < pivot) {
                int tmp = nums[equal];
                nums[equal] = nums[smaller];
                nums[smaller] = tmp;
                equal++; smaller++;
                //Collections.swap(nums, equal++, smaller++);
            } else if (nums[equal] == pivot) {
                equal++;
            } else {
                int tmp = nums[equal];
                nums[equal] = nums[--larger];
                nums[larger] = tmp;
            }
        }
    }

    /**
     * This method solves for variant2 of Chapter 5.1
     * Space complexity is O(1)
     * Time complexity is O(k*n)
     * @param nums consists of elements ranging from 0...k-1 (some questions could have it as 1...k)
     * @param k
     */
    public static void dutchFlagPartitionVariant2(List<Integer> nums, int k) {
        int i = 0, min = 0, max = k - 1;
        int left = 0, right = nums.size();
        while(min < max) {
            while(i < right) {
                if(nums.get(i) == min) {
                    Collections.swap(nums, i++, left++);
                }
                else if(nums.get(i) == max) {
                    Collections.swap(nums, i, --right);
                }
                else{
                    i++;
                }
            }
            i = left;
            min++;
            max--;
        }
    }

    /**
     * This menthod uses the idea of counting sort
     * Space complexity: O(k)
     * Time Complexity: O(n)
     * @param nums
     * @param k ranges from 0...k-1
     */
    public static void dutchFlagPartitionVariant22(List<Integer> nums, int k) {
        int[] count = new int[k];
        int i = 0;
        while(i < nums.size()) {
            count[nums.get(i)]++;
            i++;
        }
        nums.clear();
        for(int j = 0; j < count.length; j++) {
            while((count[j]--) > 0) nums.add(j);
        }
    }

    /**
     * This method bring all false to the front regardless of the ordering of true
     * Space complexity: O(1)
     * Time complexity: O(n)
     * @param bools
     */
    public static void dutchFlagPartitionVariant3(List<Boolean> bools) {
        int i = 0, right = bools.size();
        while(i < right) {
            if(bools.get(i) == true) {
                Collections.swap(bools, i, --right );
            }
            else {
                i++;
            }
        }
    }

    /**
     * This method tries to bring false to the front while maintaining the relative ordering of the true
     * @param bools
     */
    public static void dutchFlagPartitionVariant4(List<Boolean> bools) {
        int i = 0, j = 0;
        while(i < j && j < bools.size()) {
            if(bools.get(j) == true) {
                j++;
            }
            else {
                if(j - i >= 1) {
                    int jj = j;
                    do {
                        Collections.swap(bools, jj - 1, jj--);
                    } while(jj > i);
                }
                i = j;
                j++;
            }
        }
    }

    private static void generateRandArray(List<Integer> A) {
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            //int tmp = ;
            A.add(ran.nextInt(5));
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            List<Integer> A = new ArrayList<Integer>();
            generateRandArray(A);
            for (int j = 0; j < 10; j++) {
                System.out.print(A.get(j) + " ");
            }
            System.out.print("---> ");

            List<Boolean> bools = Arrays.asList( false, true, false, false, true, true, false, true, true );
            dutchFlagPartitionVariant22(A, 5);
            //dutchFlagPartitionVariant4(bools);

            int[] nums = { 3, 5, 2, 4, 2, 2, 1, 2 };
            dutchFlagPartition2(nums, nums.length - 1);

            for (int j = 0; j < 10; j++) {
                System.out.print(A.get(j) + " ");
            }
            System.out.println();

        }
    }
}
