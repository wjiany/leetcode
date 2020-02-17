package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.Stack;

public class IsValid_20 {
    @Test
    public void test(){
        System.out.println(isValid("()[]{}"));
    }
    public boolean isValid(String s) {
        if(s.startsWith(")") || s.startsWith("]") || s.startsWith("}")||s.length()%2==1){
            return false;
        }
        if(s.equals(""))return true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;
        while ( i < s.length()){
            char charAt = s.charAt(i);
            i++;
            if(charAt=='('||charAt=='['||charAt=='{'){
                stack.push(charAt);
                continue;
            }
            if(stack.isEmpty()){return false;}
            Character pop = stack.pop();
            if((charAt == ')' && pop != '(') ||
                    (charAt == ']'&& pop != '[') ||
                    (charAt == '}'&& pop != '{')){
                return false;
            }
        }
        return stack.isEmpty() && i == s.length();
    }
    public boolean isValid1(String s) {
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
