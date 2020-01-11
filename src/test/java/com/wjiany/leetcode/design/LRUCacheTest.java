package com.wjiany.leetcode.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void get() {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
    }

    @Test
    public void put() {
    }
}