package com.wjiany.leetcode.math;

import org.junit.Test;

public class MySqrt_69 {

    @Test
    public void test(){
        System.out.println(mySqrt(4));
    }

    /**
     * https://leetcode-cn.com/problems/sqrtx/solution/niu-dun-die-dai-fa-by-loafer/
     * https://blog.csdn.net/ccnt_2012/article/details/81837154
     * 牛顿迭代法 对任意x0 执行f(x) = f(x0) + f'(x0)*(x-x0) 求x 来逼近f(x) = 0的根
     * 这里相当于执行下x^2=a,求a（也就是入参）的开根号值 即执行f(x) = x^2 -a = 0的值
     * f(x0) + f'(x0)*(x-x0) = 0  即f(x0) + 2x * (x-x0) =0 求x，这里x0可以使用a
     *
     * 令f(x)=0求出 x1 即是比x0 更接近f(x)=0的值  =>   x1= x0- f(x0)/f'(x0)
     * 下一次迭代，使用x1作为新的x0，作为入参
     *
     * 注意：需要记录最初的值s，相当于上边的x^2=a的a，参数x会变，但是a不变，
     * 第一次可以使用a作为参数出入输入
     */
    int s;
    public int mySqrt_3(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }
    /**
     *
     * @param x 上一次逼近值
     * @return 下一次逼近值
     */
    private double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }
    /**
     * 参考二分查找
     * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode/
     * @param x
     * @return
     */
    public int mySqrt_2(int x) {
        if (x < 2) return x;
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }
    /**
     * 袖珍计算器  通过指数和对数运算公式求出 根号
     * 这种方法有点作弊，那不如直接使用 int left = (int)Math.pow(x, 0.5); 进行开根号
     * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode/
     * @param x
     * @return
     */
    public int mySqrt_1(int x) {
        if (x < 2) return x;

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        //int left = (int)Math.pow(x, 0.5);   不如直接这样
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
    /**
     * 暴力解法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if(i*i > x) return i-1;
            if(i*i == x) return i;
        }
        return 0;
    }
}