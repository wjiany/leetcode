package com.wjiany.leetcode.dp;

import org.junit.Test;

public class Rob_198 {

    @Test
    public void test(){
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[length-1];
    }

    /**
     * 官方
     * @param num
     * @return
     */
    public int rob_offical(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}