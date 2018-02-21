package com.problems.epi.test.hash_tables;

import com.problems.epi.code.hash_tables.LRUCache;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void lruCacheTest() {
        final int CAPACITY = 2;
        LRUCache c = new LRUCache(CAPACITY);
        System.out.println("c.insert(1, 1)");
        c.insert(1, 1.0);
        System.out.println("c.insert(1, 10)");
        c.insert(1, 10.0);
        System.out.println("c.get(2, val)");
        assert(null == c.get(2));
        System.out.println("c.get(1, val)");
        assert(c.get(1) == 1);
        c.remove(1);
        assert(null == c.get(1));


        // test capacity constraints honored, also FIFO ordering
        c = new LRUCache(CAPACITY);
        c.insert(1, 1.0);
        c.insert(2, 1.0);
        c.insert(3, 1.0);
        c.insert(4, 1.0);
        assert(null == c.get(1));
        assert(null == c.get(2));
        assert(1 == c.get(3));
        assert(1 == c.get(4));
    }
}
