package com.problems.epi.test.stacks_queues.queues;

import com.problems.epi.code.stacks_queues.queues.QueueImpl_WithStacks;
import org.junit.Test;

public class QueueImpl_WithStacksTest {

    @Test
    public void circularQueue_WithResizingTest() {
        QueueImpl_WithStacks<Integer> q = new QueueImpl_WithStacks<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        // Now s1 contains 8 elements, s2 is empty

        assertDequeue(q, 1);
        assertDequeue(q, 2);
        assertDequeue(q, 3);
        // Now s2 contains 5 elements, while s1 is empty

        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        // Now s1 contains 3 elements, s2 has 5

        q.enqueue(14);
        // Now s1 contains 4 elements, s2 has 5

        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.enqueue(18);
        // Now s1 contains 8 elements, s2 has 5

        assertDequeue(q, 4);
        assertDequeue(q, 5);
        assertDequeue(q, 6);
        assertDequeue(q, 7);
        assertDequeue(q, 8);
        assertDequeue(q, 11);
        assertDequeue(q, 12);
        //Now s2 contains 7 elements, while s1 is empty
    }

    private static void assertDequeue(QueueImpl_WithStacks<Integer> q, Integer t) {
        Integer dequeue = q.dequeue();
        assert(t.equals(dequeue));
    }
}
