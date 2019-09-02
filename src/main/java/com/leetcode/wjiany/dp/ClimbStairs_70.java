package com.leetcode.wjiany.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 */
public class ClimbStairs_70 {
    /**
     * 动态规划
     */
    public int climbStairs(int n) {
    int[] dp = new int[n];
    for (int i = 0; i< n;i++){
        if(i==0){
            dp[0] = 1;
        }else if(i==1){
            dp[1] = 2;
        }else {
            dp[i] = dp[i-1]+dp[i-2];
        }
    }
        return dp[n-1];
    }

    /**
     * 递归超时
     * @param n
     * @return
     */
    public int climbStairs_Re(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs_Re(n-1)+climbStairs_Re(n-2);
    }
}
