package com.wjiany.leetcode.design;


import java.util.*;

/**
 * leetcode   146
 */
public class LRUCache extends LinkedHashMap{

    private int capacity = 0;
    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size()>capacity;
    }

    public int get(int key) {
       return (int) super.getOrDefault(key,-1);
    }


    public void put(int key, int value) {
        super.put(key,value);
        }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
