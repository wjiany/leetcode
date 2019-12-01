package com.wjiany.leetcode.hash;

import org.junit.Test;

import java.util.*;

public class TopKFrequent_347 {

    @Test
    public void test(){
        List<Integer> list = topKFrequent(new int[]{5,3,1,1,1,3,73,1}, 2);
        list.stream().forEach(System.out::println);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        int length = nums.length;
        Queue<Integer> pro = new PriorityQueue<>();
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer integer = entry.getValue();
            if(pro.size()<k){
                pro.add(integer);
            }else {
                if(integer>pro.peek()){
                    pro.remove();
                    pro.add(integer);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= pro.peek()){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
