package com.wjiany.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 */
public class SingleNumber_136 {


    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0;i<nums.length;i++){
            a^=nums[i];
        }
        return a;
    }
    /**
     * 时间On
     * 空间On
     * @param nums
     * @return
     */
    public int singleNumber_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
}
