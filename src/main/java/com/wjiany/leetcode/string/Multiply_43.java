package com.wjiany.leetcode.string;

import org.junit.Test;

/**
 * 数组保存各个乘法位置的数字，避免了数字过大的问题
 */
public class Multiply_43 {
    @Test
    public void test(){
        System.out.println(multiply_error("23","3"));
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
       num1 = new StringBuilder(num1).reverse().toString();
       num2 = new StringBuilder(num2).reverse().toString();

        int s1 = num1.length(), s2 = num2.length();

        int[] ans = new int[s1+s2];
        for(int i = 0; i < s1; i++) {
            for(int j = 0; j < s2; j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for(int i = 0; i < s1 + s2; i++) {
            if(ans[i] > 9) {
                int t = ans[i];
                ans[i] = t % 10;
                ans[i + 1] += (t / 10);
            }
        }

        int pos = (ans[s1 + s2 - 1] == 0 ? s1 + s2 - 2 : s1 + s2 - 1);

        StringBuilder res = new StringBuilder();
        for(; pos >= 0; pos--) {
            res.append(ans[pos]);
        }
        return res.toString();
    }
    /**
     * 数字太大结果溢出有问题
     * @param num1
     * @param num2
     * @return
     */
    public String multiply_error(String num1, String num2) {
        int res = 0;
        for (int i = num1.length()-1; i >=0 ; i--) {

             int mul = num1.charAt(i)-'0';
             int resTmp = 0;
             int add = 0;
            for (int j = num2.length()-1; j >=0 ; j--) {
               int tmp = mul * (num2.charAt(j)-'0');
                resTmp += ((tmp % 10 + add)*pw(10,num2.length()-j-1));
                add = tmp / 10;
            }
            if(add!=0){
                resTmp += add*pw(10,num2.length());
            }
            res += resTmp*pw(10,num1.length()-i-1);
        }
    return String.valueOf(res);
    }
    private int pw(int num,int n){
        if(n == 0){
            return 1;
        }
        int tmp = num;
        while (n>1){
            tmp*=num;
            n--;
        }
        return tmp;
    }
}