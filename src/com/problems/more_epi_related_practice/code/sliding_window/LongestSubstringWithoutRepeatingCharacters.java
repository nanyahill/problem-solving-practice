package com.problems.more_epi_related_practice.code.sliding_window;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;
        int[] array = new int[128];
        for(right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            array[cRight]++;
            while(array[cRight] > 1) {
                char cLeft = s.charAt(left);
                array[cLeft]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
