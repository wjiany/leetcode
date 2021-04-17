package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 *默认已经是匹配完好的括号了
 */
public class MaxDepth_1614 {
    @Test
    public void test(){
        System.out.println(maxDepth("8*((1*(5+6))*(8/6))"));
    }
    public int maxDepth(String s) {
        int r = 0, n = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(') n++;
            if(s.charAt(i) == ')') n--;
            if(r < n) r = n;
        }
        return r;
    }
}