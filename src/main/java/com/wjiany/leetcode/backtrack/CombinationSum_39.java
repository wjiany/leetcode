package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

    @Test
    public void test(){
        combinationSum(new int[]{2,3,5},8)
                .stream().forEach(x->{System.out.println("====");x.stream().forEach(System.out::println);});
    }
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates,0,0,new ArrayList(),target);
        return lists;

    }
    private void combinationSum(int[] nums,int startIndex,int res ,List list,int target){
        if(res == target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(res > target){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(nums[i] > target) return;
            list.add(nums[i]);
            combinationSum(nums,i,res+nums[i],list,target);
            list.remove(list.size()-1);
        }

    }
}