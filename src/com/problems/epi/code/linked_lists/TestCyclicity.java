package com.problems.epi.code.linked_lists;

import com.util.ListNode;

public class TestCyclicity {

    /**
     * Key idea- Floyd's tortoise and hare algorithm- There are two distinct phases:
     * 1) Determine the point of intersection: Use two pointers where one pointer moves twice as fast as the other pointer.
     * This way the faster one gets one step closer to the slower at each turn of the cycle, if there is one.
     * In the end, the slow and fast will eventually meet (This shows that the loop has a cycle and gives an intersection point).
     * 2) Determine the start of the cycle- 2(dist of tortoise) = dist of hare.
     * Explanation of phase 2: When they meet tortoise would have travelled F + a distance
     * where F is the length before cycle starts and a is the length travelled within the cycle.
     * Hence, hare would have travelled 2(F + a). If the length of the cycle is a + b.
     * Then hare would have traveled F + a + b + a before it meets with tortoise.
     * The length b is the dist to the start of the cycle.
     * One of the pointers is moved to the head of the list, and the second pointer stays at the point of intersection.
     * Then both pointers advance together one step at a time; they will meet after travelling a distance of b.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode<Integer> testCyclicity(ListNode<Integer> head) {
        if(head == null || head.next == null) return null;
        ListNode<Integer> intersect = getIntersection(head);
        while(head != null && intersect != null) {
            if(head == intersect) return intersect;
            head = head.next;
            intersect = intersect.next;
        }
        return intersect;
    }

    private static ListNode<Integer> getIntersection(ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return slow;
        }
        return null;
    }
}
