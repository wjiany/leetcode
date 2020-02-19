package com.wjiany.leetcode.math;

import org.junit.Test;

public class Divide_29 {
    @Test
    public void test(){
        System.out.println(divide(-2,3));
    }
    //看的别人的答案
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);  //异或是否为负数
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;   //  一直成倍的加，如果超过了，剩下的差额，再进行成倍的加
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }
    // 可以成功，但是击败数感人。。。。。
    public int divide2(int dividend, int divisor) {
        boolean b = dividend > 0;
        boolean b1 = divisor > 0;
        boolean isZhengshu = (b&&b1)||(!b&&!b1);
        int add = b1?divisor:-divisor;
        if(dividend == Integer.MIN_VALUE ){
            if(divisor == -1) return Integer.MAX_VALUE;
            if(divisor == 1) return dividend;
            if(divisor == Integer.MIN_VALUE) return 1;
         }else if(divisor == Integer.MIN_VALUE){
            return 0;
        }
//        if(add == 1){
//            if(isZhengshu){
//               return dividend>0?dividend:-dividend;
//            }else {
//                return dividend>0?-dividend:dividend;
//            }
//        }
        int sum = b? - dividend: dividend; //全部化为负数运算
        int total =-add;
        int i = 1;
        int beforeI = 1;
        int beforeTotal = -add;
        while (total >= sum){ //先成倍的加，提升速度
            beforeI = i;
            beforeTotal = total;
            total +=total;
            i+=i;
            if(total>=0) break;  //溢出了成为zheng数
        }
        while (beforeTotal >= sum){
            beforeTotal +=-add;
            beforeI +=1;
            if(beforeTotal>=0){ //溢出了成为负数
                return isZhengshu?beforeI-1:-beforeI+1;
            }
        }
        if(i == 1){
            if(-sum>add){
                return isZhengshu?1:-1;
            }else {
                return 0;
            }
        }
        return isZhengshu?beforeI-1:-beforeI+1;
    }
    /**
     * 方法1有3 个问题，2_147_483_647,1_000_000_000输入后，
     * 1 很可能被除数加了自己后，直接溢出成为负数，重新开始加了，陷入循环这是一个错误
     * 2 累加的速度慢，容易超时，是一个被除数一个被除数的加的
     *
     * 3,按照整数加，-2147483648 ，2 ，会有问题，因为 -2147483648 转为正数溢出
     */
    public int divide1(int dividend, int divisor) {
        boolean b = dividend > 0;
        boolean b1 = divisor > 0;
        boolean isZhengshu = (b&&b1)||(!b&&!b1);
        int add = b1?divisor:-divisor;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sum = b?dividend:-dividend;
        if(add == 1){
            return isZhengshu?sum:-sum;
        }
// 累加太多容易超时
        int tmp =add;
        int i = 1;
        while (tmp<=sum){
            tmp +=add;
            i++;
        }
        if(i == 1){
            return sum>add?1:0;
        }
        return isZhengshu?i:-i;
    }

}