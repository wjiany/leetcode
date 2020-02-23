package com.wjiany.leetcode.greedy;

import org.junit.Test;

public class Jump_45 {
    /**
     * 贪心算法
     https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/     * @param nums
     * @return
     */

    @Test
    public void test(){
        System.out.println(jump1(new int[]{5,4,3,2,1,1}));
    }
    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
               // System.out.println(maxPosition);
            }
        }
        return steps;
    }
    public int jump(int[] nums) {
        int position = nums.length-1;
        int step = 0;
        while (position!=0){
            for (int i = 0; i < position; i++) {
                if(nums[i] >= position-i){
                    position = i;
                    step++;
                    break;
                }
            }
        }
    return step;
    }
}