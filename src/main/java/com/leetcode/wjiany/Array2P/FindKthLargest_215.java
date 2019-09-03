package com.leetcode.wjiany.Array2P;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue(k);
        int length = nums.length;
        for (int i = 0;i<length;i++){
            if(queue.size()<k){
                queue.add(nums[i]);
            }else if(queue.size() == k && nums[i] > queue.peek()){
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.remove();
    }
}
