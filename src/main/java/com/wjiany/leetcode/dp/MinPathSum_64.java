package com.wjiany.leetcode.dp;

import org.junit.Test;

public class MinPathSum_64 {

    @Test
    public void test(){
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] =dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] =dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}