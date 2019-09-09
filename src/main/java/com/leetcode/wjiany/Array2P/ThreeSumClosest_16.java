package com.leetcode.wjiany.Array2P;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
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
