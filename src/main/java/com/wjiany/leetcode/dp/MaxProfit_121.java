package com.wjiany.leetcode.dp;

/**
 * 只允许  1  次交易
 */
class MaxProfit_121 {

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
    public int maxProfit_dp(int[] prices) {
        int length = prices.length;
        if(length < 1) return 0;
        int[][] dp = new int[length][2];  // 0不持有 1 持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
           // dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//错误，这里只允许买卖一次
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);//或者原来持有，或者新买入
        }
        return dp[length-1][0];
    }
}