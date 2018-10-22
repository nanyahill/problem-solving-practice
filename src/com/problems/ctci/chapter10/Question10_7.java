package com.problems.ctci.chapter10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question10_7 {

    public static int findMissingInt(String filename) throws FileNotFoundException {
        if(filename == null || filename.length() == 0) return -1;
        long number_of_ints = (long)(Integer.MAX_VALUE) + 1; // convert Integer.MAX_VALUE to long first
        byte[] bitArray = new byte[(int) (number_of_ints / 8)]; // the paraenthese is important!
        Scanner in = new Scanner(new FileReader(filename));
        while(in.hasNextInt()) {
            int num = in.nextInt();
            bitArray[num / 8] |= (1 << num % 8);
        }
        for(int i = 0; i < bitArray.length; i++) {
            int bitVector = bitArray[i];
            for(int j = 0; j < 8; j++) {
                if((bitVector & (1 << j)) == 0)
                    return i * 8 + j;
            }
        }
        return -1;
    }
}
