package com.wjiany.leetcode.Array2P;

import org.junit.Test;


/**
 * 求最大装水
 */
public class MaxArea_11 {
    @Test
    public void test(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int max= 0;
        int l = 0;
        int h = length-1;
        while (l<h){
            max = Math.max(max,Math.min(height[l],height[h])*(h-l));
            if(height[l]<height[h]){
                l++;
            }else {
                h--;
            }
        }
        return max;
    }

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea_(int[] height) {
        int length = height.length;
        int max= 0;
        for(int i = 0 ; i< length ;i++){
            for (int j =i;j<length;j++){
                max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }
}
