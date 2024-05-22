package com.problems.more_epi_related_practice.code.dynamic_programming;

public class MaximumSubArraySum {
        int maxOverAll = Integer.MIN_VALUE;
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int[] table = new int[nums.length];
            //recursive(nums, nums.length - 1);
            //return maxOverAll;
            topDown(nums, nums.length - 1, table);
            return table[nums.length - 1];
            //return bottomUp(nums);
            //return greedy(nums);
        }

        private int recursive(int[] nums, int i) {
            if(i < 0) return 0;
            int maxSoFar = 0;
            if(i == 0) maxSoFar = nums[i];
            else maxSoFar = Math.max(nums[i], nums[i] + recursive(nums, i - 1));
            maxOverAll = Math.max(maxOverAll, maxSoFar);
            return maxSoFar;
        }

        private int topDown(int[] nums, int i, int[] table) {
            if(i < 0) return 0;
            int maxSoFar = 0;
            if(i == 0) maxSoFar = nums[i];
            else maxSoFar = Math.max(nums[i], nums[i] + topDown(nums, i - 1, table));
            table[i] = Math.max(i > 0 ? table[i - 1] : maxSoFar, maxSoFar);
            return maxSoFar;
        }

        public int bottomUp(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int[] table = new int[nums.length];
            table[0] = nums[0];
            int maxOverAll = nums[0];
            for(int i = 1; i < nums.length; i++) {
                table[i]= Math.max(nums[i], nums[i] + table[i - 1]);
                maxOverAll = Math.max(maxOverAll, table[i]);
            }
            return maxOverAll;
        }

        public int greedy(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int currSum = 0;
            int maxOverAll = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                maxOverAll = Math.max(maxOverAll, currSum);
                if(currSum < 0) currSum = 0;
            }
            return maxOverAll;
        }
    }
