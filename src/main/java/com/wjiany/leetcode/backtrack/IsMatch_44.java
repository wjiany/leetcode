package com.wjiany.leetcode.backtrack;

import org.junit.Test;

public class IsMatch_44 {
    @Test
    public void tst(){
        System.out.println(isMatch_dp("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
        //System.out.println(isMatch("adceb","*a*b"));
    }

        // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配 (true 的话表示匹配)
        // 状态转移方程：
        //      1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
        //      2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]    其中：
        //      dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
        //      dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
        // 初始化：
        //      1. dp[0][0] 表示什么都没有，其值为 true
        //      2. 第一行 dp[0][j]，换句话说，s 为空，与 p 匹配，所以只要 p 开始为 * 才为 true
        //      3. 第一列 dp[i][0]，当然全部为 false
        public boolean isMatch_dp(String s, String p) {
            int m = s.length();
            int n = p.length();

            // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
            boolean[][] dp = new boolean[m + 1][n + 1];

            // 初始化
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
            }

            // 状态转移
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }

            // 返回结果
            return dp[m][n];

        }
    /**
     * time out   此方法超时！！！！！！！！！！！
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        if(p.equals("*")) return true;
        //if(s.isEmpty()) return p.isEmpty();

        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0));

        if(p.charAt(0) == '*'){
            boolean b = !s.isEmpty() ? isMatch(s.substring(1), p):false;
            return b || isMatch(s,p.substring(1));
        }else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }

    }
}