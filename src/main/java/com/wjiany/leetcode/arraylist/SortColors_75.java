package com.wjiany.leetcode.arraylist;

import java.util.HashMap;
import java.util.Map;

class SortColors_75 {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) map.put(0,map.get(0)+1);
            else if(nums[i] == 1) map.put(1,map.get(1)+1);
            else if(nums[i] == 2) map.put(2,map.get(2)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(0) > 0){
                nums[i] = 0;
                map.put(0,map.get(0)-1);
            }else if(map.get(1) > 0){
                nums[i] = 1;
                map.put(1,map.get(1)-1);
            }else {
                nums[i] = 2;
            }
        }
    }
    /*
  荷兰三色旗问题解
  */
    public void sortColors_1(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }

}