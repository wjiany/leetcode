package com.wjiany.leetcode.string;


import org.junit.Test;

public class LongestCommonPrefix_14 {
    @Test
    public void test(){
        System.out.println(longestCommonPrefix(new String[]{"dog","dacecar","dar"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0){
            return "";
        }
        if(length == 1){
            return strs[0];
        }
        String str = strs[0];
        String res = "";
        String tmp = "";
        for (int j = str.length() ;j>0 ;j--){
            tmp = str.substring(0,j);
            int time = 0;
            for(int i = 1 ; i< length;i++){
                if(strs[i].startsWith(tmp) ){
                    time++;
                }
                if(time == length-1){
                    res = tmp;
                    return res;
                }
            }
        }
        return res;
    }
}
