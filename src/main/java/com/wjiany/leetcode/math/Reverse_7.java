package com.wjiany.leetcode.math;

import org.junit.Test;

public class Reverse_7 {

    @Test
    public void test(){
        System.out.println(reverse(-123));
    }

    //方法 2
    public int reverse(int x) {
        int ans = 0;
        while (x!=0){
            // 因为是反转开头的数字是1或者2，如果乘以10没有溢出，加上1或者2也补不溢出，尾数超过8或者9可能溢出
            // -2147483648 到 2147483647
            if((ans*10)/10 != ans){  //如果不等，说明已经溢出，则直接返回0
                return 0;
            }
            ans = ans * 10 + x%10;//  不断的取整数的最后一位
            x /= 10;
        }
        return ans;
    }
    //方法 1
    public int reverse1(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        Integer integer=0;
        if(x<0){
            try {
                integer = -Integer.valueOf(stringBuilder.append(String.valueOf(-x)).reverse().toString());
            }catch (Exception e){
                return 0;
            }
        }else {
            try {
                 integer = Integer.valueOf(stringBuilder.append(String.valueOf(x)).reverse().toString());
            }catch (Exception e){
                return 0;
            }
        }
        return integer;
    }
}