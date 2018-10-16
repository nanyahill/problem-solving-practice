package com.problems.ctci.chapter1;

public class Question1_4 {
    public static boolean isPalindromePermutation(String s) {
        if(s == null || s.length() == 0) return true;
        int bitVector = createBitVector(s);
        return bitVector == 0 || (bitVector & (bitVector - 1)) == 0;
    }

    private static int createBitVector(String s) {
        int bitVector = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if(Character.isLetter(c)) {
                int mask = 1 << (c - 'a');
                if((bitVector & mask) == 0) {
                    bitVector |= mask;
                }
                else bitVector &= ~(mask);
            }
        }
        return bitVector;
    }
}
