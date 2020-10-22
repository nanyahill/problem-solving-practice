package com.problems.epi.code.arrays;

import java.util.*;

/**
 * Dijkstra 3-way Partition Algo: Rearrange all elements in an array such that all elements less than A[i] (the pivot) is to the left side and elements greater than the pivot is to the right side
 * 1) Initially all the correct positions of elements in the array are unknown.
 * 2) Create three variables to maintain three sections of the array- smaller = 0 (ranges from 0 to smaller), equal = 0 (ranges from smaller + 1 to equal), and larger = n - 1 (ranges from equal + 1 to larger)
 * 3) Scan equal from left to right; v is the pivot value.
 *      – (a[equal] < v): exchange a[smaller] with a[equal]; increment both smaller and equal
 *      – (a[equal] > v): exchange a[larger] with a[equal]; decrement larger
 *      – (a[equal] == v): increment equal
 * 4) Repeat until equal and larger pointers cross
 *  At the end of the algorithm-
     *  elements from lo to smaller are less than pivot,
     *  elements from smaller to larger are equal to the pivot,
     *  elements from larger + 1 to end of array are greater than pivot
 *  Hence, the name 3way partition.
 *  Note: At the end of the partition, the elements that are between smaller and larger are all equal to the pivot
 */
public class DutchNationalFlag {

    public enum Color { RED, WHITE, BLUE };

    public static void dutchFlagPartition_Generic(int[] nums, int index) {
        int equal = 0, smaller = 0, larger = nums.length - 1; // important!
        int pivot = nums[index];
        while (equal <= larger) { // <= because all elements need to be checked/compared
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
                nums[equal] = nums[larger];
                nums[larger--] = tmp;
            }
        }
    }

    /**
     * This method could work for Variant 1 as well
     * Note that this algorithm produces a perfect flag as in the name if the pivot index is the middle num
     * Else it partitions around the given index which could result in 0, 1, 0, 1, 2, 2, 2 if 2 is the pivot value
     * which is still a valid partition
     * @param nums
     * @param pivot
     */
    public static void dutchFlagPartition_WithColor(List<Color> nums, int pivot) {
            int equal = 0, smaller = 0, larger = nums.size() - 1;//
            while (equal <= larger) {
                if (nums.get(equal).ordinal() < pivot) {
                    Collections.swap(nums, equal++, smaller++);
                } else if (nums.get(equal).ordinal() == pivot) {
                    equal++;
                } else {
                    Collections.swap(nums, equal, larger--);
                }
            }
    }

    public static char[] dutchFlagPartition2(char[] nums, int index) {
        int equal = 0, smaller = 0, larger = nums.length - 1;
        int pivot = nums[index];
        while (equal <= larger) {
            if (nums[equal] < pivot) {
                char tmp = nums[equal];
                nums[equal] = nums[smaller];
                nums[smaller] = tmp;
                equal++; smaller++;
                //Collections.swap(nums, equal++, smaller++);
            } else if (nums[equal] == pivot) {
                equal++;
            } else {
                char tmp = nums[equal];
                nums[equal] = nums[larger];
                nums[larger--] = tmp;
            }
        }
        return nums;
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
}
