package com.wjiany.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return list;
        }
        backTracking("",digits);
        return list;
    }
    public void backTracking(String combine,String digits){
        if(digits.length() == 0){
            list.add(combine);
        }else {
            String num = digits.substring(0, 1);
            String s = map.get(num);
            for(int i = 0;i<s.length();i++){
                backTracking(combine+s.substring(i,i+1),digits.substring(1));
            }
        }

    }
}
