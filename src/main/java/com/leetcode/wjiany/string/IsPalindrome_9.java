package com.leetcode.wjiany.string;

import org.junit.Test;

public class IsPalindrome_9 {
    @Test
    public void test(){
        System.out.println(isPalindrome(-121));
    }
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        String toString = stringBuilder.toString();
        StringBuilder reverse = stringBuilder.reverse();
        return toString.equals(reverse.toString());
    }
}
