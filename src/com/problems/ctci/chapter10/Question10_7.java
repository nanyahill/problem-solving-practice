package com.problems.ctci.chapter10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Scanner;

public class Question10_7 {

    // Note: BitSet is not used here because number_of_ints is a long which cannot be used to init a BitSet.
    public static int findMissingInt_1GB_Memory(String file) {
        long size = (long) Integer.MAX_VALUE + 1; // convert Integer.MAX_VALUE to long first
        byte[] bitArray = new byte[(int)(size / 8)]; // the parentheses is important!
        readFile(file, bitArray);
        for(int i = 0; i < bitArray.length; i++) {
            byte currByte = bitArray[i];
            for(int j = 0; j < 8; j++) {
                if((currByte & (1 << j)) == 0) {
                    return i * 8 + j;
                }
            }
        }
        return -1;
    }

    private static void readFile(String file, byte[] bitArray) {
        try {
            Scanner in = new Scanner(new FileReader(file));
            while (in.hasNextInt()) {
                int num = in.nextInt();
                bitArray[num / 8] |= (1 << (num % 8));
            }
        }
        catch(FileNotFoundException e) {}
    }

    /** Follow Up: What if 10MB is available and input has 1 billion distinct integers? */
    public static int findMissingInt_10MB_Memory(String file) {
        int number_of_buckets = 1 << 16;
        int[] countArray = new int[number_of_buckets];
        readFile(file, countArray);
        for(int i = 0; i < countArray.length; i++) {
            if(countArray[i] < number_of_buckets) {
                BitSet bitArray = new BitSet(number_of_buckets);
                try {
                    Scanner in = new Scanner(new FileReader(file));
                    while(in.hasNextInt()) {
                        int num = in.nextInt();
                        if(i == (num >>> 16))
                            bitArray.set(num & (number_of_buckets - 1));
                    }
                }
                catch(FileNotFoundException e) {}
                for(int j = 0; j < bitArray.size(); j++) {
                    if(!bitArray.get(j)) {
                        return (i << 16) | j;
                    }
                }
            }
        }
        return -1;
    }

    private static void readFile(String filename, int[] countArray) {
        try {
            Scanner in = new Scanner(new FileReader(filename));
            while(in.hasNextInt()) {
                int num = in.nextInt();
                countArray[num >>> 16]++;
            }
        }
        catch(FileNotFoundException e) {}
    }

    // From CTCI Repo
    public static void generateFile(String filename, int max, int missing) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);

        for (int i = 0; i < max && i >= 0; i++) {
            if (i != missing) {
                writer.println(i);
            }
            if (i % 10000 == 0) {
                System.out.println("Now at location: " + i);
            }
        }
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "/Users/Nanya/software-development/CtCI-6th-Edition/Java/Ch 10. Sorting and Searching/Q10_07_Missing_Int/input.txt";
        int max = 10000000;
        int missing = 1234325;
        long startTime; //start time
        long endTime;   //end time
        double time;    //time difference
        System.out.println("Generating file...");
        generateFile(filename, max, missing);
        System.out.println("Generated file from 0 to " + max + " with " + missing + " missing.");
        System.out.println("Searching for missing number...");

        startTime = System.currentTimeMillis();
        System.out.println("Missing value: " + findMissingInt_1GB_Memory(filename));
        endTime = System.currentTimeMillis();
        time = (endTime - startTime) / 1000.0;
        System.out.println(time);
    }
}
