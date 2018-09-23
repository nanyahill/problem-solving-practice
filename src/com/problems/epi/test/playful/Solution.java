package com.problems.epi.test.playful;

class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
            int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
            while(lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = 0,  j = matrix[0].length - 1;
                for(int i = 0; i < matrix.length; i++) {
                    while(j >= 0 && matrix[i][j] > mid) j--;
                    count += (j + 1);
                }
                if(count < k) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    private static int count(int[][] matrix, int target){
        int m=matrix.length;
        int i=0;
        int j=matrix[0].length - 1;
        int count = 0;

        while(i < matrix.length &&j >= 0){
            if(matrix[i][j]<=target){
                count += i+1;
                j--;
            }else{
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3,14}, {7,8,9,17}, {8,10,11,20} };
        System.out.println(kthSmallest(matrix, 6));
    }
}