package com.wjiany.leetcode.Array2P;

import org.junit.Test;

public class SearchInsert_35 {

    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int left = 0;
        int right = length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if  (nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}