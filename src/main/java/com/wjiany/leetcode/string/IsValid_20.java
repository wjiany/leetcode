package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.Stack;

public class IsValid_20 {
    @Test
    public void test(){
        boolean valid = isValid("()");
    }
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<chars.length;i++){
            if(chars[i] == '{'||chars[i] == '['||chars[i] == '('){
                stack.push(chars[i]);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                if((chars[i]=='}'&&!stack.pop().equals('{'))||(chars[i]==']'&&!stack.pop().equals('[') )
                ||(chars[i]==')'&&!stack.pop().equals('('))){
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
