package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 11/14/17.
 */
public class PalindromeInteger {

    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeToo(int num) {
        if (num <= 0) {
            return num == 0;
        }
        return num == ReverseDigits.reverseDigits(num);
    }

    public static boolean isPalindromeMathTrick(int num) {
        if (num <= 0) {
            return num == 0;
        }

        int numOfDigits = (int) Math.floor(Math.log10(num)) + 1;
        int msdMask = (int) Math.pow(10, numOfDigits - 1);
        for (int i = 0; i < numOfDigits / 2; i++) {
            int lsd = num % 10;
            int msd = num / msdMask;
            if (lsd != msd) {
                return false;
            }
            num %= msdMask;
            num /= 10;
            msdMask /= 100;
        }
        return true;
    }

    public static boolean checkPalindrome(int num) {
        if(num <= 0) {
            return num == 0;
        }
        return isPalindrome(num);
    }

    private static boolean isPlaindrome(int num) {
        int numOfDigits = (int) Math.floor(Math.log10(num)) + 1;
        int msdMask = (int) Math.pow(10, numOfDigits - 1);

        for(int i = 0; i < numOfDigits / 2; i++) {
            int lsd = num % 10;
            int msd = num / numOfDigits;
            if(lsd != msd) {
                return false;
            }
            // Remove the most significant bit first
            num %= msdMask;
            num /= 10;
            msdMask /= 100;
        }
        return true;
    }
}
