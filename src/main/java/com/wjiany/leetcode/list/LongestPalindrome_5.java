package com.wjiany.leetcode.list;


import org.junit.Test;




public class LongestPalindrome_5 {
    @Test
    public void test(){
        //System.out.println(longestPalindrome("asdffdsac"));
        System.out.println(longestPalindrome2("a"));
    }
    public String longestPalindrome2(String s) {
        if(s.length() == 0){
            return "";
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int ans = 0;
        String res = null;
        for (int len=1;len <= length;len++){
            for (int start = 0,end = len+start-1;end<length;start++,end++){
                dp[start][end] =(len==1)||(((len==2)||dp[start+1][end-1])&&(s.charAt(start)==s.charAt(end)));
                if(dp[start][end]&&len>ans){
                    ans = len;
                    res = s.substring(start,end+1);
                }
            }

        }
        return res;
    }

    //动归
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
    //暴力
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
