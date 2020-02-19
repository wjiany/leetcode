package com.wjiany.leetcode.Array2P;

import org.junit.Test;

public class RemoveDuplicates_26 {
    @Test
    public void test(){
        int[] ints = {1, 2, 2, 3};
        System.out.println(removeDuplicates(ints));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int i = 0;
        for (int j=i+1; j < nums.length;) {

            if(nums[i] == nums[j]){
                j++;
            }else {
                if(i+1 !=j){
                   // swap(nums,i+1,j);   不用交换
                    nums[i+1] = nums[j];
                }
                i++;
                j++;
            }
        }
        return i+1;
    }
    private void swap(int[] nums,int index1,int index2){
        int num = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = num;
    }
}