package com.leetcode.wjiany.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    @Test
    public void test(){
        int[] ints = twoSum(new int[]{1, 2, 3, 4}, 7);
        System.out.println(ints[0]);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target -nums[i])){
                return new int[]{map.get(target -nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
