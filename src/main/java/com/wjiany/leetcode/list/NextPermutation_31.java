package com.wjiany.leetcode.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;


/**
 *   1,2,,4,5,6,7,8,1
 *   8,7,6,5,4,3,2,1
 */
public class NextPermutation_31 {
    @Test
public void test(){
    int[] ints = {2,3,1};
    nextPermutation(ints);
    Arrays.stream(ints).forEach(System.out::println);
}

    /**
     * 步骤 1 先找到比左边小的那个，-1，就是比右边大的那个  index = i
     * 步骤 2 从右边找，比这个大一点的 ，intdex = j 经过步骤1因为右边已经降序了， 交换i j
     * 倒排 i到length
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1,nums.length-1);
    }
    private void reverse(int[] nums,int left ,int right){
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums,int left ,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}