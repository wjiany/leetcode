package com.leetcode.wjiany.dp;

import java.util.Arrays;

/**
 * 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 */
public class LengthOfLIS_300 {
    int max = 0;
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0;i<nums.length;    i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
