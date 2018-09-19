package com.problems.epi.test.playful;

class Solution {
    public int search(int[] nums, int val) {
        if(nums == null || nums.length == 0) return -1;
        int minIdx = findSmallestElement(nums, 0, nums.length - 1);
        if(minIdx >= 0) {
            if(nums[minIdx] == val) return minIdx;
            int lo = nums[nums.length - 1] > val ? minIdx : 0;
            int hi = nums[nums.length - 1] > val ? nums.length - 1 : minIdx;
            while(lo <= hi) {
                int mid = lo + ((hi - lo))/2;
                if(nums[mid] == val) return mid;
                else if(nums[mid] < val) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }

    private static int findSmallestElement(int[] A, int lo, int hi) {
        while(lo <= hi) {
            int mid = lo + ((hi - lo))/2;
            if(A[mid] < A[hi]) {
                hi = mid;
            }
            else if(A[mid] > A[hi]) {
                lo = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        //System.out.println(findSmallestElement(nums, 0, nums.length - 1));
        System.out.println(10 % 12);
    }
}