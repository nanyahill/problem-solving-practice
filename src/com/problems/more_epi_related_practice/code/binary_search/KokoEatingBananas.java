package com.problems.more_epi_related_practice.code.binary_search;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 1;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int minSpeed = findMinSpeed(piles, mid);
            if (minSpeed <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int findMinSpeed(int[] piles, int mid) {
        int speed = 0;
        for (int pile : piles) {
            int speedPerPile = pile / mid;
            // OR int speedPerPile = (pile + mid - 1) / mid
            speed += speedPerPile;
            if (pile % mid > 0) speed++;
        }
        return speed;
    }
}
