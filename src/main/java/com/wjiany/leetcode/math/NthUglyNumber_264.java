package com.wjiany.leetcode.math;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NthUglyNumber_264 {

    @Test
    public void test(){
        System.out.println(nthUglyNumber_2(10));
    }

    public int nthUglyNumber(int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        queue.add(1);
        set.add(1);
        while (--n>0){ //会变成 负的
            Integer poll = queue.poll();
            if(set.add(poll*2)) queue.add(poll*2);
            if(set.add(poll*3)) queue.add(poll*3);
            if(set.add(poll*5)) queue.add(poll*5);
        }
        return queue.peek();
    }

    /**
     * 动态规划，维护三个指针，分别表示2，3，5下一次的乘数
     * @param n
     * @return
     */
    public int nthUglyNumber_2(int n) {
         int[] nums = new int[1690];
            nums[0] = 1;
            int ugly, i2 = 0, i3 = 0, i5 = 0;
            for(int i = 1; i < 1690; ++i) {
                int r2 = nums[i2] * 2;
                int r3 = nums[i3] * 3;
                int r5 = nums[i5] * 5;
                ugly = Math.min(Math.min(r2, r3), r5);
                nums[i] = ugly;
                if (ugly == r2) ++i2;
                if (ugly == r3) ++i3;
                if (ugly == r5) ++i5;
            }
            return nums[n-1];
    }
    public int nthUglyNumber_1(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        int[] nums = new int[1690];
        for (int i = 0; i <1690; i++) {
            long poll = queue.poll();
            nums[i] = (int) poll;
            if(set.add(poll*2)) queue.add(poll*2);
            if(set.add(poll*3)) queue.add(poll*3);
            if(set.add(poll*5)) queue.add(poll*5);
        }
        return nums[n-1];
    }
}