package com.problems.ctci.chapter1;

public class Question1_7 {

    public static void rotateImageby90Degrees(int[][] image) {
        int n = image.length - 1;
        for (int i = 0; i <= (image.length / 2); i++) {
            for (int j = i; j < n - i; j++) {
                int tmp = image[j][n - i];
                image[j][n - i] = image[i][j];
                image[i][j] = image[n - j][i];
                image[n - j][i] = image[n - i][n - j];
                image[n - i][n - j] = tmp;
            }
        }
    }

    /*
     * clockwise rotate
     * first swap the symmetry (i.e. transpose the matrix), then reverse each row
     * 1 2 3     1 4 7     7 4 1
     * 4 5 6  => 2 5 8  => 8 5 2
     * 7 8 9     3 6 9     9 6 3
     *
     * anti-clockwise rotate
     * first swap the symmetry (i.e. transpose the matrix), then reverse each col
     */
    public static void rotateImageby90Degrees_UsingTranspose(int[][] image) {
        transposeImage(image);

        // reverse each row of the image
        for(int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[row].length - 1;
            while(i < j) {
                int tmp = image[row][i];
                image[row][i++] = image[row][j];
                image[row][j--] = tmp;
            }
        }
    }

    private static void transposeImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            for(int j = i + 1; j < image[i].length; j++) {
                int tmp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotateImageby90Degrees_UsingTranspose(image);

    }
}
