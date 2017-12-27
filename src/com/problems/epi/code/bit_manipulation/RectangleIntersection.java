package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 11/15/17.
 * This solution uses one point, the width, and height to define a rectangle
 */
public class RectangleIntersection {
    public static class Rectangle {
        int x;
        int y;
        int width;
        int height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
        if (!isIntersect(R1, R2)) {
            return new Rectangle(0, 0, -1, -1); // No intersection.
        }
        return new Rectangle(
                Math.max(R1.x, R2.x), Math.max(R1.y, R2.y),
                Math.min(R1.x + R1.width, R2.x + R2.width) - Math.max(R1.x, R2.x),
                Math.min(R1.y + R1.height, R2.y + R2.height) - Math.max(R1.y, R2.y));
    }

    public static boolean isIntersect(Rectangle R1, Rectangle R2) {
        return R1.x <= R2.x + R2.width && R1.x + R1.width >= R2.x
                && R1.y <= R2.y + R2.height && R1.y + R1.height >= R2.y;
    }


    public static void main(String[] main) {
        Rectangle R1, R2;
        R1 = new Rectangle(1, 2, 3, 2);
        R2 = new Rectangle(4, 2, 1, 2);
        Rectangle res = intersectRectangle(R1, R2);
        System.out.print(res.x + " " + res.y + " " + res.width + " " + res.height);
    }
}
