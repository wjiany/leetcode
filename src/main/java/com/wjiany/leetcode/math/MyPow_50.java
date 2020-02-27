package com.wjiany.leetcode.math;

import org.junit.Test;

public class MyPow_50 {
    @Test
    public void test(){
        System.out.println(myPow(2,-2));
    }

    /**
     * 官方：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/
     *
     * 分析 此方法和 myPow_timeout2对比，此方法是总数不断二分，
     * 而后者是每次成倍到最终值，超过了又从1开始成倍，每次递归都有while循环，浪费时间
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    /**
     * 参考 29题  ，依然超时
     * @param x
     * @param n
     * @return
     */
    public double myPow_timeout2(double x, int n) {
        if( n == 0){
            return 1;
        }
        int loop = n>0?n:-n;
        double ans = x;
        int tmp = 1;
        while ((tmp<<1) < loop){
            ans *=ans;
            tmp +=tmp;
        }
        double sum = ans *  myPow(x, loop - tmp);
        return n>0?sum:1/sum;
    }
    //超时
    public double myPow_timeout(double x, int n) {
        int loop = n>0?n:-n;
        double ans = 1;
        for (int i = 0; i < loop; i++) {
            ans *= x;
        }
     return n>0?ans:1/ans;
    }
}