package com.wjiany.leetcode.math;

import org.junit.Test;

public class IsUgly_263 {
    @Test
    public void test(){
        System.out.println(isUgly(2));
    }
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        while (num%2 == 0){
            if(num == 2) return true;
            num = num/2;
        }
        while (num%3 == 0){
            if(num == 3) return true;
            num = num/3;
        }
        while (num%5 == 0){
            if(num == 5) return true;
            num = num/5;
        }
        return num == 0;
    }
}