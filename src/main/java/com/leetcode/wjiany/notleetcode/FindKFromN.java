package com.leetcode.wjiany.notleetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 从n 个数字中找出 k个数字的不同组合(组合，不考虑排列顺，相同数字不同排列是一种)
        */
public class FindKFromN {
    List<String> list = new ArrayList<>();

    @Test
    public void testFindKFromN(){
    combine(new char[]{'1','2','3'},3,"",0,3);
    list.stream().forEach(System.out::println);
    }
    private void combine(char[] arr, int k, String res,int low,int high) {
        if (k == 0) {
            list.add(res);
        } else {
            for (int i = low; i < high; i++) {
                combine(arr, k - 1, res+arr[i], i + 1, high);
            }
        }
    }
}
