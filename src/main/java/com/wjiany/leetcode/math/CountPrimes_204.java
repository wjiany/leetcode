package com.wjiany.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求小于 N的质数个数
 */
public class CountPrimes_204 {
    int max= 0;

    /**
     * 筛法，统计质数个数，判断为质数后，去除所有它的倍数，然后最后遍历
     * @param n
     * @return
     */
    public int countPrimes(int n){
        boolean[] booleans = new boolean[n];//是否质数
        Arrays.fill(booleans,true);
        for (int i = 2 ;i<n;i++){
            if(booleans[i]){
                for (int j=2;i*j<n;j++){
                    booleans[j*i] = false;
                }
            }
        }
        for (int i = 2 ;i<n;i++){
            if(booleans[i]){
                max++;
            }
        }
        return max;
    }

    /**
     * 统计质数个数
     * @param n
     * @return
     */
    public int countPrimes_slow(int n) {
        for (int i = 1;i<n;i++){
            if(isPrime(i)){
                max++;
            }
        }
        return max;
    }
    public boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        if(num == 2){
            return true;
        }
        int m = 2;
        int sqrt = (int)Math.sqrt(num)+1;
        while (m < sqrt){
            if(num%m ==0){
                return false;
            }
            m++;
        }
        return true;
    }
}
