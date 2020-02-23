package com.wjiany.leetcode.Array2P;

import java.util.Stack;

class Trap_42 {

    /**
     *双指针
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int left = 0,right = height.length-1;
        int leftMax = 0,rightMax= 0;
        int ans = 0;
        while (left<right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else {
                    ans+=leftMax-height[left];
                }
                left++;
            }else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else {
                    ans+=rightMax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
    /**
     * o     o
     * o o o o
     * o o o o
     */
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int currIndex = 0;currIndex<height.length;currIndex++){
            while (!stack.isEmpty()&&height[currIndex] > height[stack.peek()]){
                Integer midHeight = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int distance = currIndex - stack.peek() -1;
                int boundedHeight = Math.min(height[currIndex], height[stack.peek()]) - height[midHeight];
                ans += distance * boundedHeight;

            }
            stack.push(currIndex);
        }
        return ans;
    }
}