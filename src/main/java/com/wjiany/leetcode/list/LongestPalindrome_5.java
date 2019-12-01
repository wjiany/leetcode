package com.wjiany.leetcode.list;


public class LongestPalindrome_5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 0){
            return "";
        }
        int max = 0;
        String res = null;
        boolean[][] dp = new boolean[length][length];
        for (int len = 1 ; len<= length ; len++){
            for (int i = 0,j=i+len-1 ; j< length ; i++,j++){
                dp[i][j] = (len == 1)||((len==2 || dp[i+1][j-1])&&s.charAt(i)==s.charAt(j));
                if(dp[i][j] && (len>max)){
                    max = len;
                    res = s.substring(i,i+len);
                }
            }
        }
        return res;
    }
    public String longestPalindrome1(String s) {
        int length = s.length();
        if(length == 0){
            return "";
        }
        int max = 0;
        String res= null;
        for(int i = 0 ; i< length ; i++){
            for(int j = i ; j<=length; j++){
                String substring = s.substring(i, j);
                if (isPal(substring)){
                    if(substring.length()>max){
                        res = substring;
                        max = substring.length();
                    }
                }
            }
        }

        return res;
    }
    public boolean isPal(String s){
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length / 2 ;i++ ) {
            if(chars[i] != chars[chars.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
