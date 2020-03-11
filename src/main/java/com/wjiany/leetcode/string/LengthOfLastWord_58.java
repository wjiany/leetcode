package com.wjiany.leetcode.string;

import org.junit.Test;

public class LengthOfLastWord_58 {
    @Test
    public void test(){
        System.out.println(lengthOfLastWord("hello world"));
    }
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(s.length()-1) == ' '){
            return lengthOfLastWord(s.substring(0,s.length()-1));
        }
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                return s.length()-1-i;
            }
        }
        return s.length();
    }
}