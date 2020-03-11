package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetPermutation_60 {

    @Test
    public void test(){
        System.out.println(getPermutation_1(3,3));
    }

    String result = "";
    int totalK = 0;
    public String getPermutation(int n, int k) {
        boolean[] isUsed = new boolean[n];
        totalK = k;
        getFun(n,"",isUsed,n);
        return result;
    }
    private void getFun(int n,String res,boolean[] isUsed,int rows){
        if(rows == 0) {
            totalK--;
            if(totalK == 0) {
                result =res;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(isUsed[i-1]) continue;
            isUsed[i-1] = true;
            getFun(n,res+i,isUsed,rows-1);
            if(totalK == 0) return;//剪枝
            isUsed[i-1] = false;
        }
    }
    /**
     * 逆康托展开
     *
     * 康托展开是一个全排列到一个自然数的双射，常用于构建hash表时的空间压缩。
     * 设有n个数（1，2，3，4,…,n），可以有组成不同(n!种)的排列组合，
     * 康托展开表示的就是是当前排列组合在n个不同元素的全排列中的名次。
     *
     * https://blog.csdn.net/update7/article/details/56681789?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
     */
        public String getPermutation_1(int n, int k) {
            int[] digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            List<Integer> digitList = Arrays.stream(digit).boxed().collect(Collectors.toList());
            int[] factor = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
            StringBuilder sb = new StringBuilder();
            k--;
            while (n > 0) {
                int val = k / factor[n - 1];
                sb.append(digitList.get(val + 1));
                digitList.remove(val + 1);
                k = k % factor[n - 1];  //求余数
                n--;
            }
            return sb.toString();
        }
    public String getPermutation_2(int n, int k) {
        /**
         直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
         可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
         算出来, 对于n=4, k=15 找到k=15排列的过程:

         1 + 对2,3,4的全排列 (3!个)
         2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
         3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
         4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

         确定第一位:
         k = 14(从0开始计数)
         index = k / (n-1)! = 2, 说明第15个数的第一位是3
         更新k
         k = k - index*(n-1)! = 2
         确定第二位:
         k = 2
         index = k / (n-2)! = 1, 说明第15个数的第二位是2
         更新k
         k = k - index*(n-2)! = 0
         确定第三位:
         k = 0
         index = k / (n-3)! = 0, 说明第15个数的第三位是1
         更新k
         k = k - index*(n-3)! = 0
         确定第四位:
         k = 0
         index = k / (n-4)! = 0, 说明第15个数的第四位是4
         最终确定n=4时第15个数为3214
         **/

        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for(int i = n-1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index*factorials[i];  //求余数
        }
        return sb.toString();
    }
}