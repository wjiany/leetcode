package com.wjiany.leetcode.Array2P;

import org.junit.Test;

public class RemoveElement_27 {
    @Test
    public void test(){
        int[] ins = new int[]{3,2,2,3};
        System.out.println(removeElement(ins,3));
        for (int i = 0; i < ins.length; i++) {
            System.out.println(ins[i]);
        }
    }
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == val && i==-1){  //  记录第一次位置
                i = j;
            }else if(nums[j] != val){    //如果含有val，从这个位置开始新的赋值
                if(i!=-1){
                    nums[i] = nums[j];
                    i++;
                }
            }
        }
        return i==-1?nums.length:i;   //没有val直接length否则就是i的值
    }
}