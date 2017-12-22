package com.problems.leetcode.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanya on 11/23/17.
 */
public class BinaryWatch {

    static List<String> list;

    public static List<String> binaryWatch(int num) {
        list = new ArrayList<String>();
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 60; j++) {
                if((Integer.bitCount((i << 6) + j)) == num) {
                    list.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryWatch.binaryWatch(6);
        for(String s : list) {
            System.out.print(s + " ");
        }
    }
}
