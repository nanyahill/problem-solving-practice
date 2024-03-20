package com.problems.epi.code.strings;

public class IntegerToRoman_Variant {
    public String intToRoman(int num) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder builder = new StringBuilder();
        for(int i = values.length - 1; i >= 0; i--) {
            while(num >= values[i]) {
                num -= values[i];
                builder.append(symbols[i]);
            }
        }
        return builder.toString();
    }
}
