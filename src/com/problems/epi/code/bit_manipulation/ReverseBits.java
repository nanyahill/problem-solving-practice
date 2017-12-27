package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 11/20/17.
 */
public class ReverseBits {
    static int[] lookUpTable = new int[1 << 4];

    public static int[] buildLookUpTable() {
        for(int i = 0; i < (1 << 4); i++) {
            lookUpTable[i] = reverseBits(i, 3);
        }
        return lookUpTable;
    }

    private static int reverseBits(int num, int len) {
        for(int i = 0, j = len; i < j; i++, j--) {
            num = swapBits(num, i, j);
        }
        return num;
    }

    private static int swapBits(int num, int i, int j) {
        if(((num >>> i) & 1) != ((num >>> j) & 1)) {
            int mask = (1 << i) | (1 << j);
            return num ^ mask;
        }
        return num;
    }

    public static int reverseBitsLookUp(int num) {
        final int MASK_SIZE = 4;
        final int MASK = 0xf;
        return lookUpTable[num & MASK] << MASK_SIZE * 3 |
                lookUpTable[(num >>> MASK_SIZE) & MASK] << MASK_SIZE * 2 |
                lookUpTable[(num >>> MASK_SIZE * 2) & MASK] << MASK_SIZE |
                lookUpTable[(num >>> MASK_SIZE * 3) & MASK];
    }

    public static long reverseBitsIterative(int num) {
        final int NO_OF_BITS = 32;
        long result = 0;
        for(int i = 0; i < NO_OF_BITS; i++){
            if((num >>> i & 1) == 1) {
                result ^= 1 << (NO_OF_BITS - 1) - i;
            }
        }
        return result;
    }
}
