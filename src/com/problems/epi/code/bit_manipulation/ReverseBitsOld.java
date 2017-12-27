package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 11/9/17.
 */
public class ReverseBitsOld {

    int[] lookUpTable = new int[1 << 4];

    public int[] buildLookUpTable() {
        for (int i = 0; i < (1 << 4); i++) {
            lookUpTable[i] = reverseBits(i, 3);
        }
        return lookUpTable;
    }

    private static int reverseBits(int num, int pos) {
        for (int i = 0, j = pos; i < j; ++i, --j) {
            num = swapBits(num, i, j);
        }
        return num;
    }

    private static int swapBits(int num, int start, int end) {
        if (((num >>> start) & 1) != ((num >>> end) & 1)) {
            int mask = ((1 << start) | (1 << end));
            return (num ^ mask);
        }
        return num;
    }

    public int reverseBits(int num) {
        buildLookUpTable();
        final int SIZE = 4;
        final int BIT_MASK = 0xf;
        return lookUpTable[num & BIT_MASK] << (3 * SIZE) |
                lookUpTable[(num >>> SIZE) & BIT_MASK] << (2 * SIZE) |
                lookUpTable[(num >>> (2 * SIZE)) & BIT_MASK] << (SIZE) |
                lookUpTable[(num >>> (3 * SIZE)) & BIT_MASK];
    }

    public static long reverseBits(long num) {
        int i = 63;
        long result = 0;
        while(num != 0){
            if((num & 1) == 1){
                result ^= 1 << i;
                num >>>= 1;
                i--;
            }
        }
        return result;
    }


//    public static void main(String[] args) {
//        buildLookUpTable();
//        System.out.print(reverseBits(221));
//    }
}
