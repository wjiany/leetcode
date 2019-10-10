package com.leetcode.wjiany.examine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MainVivo1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {
        int length = str.length();
        Stack<Character> stack1 = new Stack<>();
        //Stack<Character> stack2 = new Stack<>();
        for (int i = 0;i<length;i++){
            if(str.charAt(i) == '('){
                stack1.push('(');
            }else if(str.charAt(i) == ')'){
                stack1.pop();
            }else {
                return stack1.size();
            }
        }
        return -1;
    }
}
