package com.problems.epi.code.chapter5;

/**
 * Created by Nanya on 12/21/17.
 */
public class SpiralOrdering {

    /**
     * This prints out the elements of a matrix in the spiral order
     * There are four main directions for each layer of the matrix
     * Work your way from the outer layer to the inner layer
     * T: Top direction; R: Right direction; B: Bottom direction; L: Left direction
     * After each direction, eliminate the traversed direction by incrementing the corresponding direction
     * dir = (dir + 1) % 4 because there are four direction which you want to traverse one after the other
     * @param A
     * @return
     */
    public static int[] spiralOrderMatrix(int[][] A) {
        if(A == null || A.length == 0) return null;
        int rows = A.length, cols = A[0].length;
        int[] result = new int[rows * cols];
        int T = 0, R = cols - 1, B = rows - 1, L = 0;
        int dir = 0, idx = 0;

        while(T <= B && L <= R) {
            if(dir == 0) {
                for(int i = T; i < cols - 1; i++)
                    result[idx++] = A[T][i];
                T++;
            }
            else if(dir == 1) {
                for(int i = R; i < rows - 1; i++)
                    result[idx++] = A[i][R];
                R--;
            }
            else if(dir == 2) {
                for(int i = B; i >= 0; i--)
                    result[idx++] = A[B][i];
                B--;
            }
            else {
                for(int i = L; i >= 0; i--)
                    result[idx++] = A[i][L];
                L++;
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }
}
