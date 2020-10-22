package com.problems.ctci.chapter1;

public class Question1_6 {

    public static String compressString(String input) {
        if(input == null || input.length() == 0) return "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            int count = 1;
            while(i+1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            builder.append(input.charAt(i));
            builder.append(count);
        }
        String result = builder.toString();
        return result.length() < input.length() ? result : input;
    }

    // This is an optimization for when the string does not have too many repeating characters.
    // Pro: StringBuilder can be initialized with known capacity upfront.
    // Cons: almost duplicate code & two loops over input for cases of many repeating characters.
    public static String compressString_Optimization(String input) {
        if(input == null || input.length() == 0) return "";
        int finalLength = countCompression(input);
        if(finalLength >= input.length()) return input;
        StringBuilder builder = new StringBuilder(finalLength);
        for(int i = 0; i < input.length(); i++) {
            int count = 1;
            while(i+1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            builder.append(input.charAt(i));
            builder.append(count);
        }
        String result = builder.toString();
        return result.length() < input.length() ? result : input;
    }

    private static int countCompression(String input) {
        int compressedCount = 0;
        int duplicateCount = 0;
        for(int i = 0; i < input.length(); i++) {
            duplicateCount++;
            // if i is on the last char OR next char is different from curr; increase the length;
            if(i + 1 == input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedCount += 1 + String.valueOf(duplicateCount).length();
                duplicateCount = 0;
            }
        }
        return compressedCount;
    }
}
