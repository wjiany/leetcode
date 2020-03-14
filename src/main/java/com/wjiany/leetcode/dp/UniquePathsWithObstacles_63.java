package com.wjiany.leetcode.dp;

import org.junit.Test;

public class UniquePathsWithObstacles_63 {
    @Test
    public void test(){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i <rows ; i++) {
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else break;
        }
        for (int i = 0; i <cols ; i++) {
            if(obstacleGrid[0][i] == 0 ){
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}