package com.problems.epi.test.heaps;

import com.problems.epi.code.heaps.ComputeKthClosetStar;
import com.problems.epi.code.heaps.ComputeKthClosetStar.Star;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ComputeKthClosetStarTest {

    @Test
    public void computeKthClosetStarTest() {
        Star s1 = new Star(2.0, 13.2, 0.);
        s1.distance();
        Star s2 = new Star(2.0, 0.2, 0.0);
        s2.distance();
        Star s3 = new Star(4.0, 6.2, 9.0);
        s3.distance();
        Star s4 = new Star(1.0, 3.2, 2.0);
        s4.distance();
        Star s5 = new Star(0.0, 1.2, 1.0);
        s5.distance();

        List<Star> stars = Arrays.asList(s1, s2, s3, s4, s5);
        List<Star> res = ComputeKthClosetStar.computeKthClosetStars(stars, 3);

        double[] expected = new double[] {1.5620499351813308, 2.009975124224178, 3.9038442591886273};
        double[] actual = new double[] {res.get(0).distance, res.get(1).distance, res.get(2).distance};
        Assert.assertArrayEquals(expected,actual, 1e-9);
    }
}
