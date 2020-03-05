package com.wjiany.rebuild.datastructure.hash;

public interface MyMap<K,V> {
    V get(K key);
    void put(K key,V value);
    int size();
    V remove(K key);
}
