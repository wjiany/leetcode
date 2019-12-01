package com.wjiany.leetcode.traverse;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/24-game/solution/24dian-wen-ti-ji-bian-xing-biao-da-shi-qiu-jie-de-/
 */
public class JudgePoint24_679 {

    @Test
    public void test24(){
        System.out.println(judgePoint24(new int[]{1,9,1,2}));
    }
    //TODO 缺少考虑 双括号情形

    boolean res = false;
    public boolean judgePoint24(int[] nums) {
        double[] doubles = new double[nums.length];
        for (int i = 0;i<nums.length;i++) {
            doubles[i] = (double) nums[i];
        }
        boolean[] booleans = new boolean[4];
        for (int i = 0;i<4;i++){
            booleans[i] = true;
            judge24(doubles,booleans,doubles[i],3,nums[i]+"");
            booleans[i] = false;
        }
        return res;
    }
    public void judge24(double[] nums,boolean[] isUsed,double result ,int times,String str){
        if(times == 0 && (Math.abs(result - 24) < 1e-6)){
            res = true;
            System.out.println(str+"=========");
            return ;
        }
        if(times == 0){
            System.out.println(str);
            return;
        }
        for (int i = 0;i<4;i++){
            if(isUsed[i]){
                continue;
            }else {
                isUsed[i] = true;
                judge24(nums, isUsed, result + nums[i], times-1,str+"+"+nums[i]);
                judge24(nums, isUsed, result - nums[i], times-1,str+"-"+nums[i]);
                judge24(nums, isUsed, nums[i] - result, times-1,nums[i]+"-"+str);
                judge24(nums, isUsed, result * nums[i], times-1,str+"*"+nums[i]);
                if(result != 0){
                    judge24(nums, isUsed, nums[i] / result, times-1,nums[i]+"/"+str);
                }
                judge24(nums, isUsed, result / nums[i], times-1,str+"/"+nums[i]);
                isUsed[i] = false;
            }
        }
    }

}
