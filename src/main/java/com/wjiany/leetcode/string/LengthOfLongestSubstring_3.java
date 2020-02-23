package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 当前位置减去开始位置，发现重复后，开始位置向后移动到重复之后
 * 无论这次发现是否已经存在，当前位置和开始位置的差就是大小，
 */
public class LengthOfLongestSubstring_3 {
    @Test
    public void test(){
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring2(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int ans = 0;
        int tmp = 0;
        for(int i = 0;i<length;i++){
            Character ch = s.charAt(i);
            if(map.get(ch) != null){
                tmp =Math.max(map.get(ch)+1,tmp);
            }
            ans = Math.max(i+1-tmp,ans);
            map.put(ch,i);
        }
        return ans;

    }
}
