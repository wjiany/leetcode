package com.wjiany.leetcode.string;


import org.junit.Test;

/**
 * 有点贪心算法，每次从大的开始往下减少
 */
public class IntToRoman_12 {

    @Test
    public void test(){
        System.out.println(intToRoman(3000));
    }
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int numIndex = 0;
        while (numIndex <13){
            while (num >= nums[numIndex]){
                result.append(romans[numIndex]);
                num -= nums[numIndex];
            }
            numIndex++;
        }
        return result.toString();
    }
}