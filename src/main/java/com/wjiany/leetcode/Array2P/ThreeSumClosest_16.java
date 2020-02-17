package com.wjiany.leetcode.Array2P;

import org.junit.Test;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    @Test
    public void test(){
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }
    //-4 -1 1 2
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int tmp =nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int total = tmp + nums[left] + nums[right];
                int abs = Math.abs(total - target);
                if(abs<min){
                    min =abs;
                    result = total;
                    if (abs == 0){
                        return result;
                    }
                }
                if(total>target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int ans = nums[0]+nums[1]+nums[2];
        for (int i =0;i<length-1;i++){
            int start = i+1;
            int end = length-1;
            while (start<end){
                int sum = nums[i] + nums[start]+nums[end];
                if(Math.abs(sum-target)<Math.abs(ans-target)){
                    ans =sum;
                }
                if(sum<target){
                    start++;
                }else if(sum>target){
                    end--;
                }else {
                    return ans;
                }
            }
        }
    return ans;
    }
}
