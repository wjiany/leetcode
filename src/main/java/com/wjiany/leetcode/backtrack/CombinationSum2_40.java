package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    @Test
    public void test(){
        combinationSum2(new int[]{10,1,2,7,6,1,5},8)
                .stream().forEach(x->{System.out.println("====");x.stream().forEach(System.out::println);});
    }
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] isUsed = new boolean[candidates.length];
        combinationSum(candidates,0,0,new ArrayList(),target,isUsed);
        return lists;

    }
    private void combinationSum(int[] nums,int startIndex,int res ,List list,int target,boolean[] isUsed){
        if(res == target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(res > target){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(nums[i] > target) return;
            if(isUsed[i]) continue;
            //if(i>0&&nums[i] == nums[i-1]) continue;//错误， 1，1，6，7 //1，1，6，7  无法合成 1，-1-，6
            if(i>startIndex && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            isUsed[i] = true;
            combinationSum(nums,i+1,res+nums[i],list,target,isUsed);
            list.remove(list.size()-1);
            isUsed[i] = false;
        }

    }
}