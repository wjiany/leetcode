package com.wjiany.leetcode.dp;

class MaxProfit_309 {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //从不持股状态不能直接到持股状态，得经过一个冷冻期，才能到持股状态。
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][3]; //0不持有 1 持有 2 冻结
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+ prices[i]);//
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]-prices[i]);//想要持有，原来交易冻结和原来不持有
            dp[i][2] = dp[i-1][0];
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}