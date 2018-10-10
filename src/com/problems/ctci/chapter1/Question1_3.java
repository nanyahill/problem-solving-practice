package com.problems.ctci.chapter1;

public class Question1_3 {

    public static void replaceSpaces(char[] chars, int n) {
        if(chars == null || chars.length == 0) return;
        int spaceCount = 0;
        for(int i = 0; i < n; i++) {
            if(chars[i] == ' ') spaceCount++;
        }
        int j = n, writeIdx = (n-1) + spaceCount * 2;
        while(j > 0) {
            char c = chars[j - 1];
            if(c != ' ') {
                chars[writeIdx--] = c;
            }
            else {
                chars[writeIdx--] = '0';
                chars[writeIdx--] = '2';
                chars[writeIdx--] = '%';
            }
            j--;
        }
    }
}
