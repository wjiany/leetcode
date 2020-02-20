package com.wjiany.leetcode.Array2P;

import org.junit.Test;

import java.util.Arrays;

public class SearchRange_34 {

    @Test
    public void test(){
        Arrays.stream(searchRange(new int[]{5,7,7,8,8,10},8)).forEach(System.out::println);
    }
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return new int[]{-1,-1};
        }
        if(length == 1){
           return nums[0] == target?new int[]{0,0}:new int[]{-1,-1};
        }
        int left = 0;
        int right = length-1;
        if (nums[right]<target || nums[left] > target){
            return new int[]{-1,-1};
        }
        int leftIndex = -1;
        int rightIndex = -1;
        while (left<=right){
            if (nums[left] != target){
                left ++;
            }else {
                leftIndex = left;
            }
            if (nums[right] != target){
                right--;
            }else {
                rightIndex = right;
            }
            if(leftIndex !=-1 && rightIndex != -1){
                break;
            }
        }
        return new int[]{leftIndex,rightIndex};
    }
}