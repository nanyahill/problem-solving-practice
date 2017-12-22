package com.problems.leetcode.bit_manipulation;

/**
 * Created by Nanya on 11/22/17.
 */
public class ConvertToHex {
    public static String convertToHex(int num) {
        int maskSize = 4;
        int mask = 0xf;
        int bitGroup = 8;
        char[] hexValues = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < bitGroup; i++) {
            int tmp = num & mask;
            builder.append(hexValues[tmp]);
            num >>>= maskSize;
        }
        return cleanTrailingZeros(builder.reverse().toString());
    }

    private static String cleanTrailingZeros(String str) {
        int beginIndex = 0;
        for(beginIndex = 0; beginIndex < str.length() - 1; beginIndex++) {
            if(str.charAt(beginIndex) == '0') continue;
            else break;
        }
        return beginIndex == 0 ? str : str.substring(beginIndex);
    }

    public static String convertToHexToo(int num) {
        int maskSize = 4;
        int mask = 0xf;
        char[] hexValues = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder result = new StringBuilder();
        if(num == 0) return "0";
        while(num != 0) {
            int tmp = num & mask;
            result = result.append(hexValues[tmp]);
            num >>>= maskSize;
        }
        return result.reverse().toString();
    }
}
