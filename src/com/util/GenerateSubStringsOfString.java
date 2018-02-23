package com.util;

public class GenerateSubStringsOfString {

    public void generateAllSubStrings(String str) {
        for(int i = 0; i < str.length(); i++) { // update start
            for(int len = i; len < str.length(); len++) { // update end
                for(int k = i; k <= len; k++) {
                    System.out.print(str.charAt(k));
                }
                System.out.println();
            }
        }
    }

    public void generateAllSubStrings2(String str) {
        for(int i = 0; i < str.length(); i++) {
            int len = str.length() - i - 1; // update end
            for(int j = 0; j <= len; j++) { // update start
                for (int k = j; k <= len; k++) {
                    System.out.print(str.charAt(k));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        GenerateSubStringsOfString gen = new GenerateSubStringsOfString();
        gen.generateAllSubStrings2("abc");

    }
}
