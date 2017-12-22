package com.problems.epi.test.chapter4;

import com.problems.epi.code.chapter4.RectangleIntersectionToo;
import com.problems.epi.code.chapter4.RectangleIntersectionToo.Point;
import com.problems.epi.code.chapter4.RectangleIntersectionToo.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nanya on 11/16/17.
 */
public class RectangleIntersectionTest {

    @Test
    public void checkForIntersectionTest() {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(4, 1);
        Point p3 = new Point(3, 6);
        Point p4 = new Point(9, 2);
        Rectangle actualOutput = RectangleIntersectionToo.checkForIntersection(new Rectangle(p1, p2), new Rectangle(p3, p4));

        Point p5 = new Point(3, 3);
        Point p6 = new Point(4, 2);
        Rectangle expectedOutput = new Rectangle(p5, p6);
        assertTrue(expectedOutput.topLeft.x == actualOutput.topLeft.x &&
                expectedOutput.topLeft.y == actualOutput.topLeft.y &&
                expectedOutput.bottomRight.x == actualOutput.bottomRight.x &&
                expectedOutput.bottomRight.y == actualOutput.bottomRight.y);
    }

}
