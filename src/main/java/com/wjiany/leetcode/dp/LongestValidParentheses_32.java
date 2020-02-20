package com.wjiany.leetcode.dp;

import org.junit.Test;

import java.util.Stack;

public class LongestValidParentheses_32 {
    @Test
    public void test(){
        //System.out.println(longestValidParentheses(")  (((=-(  --(()())  ()() ) -- )-()=(()))  ("));
       // System.out.println(longestValidParentheses("(((()())()()))()(())"));
        System.out.println(longestValidParentheses_dp("(())"));
    }

    /**
     *https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     *
     * todo 有待学习
     * @param s
     * @return
     */
        public int longestValidParentheses_dp(String s) {
            int maxans = 0;
            int dp[] = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    //官方用stack

    /**
     * stack始终保存最终合格的左括号的前一个，只要是合格的都从stack中拿出出，最大值就是当前的能够成功匹配那次的index-stack的peek
     * @param s
     * @return
     */
    public int longestValidParentheses_stack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i); //防止右边括号过多，stack为空，同时记录当前位置
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    //我的动态规划，超时。。。。。。
    public int longestValidParentheses_overTime(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int max= 0;
        for (int len = 2; len <= length; len = len+2) {
            for (int j = 0; j+len <= length; j++) {
                if((len == 2&&s.substring(j,j+len).equals("()"))||
                        (len > 2&&dp[j+1][j+len-2]&&s.charAt(j)=='('&&s.charAt(j+len-1)==')')){
                    dp[j][j+len-1] = true;
                    max = Math.max(max,len);
                    continue;
                }
                if(len > 2){
                    for (int step = 0; step < len-2; step=step+2) {
                        if(dp[j][j+step+1]&&dp[j+step+2][j+len-1]){
                            dp[j][j+len-1] = true;
                            max = Math.max(max,len);
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }
}