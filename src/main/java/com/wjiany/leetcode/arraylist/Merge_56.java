package com.wjiany.leetcode.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    @Test
    public void test(){
        int[][] merge = merge(new int[][]{{2,3},{5,5},{2,2}});
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(merge[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 先排序 按照 每个 0号元素
     * 1，没有交集，直接加入
     * 2，有交集， 右边更新为最大值 （因为左边已经比较过了，小的在前边了）
     * https://leetcode-cn.com/problems/merge-intervals/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-40/
     * @param intervals
     * @return
     */

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        // 排序：根据区间开始值升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] lastInterval = null;
        for (int[] interval : intervals) {
            if(lastInterval == null || lastInterval[1] < interval[0]){
                lastInterval = interval;
                list.add(lastInterval);
            }else if(lastInterval[1] < interval[1]){
                lastInterval[1] = interval[1];
            }
        }
        return list.toArray(new int[0][]);
    }
}