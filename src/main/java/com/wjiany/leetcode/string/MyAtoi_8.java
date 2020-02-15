package com.wjiany.leetcode.string;

import org.junit.Test;

public class MyAtoi_8 {

    @Test
    public void test(){
        System.out.println(myAtoi("2147483648"));
    }
    public int myAtoi(String str) {
        String trim = str.trim();
        boolean isFushu = trim.startsWith("-");
        boolean isZheng = trim.startsWith("+");
        if (isFushu||isZheng){
            trim = trim.substring(1);
        }
        char[] chars = trim.toCharArray();
        int ans = 0;
        boolean isNum ;
        for (int i = 0; i < chars.length; i++) {
            isNum = chars[i] - '0' >= 0 && chars[i] - '0' <= 9;
            if (isNum){
                if((ans*10 + (chars[i] -'0'))/10!=ans ){
                    return isFushu?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                ans = ans *10 + (chars[i]-'0');
            }else {
                return isFushu?-ans:ans;
            }
        }
        return isFushu?-ans:ans;
    }
}