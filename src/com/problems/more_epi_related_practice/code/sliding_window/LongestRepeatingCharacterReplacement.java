package com.problems.more_epi_related_practice.code.sliding_window;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        int maxFrequency = 0, result = 0;
        int[] array = new int[26];
        for(right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            array[cRight - 'A']++;
            maxFrequency = Math.max(maxFrequency, array[cRight - 'A']);
            boolean isWindowValid = (right - left + 1) - maxFrequency <= k;
            if(!isWindowValid) {
                char cLeft = s.charAt(left);
                array[cLeft - 'A']--;
                left++;
            }
            result = right - left + 1;
        }
        return result;
    }
}
