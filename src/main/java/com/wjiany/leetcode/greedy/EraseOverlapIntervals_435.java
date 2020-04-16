package com.wjiany.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

class EraseOverlapIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if(length < 2){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(intervals[j][1] <= intervals[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0],dp[i]);
        }
        return length-dp[0];

    }
}