package com.leetcode.wjiany.design;


import java.util.*;

/**
 * leetcode   146
 */
//todo  有问题
public class LRUCache {

    private List<Map<Integer,Integer>> list = null;
    private int capacity = 0;
    private int size = 0;
    public LRUCache(int capacity) {
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        for (int i = 0;i<size;i++){
            if (list.get(i).containsKey(key)){
                if(i != 0){
                    swap(list ,i);
                }
                return list.get(i).get(key);
            }
        }
        return -1;
    }

    private void swap(List<Map<Integer, Integer>> list, int i) {
        if(i == 0){
            return;
        }
        Iterator<Map<Integer, Integer>> iterator = list.iterator();
        Map<Integer,Integer> tmp = null;
        while (iterator.hasNext()){
            Map<Integer, Integer> next = iterator.next();
            if(i == 0){
                tmp = next;
                iterator.remove();
                break;
            }
            i--;
        }
        list.add(0,tmp);
    }

    public void put(int key, int value) {
        if(get(key) == -1){
            HashMap<Integer, Integer> tmpMap = new HashMap<>();
            tmpMap.put(key,value);
            list.add(0,tmpMap);
            size++;
            if(size>capacity){
                list.remove(capacity);
                size--;
            }
        }else {
            int index = get(key);
            if(index != 0){
                swap(list,index);
            }
            Integer firstValue = list.get(0).get(key);
            if(firstValue != value){
                HashMap<Integer, Integer> tmpMap = new HashMap<>();
                tmpMap.put(key,value);
                list.set(0,tmpMap);
            }
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
