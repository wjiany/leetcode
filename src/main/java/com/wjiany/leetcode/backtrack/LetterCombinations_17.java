package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 回溯法，将结果递归传递，用于获取最终结果
 */
public class LetterCombinations_17 {
    @Test
    public void test(){
        System.out.println(letterCombinations1("23"));
    }
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
    // 第二次做
    public List<String> letterCombinations1(String digits) {
        if (digits == null ||digits.equals("")){
            return list;
        }
        fun(digits,"");
        return list;
    }
    private void fun(String digits,String res){
        if(digits.equals("")){
            list.add(res);
            return;
        }
        String str = map.get(digits.substring(0,1));
        for (int j = 0; j < str.length(); j++) {
            fun(digits.substring(1),res + str.substring(j,j+1));
        }

    }
    //第一次做
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return list;
        }
        backTracking("",digits);
        return list;
    }
    private void backTracking(String combine,String digits){
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
