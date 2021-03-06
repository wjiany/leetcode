package com.wjiany.leetcode.dp;

import org.junit.Test;

public class MinDistance_72 {
    @Test
    public void test(){
        System.out.println(minDistance("horse","ros"));
    }
    /**
     * https://leetcode-cn.com/problems/edit-distance/solution/wu-chong-jie-fa-chao-ji-xiang-xi-by-yuanninesuns/
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
            int len1=word1.length();
            int len2=word2.length();
            int[][] dp=new int[len1+1][len2+1];
            for(int i=0;i<=len2;i++)
                dp[0][i]=i;
            for(int j=0;j<=len1;j++)
                dp[j][0]=j;
            for(int i=1;i<=len1;i++){
                for(int j=1;j<=len2;j++){
                    if(word1.charAt(i-1)==word2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1];
                    else
                        dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
            return dp[len1][len2];
    }
}