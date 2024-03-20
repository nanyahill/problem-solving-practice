package com.problems.epi.code.strings;

public class SnakeString {
    public static String snakeString(String str) {
        if (str == null || str.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        //top
        for (int i = 1; i < str.length(); i += 4) {
            builder.append(str.charAt(i));
        }
        //left-to-right
        for (int i = 0; i < str.length(); i += 2) {
            builder.append(str.charAt(i));
        }
        //bottom
        for (int i = 3; i < str.length(); i += 4) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
