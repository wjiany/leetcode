package com.wjiany.leetcode.string;

import org.junit.Test;

public class StrStr_28 {

    @Test
    public void test(){
        System.out.println(strStr("qwert","er"));
    }

    /**
     *   todo 可以考虑KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int lenA = haystack.length();
        int lenB = needle.length();
        if(lenA < lenB){
            return -1;
        }
        for (int i = 0; i <= lenA - lenB; i++) {
            if(haystack.substring(i,i+lenB).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}