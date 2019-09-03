package com.leetcode.wjiany.dp;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 */
public class FindNumberOfLIS_673 {

    int max = 0;
    public int findNumberOfLIS(int[] nums) {
        return findMax(nums);
    }
    public int findMax(int[] nums){
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i = 0;i<nums.length;i++){
            for (int j = 0 ;j<i ;j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
                max = Math.max(dp[i],max);
        }
        int ans = 0;
        for (int m = 0 ;m<nums.length;m++){
            if(dp[m] == max){
                ans += count[m];
            }
        }
        return ans;
    }
}
