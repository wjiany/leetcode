package com.wjiany.leetcode.arraylist;

import org.junit.Test;

import java.util.Arrays;

/**
 * hash 桶分原理和鸽巢原理
 */
public class FirstMissingPositive_41 {
    @Test
    public void test(){
        System.out.println(firstMissingPositive(new int[]{-1,1,3,4}));
    }

    /**
     * 别人的，那个数字不会超过数组的长度的大小，因此只需要把0---length-1，的数字放到自己的index就好
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            //while  ，把num【i】 换到正确的位置，此时新的num【i】还要换。
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    /**
     * quick sort  Ot=nlgn 》 n
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int value = 1;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]<1){
                continue;
            }
            if(j == 0 && nums[j] >1){
                return value;
            }
            if(j>0&&value <nums[j]&&value >nums[j-1]){
                return value;
            }
            value = nums[j] +1;
        }
        return value;
    }
}