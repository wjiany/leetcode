package com.leetcode.wjiany.dp;

import org.junit.Test;

public class NumDecodings_91 {
    @Test
    public void test(){
        System.out.println(numDecodingsDp("226"));
    }
    public int numDecodingsRe(String s,int start) {
        if(start == s.length()){
            return 1;
        }
        if(s.charAt(start) == '0'){
            return 0;
        }
        int ans1 = numDecodingsRe(s,start+1);
        int ans2= 0;
        if (start<s.length()-1 && Integer.valueOf(s.substring(start,start+2))<=26){
            ans2 = numDecodingsRe(s,start+2);
        }
        return ans1+ans2;
    }
    public int numDecodingsDp(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length+1];
        dp[length] = 1;
        if(s.charAt(length-1)-'0' == 0){
            dp[length-1] = 0;
        }else {
            dp[length-1] = 1;
        }
        for (int i = length-2 ;i>=0;i--){
            if(s.charAt(i)-'0' == 0){
                dp[i] = 0;
            }else if(Integer.valueOf(s.substring(i,i+2)) <=26){
                dp[i] = dp[i+1]+dp[i+2];
            }else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }
}
