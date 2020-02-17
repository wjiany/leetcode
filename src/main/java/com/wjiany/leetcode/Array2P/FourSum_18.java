package com.wjiany.leetcode.Array2P;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *   A B    C------ D   定前两个，C和D双指针跑
 */
public class FourSum_18 {

    @Test
    public void test(){
        System.out.println(fourSum(new int[]{0, 0, 0, 0, 0, 0},0));
    }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4){
            return lists;
        }
        Arrays.sort(nums);
        //定A指针
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0 && nums[i] == nums[i-1]){ //和以前的值相等，可以忽略
                continue;
            }
            //定B指针
            for (int j = i+1; j < nums.length-2 ; j++) {
                if(j>i+1&&nums[j] == nums[j-1]){
                    continue;
                }
                int m = j+1;
                int n = nums.length-1;
                int min1 = nums[i] + nums[j] + nums[m] + nums[m + 1];
                if(min1>target){
                    break;
                }
                int max1 = nums[n-3] + nums[n-2] + nums[n-1] + nums[n];
                if(max1<target){
                    break;
                }
                while (m<n){
                    int curr = nums[i] + nums[j] + nums[m] + nums[n];
                    if(curr == target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;
                        while (m<n &&nums[m] == nums[m-1]){
                            m++;
                        }
                        n--;
                        while (m<n&&nums[n] == nums[n+1]){
                            n--;
                        }
                    }else if(curr>target){
                        n--;
                    }else {
                        m++;
                    }
                }
            }
        }
        return lists;
    }
}