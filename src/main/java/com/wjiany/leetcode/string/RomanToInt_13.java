package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt_13 {
    @Test
    public void test(){
        System.out.println(romanToInt("III"));
    }
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }
    public int romanToInt1(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int romanIndex = 0;
        int ans = 0;
        while (romanIndex < 13){
            while (s.startsWith(romans[romanIndex])){
                ans +=nums[romanIndex];
                s = s.substring(romans[romanIndex].length());
            }
            romanIndex++;
        }
        return ans;
    }
}