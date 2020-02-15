package com.wjiany.leetcode.string;

import org.junit.Test;


public class IsPalindrome_9 {
    @Test
    public void test(){
        System.out.println(isPalindrome(121));
    }
    //2  数学方法
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int ans = 0;
        int tmp = x;
        while (x!=0){
            ans = ans*10 +x%10;
            x/=10;
        }
        return tmp == ans;
    }
    //1
    public boolean isPalindrome1(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        String toString = stringBuilder.toString();
        StringBuilder reverse = stringBuilder.reverse();
        return toString.equals(reverse.toString());
    }
}
