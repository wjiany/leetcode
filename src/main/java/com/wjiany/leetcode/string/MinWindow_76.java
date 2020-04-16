package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinWindow_76 {

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String s, String t) {

        Map<Character,Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i),tCount.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> sCount = new HashMap<>();
        int left = 0,right=0;
        int minLen = s.length()+1;
        int resLeft = 0,resRight = -1;
        for (; right < s.length(); right++) {
            sCount.put(s.charAt(right),sCount.getOrDefault(s.charAt(right),0)+1);
            while (windowContains(sCount,tCount)){
                if(right-left < minLen){
                    minLen = right-left;
                    resLeft = left;
                    resRight = right;
                }
                sCount.put(s.charAt(left),sCount.get(s.charAt(left))-1);
                left++;
            }
        }
        return s.substring(resLeft,resRight+1);
    }

    /**
     * s中是否包含t中的字母
     * @param sCount
     * @param tCount
     * @return
     */
    private boolean windowContains(Map<Character,Integer> sCount,Map<Character,Integer> tCount){
        Set<Map.Entry<Character, Integer>> entries = tCount.entrySet();
        for (Map.Entry<Character, Integer> tset: entries) {
            if(tset.getValue().compareTo(sCount.getOrDefault(tset.getKey(),0)) > 0){
                return false;
            }
        }
        return true;
    }
}