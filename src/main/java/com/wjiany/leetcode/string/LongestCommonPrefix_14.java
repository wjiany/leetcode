package com.wjiany.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix_14 {
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
        int max = 0;
        for (int j = str.length() ;j>0 ;j--){
            tmp = str.substring(0,j);
            int time = 0;
            for(int i = 1 ; i< length;i++){
                if(strs[i].startsWith(tmp) ){
                    time++;
                }
                if(time == length-1 && tmp.length() > max){
                    max = tmp.length();
                    res = tmp;
                }
            }
        }
        return res;
    }
}
