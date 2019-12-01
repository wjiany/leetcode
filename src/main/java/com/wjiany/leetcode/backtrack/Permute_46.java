package com.wjiany.leetcode.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute_46 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        for(int i = 0 ; i <nums.length;i++){
            integers.add(nums[i]);
        }
        permuteList(integers,new ArrayList<>());
        return lists;
    }
    public void permuteList(List<Integer> nums ,List<Integer> list){
        int length = nums.size();
        int num = 0;
        for(int i = 0;i<length;i++){
            if(nums.get(i) == null){
                num++;
                continue;
            }
            List<Integer> numsCopy = new ArrayList<>();
            numsCopy.addAll(nums);
            numsCopy.set(i,null);
            List<Integer> listTemp = new ArrayList<>();
            listTemp.addAll(list);
            listTemp.add(nums.get(i));
            permuteList(numsCopy,listTemp);
        }
        if(num == length){
            lists.add(list);
        }
    }
}
