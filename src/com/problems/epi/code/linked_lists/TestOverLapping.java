package com.problems.epi.code.linked_lists;

import com.util.ListNode;

/**
 *The main insight of the problem is that for L1 and L2 to be overlapping,
 * they must have the same tail node,i.e. once the two lists converge at a node,
 * they cannot diverge at a later node. There are two possible solutions:
 */

public class TestOverLapping {

    /**
     * Solution 1's Key Idea:
     * 1) If L1 has a length of a + c; then L2 must have a length of b + c.
     * Hence, if we can find the difference of the two lengths, then we can move the longer list (a - b) steps.
     * 2) Then we advance the two lists in tandem to get the intersection node.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode<Integer> detectOverLapSolution1(ListNode<Integer> L1, ListNode<Integer> L2) {
        if(L1 == null || L2 == null) return null;
        int lenA = length(L1);
        int lenB = length(L2);
        if(lenA > lenB) L1 = moveListByDiff(lenA - lenB, L1);
        if(lenB > lenA) L2 = moveListByDiff(lenB - lenA, L2);
        while(L1 != null && L2 != null) {
            if(L1 == L2) return L1;
            L1 = L1.next;
            L2 = L2.next;
        }
        return null;
    }

    /**
     * Solution 2's key idea:
     * 1) If each list travels a distance of a + b + c; i.e. List A travels a + c (end of its list)
     * then begins travelling list B (b + c) they will eventually converge at after a + b + c steps
     * and meet at the starting point of length c.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode<Integer> detectOverLapSolution2(ListNode<Integer> L1, ListNode<Integer> L2) {
        if(L1 == null || L2 == null) return null;
        ListNode<Integer> p1 = L1;
        ListNode<Integer> p2 = L2;
        while(p1 != p2) {
            p1 = p1 == null ? L2 : p1.next;
            p2 = p2 == null ? L1 : p2.next;
        }
        return p1;
    }

    private static ListNode<Integer> moveListByDiff(int diff, ListNode<Integer> L) {
        while(diff > 0) {
            L = L.next;
            diff--;
        }
        return L;
    }

    private static int length(ListNode<Integer> L) {
        int len = 0;
        while(L != null) {
            len++;
            L = L.next;
        }
        return len;
    }
}
