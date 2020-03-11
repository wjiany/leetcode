package com.wjiany.leetcode.arraylist;

import java.util.ArrayList;
import java.util.List;

class Insert_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]){
                list.add(newInterval);
                newInterval = intervals[i];
            }else if(intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
            }else {
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[0][]);
    }
}