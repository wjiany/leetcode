package com.wjiany.leetcode.string;


public class CountAndSay_38 {
    //
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2;i<=n;i++){
            StringBuilder res = new StringBuilder();
            char c = s.charAt(0);
            int count = 1;
            for (int j = 1;j<s.length();j++){
                if(c == s.charAt(j)){
                    count++;
                }else {
                    res.append(count).append(c);
                    c = s.charAt(j);
                    count = 1;
                }
            }
            res.append(count).append(c);
            s = res.toString();
        }
        return s;
    }
}