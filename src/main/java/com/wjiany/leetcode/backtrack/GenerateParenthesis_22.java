package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 *：
 *例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

/**
 * 提示：
 * 1,数量上，左右括号分别都为n个
 * 2,左括号的数量需要大于等于右括号的数量
 */
public class GenerateParenthesis_22 {
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       // backTracking("",0,0,n);
        fun("",n,n);
        return list;
    }

    public void  fun(String res,int left, int right){
        if(left==0&&right == 0){
            list.add(res);
            return;
        }
        if(left > 0){
            fun(res+"(",left-1,right);
        }
        if (left < right){
            fun(res+")",left,right-1);
        }
    }
    public void backTracking(String res,int l,int r,int total){
       if(r == total){
           list.add(res);
           return;
       }
        if(l < total){
            backTracking(res+"(",l+1,r,total);
        }
        if(r < total && r < l){
            backTracking(res+")",l,r+1,total);
        }
    }
}
