package com.problems.epi.code.chapter4;

/**
 * Created by Nanya on 11/16/17.
 * This solution uses two points- topLeft and bottomRight- to define a rectangle
 */
public class RectangleIntersectionToo {
    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Rectangle {
        public Point topLeft;
        public Point bottomRight;

        public Rectangle(Point p1, Point p2) {
            this.topLeft = p1;
            this.bottomRight = p2;
        }
    }

    public static Rectangle checkForIntersection(Rectangle r1, Rectangle r2) {
        if (!isIntersect(r1, r2)) {
            return new Rectangle(new Point(0, 0), new Point(0, 0));
        }
        return new Rectangle(new Point(Math.max(r1.topLeft.x, r2.topLeft.x), Math.min(r1.topLeft.y, r2.topLeft.y)), new Point(Math.min(r1.bottomRight.x, r2.bottomRight.x), Math.max(r1.bottomRight.y, r2.bottomRight.y)));
    }

    private static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return (r1.bottomRight.x > r2.topLeft.x && r2.bottomRight.x > r1.topLeft.x && r1.topLeft.y > r2.bottomRight.y && r2.topLeft.y > r1.bottomRight.y);
    }
}
