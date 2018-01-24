package com.problems.epi.test.stacks_queues.queues;

import com.problems.epi.code.stacks_queues.queues.Queue_WithCircularArray_NoResizing;
import com.problems.epi.code.stacks_queues.queues.Queue_WithCircularArray_WithResizing;
import org.junit.Test;

public class Queue_WithCircularArrayImplentationTest {

    @Test
    public void circularQueue_NoResizingTest() {
        Queue_WithCircularArray_NoResizing<Integer> q = new Queue_WithCircularArray_NoResizing<>(8);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.dequeue();
        q.dequeue();
        try {
            q.enqueue(9);
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        assert(q.size() == 7);
    }


//    @Test
//    public void circularQueue_WithResizingTest() {
//        Queue_WithCircularArray_WithResizing<Integer> q = new Queue_WithCircularArray_WithResizing<>(8);
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//        q.enqueue(6);
//        q.enqueue(7);
//        q.enqueue(8);
//        q.dequeue();
//        q.dequeue();
////        try {
////            q.enqueue(9);
////        }
////        catch (IllegalStateException e){
////            System.out.println(e.getMessage());
////        }
//        assert(q.size() == 6);
//    }

    @Test
    public void circularQueue_WithResizingTest() {
        Queue_WithCircularArray_WithResizing<Integer> q = new Queue_WithCircularArray_WithResizing<>(8);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        // Now head = 0 and tail = 0

        assertDequeue(q, 1);
        assertDequeue(q, 2);
        assertDequeue(q, 3);
        // Now head = 3 and tail = 0

        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        // Ok till here. Now head = 3 and tail = 3

        q.enqueue(14);
        // Now the vector (entries) is resized; but the head and tail.
        // (or elements) does not change accordingly.

        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.enqueue(18);
        // The elements starting from head=3 are over-written!

        assertDequeue(q, 4);
        assertDequeue(q, 5);
        assertDequeue(q, 6);
        assertDequeue(q, 7);
        assertDequeue(q, 8);
        assertDequeue(q, 11);
        assertDequeue(q, 12);
    }

    private static void assertDequeue(Queue_WithCircularArray_WithResizing<Integer> q, Integer t) {
        Integer dequeue = q.dequeue();
        assert(t.equals(dequeue));
    }
}
