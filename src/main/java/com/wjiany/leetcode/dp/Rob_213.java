package com.wjiany.leetcode.dp;

class Rob_213 {
    /**
     * 比较 0~n-1 和 1~n的动态198问题即可
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length-1; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        int max = dp[length-2];
        dp[length-1] = nums[length-1];
        dp[length-2] = Math.max(nums[length-2],nums[length-1]);
        for (int i = length-3; i > 0; i--) {
            dp[i] = Math.max(dp[i+1],dp[i+2] + nums[i]);
        }
        return Math.max(max,dp[1]);
    }
}