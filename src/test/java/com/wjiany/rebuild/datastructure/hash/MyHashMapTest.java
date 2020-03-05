package com.wjiany.rebuild.datastructure.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void test() {
        MyMap<Integer, Integer> map = new MyHashMap<>(8);
        map.put(0,0);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        map.put(6,6);
        map.put(7,7);
        System.out.println(map.get(7));
        map.put(7,8);
        System.out.println(map.get(7));
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.size());
        System.out.println(map.remove(1));
        System.out.println(map.size());
        System.out.println(map.get(1));
    }
}