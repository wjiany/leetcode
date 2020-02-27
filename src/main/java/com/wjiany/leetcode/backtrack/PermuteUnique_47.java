package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique_47 {

    @Test
    public void test(){
        permuteUnique(new int[]{1,1,2}).stream().forEach(x->{System.out.println("==");x.stream().forEach(System.out::println);});
    }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] booleans = new boolean[nums.length];
        permute(nums,new ArrayList(),booleans,0);
        return lists;
    }
    private void permute(int[] nums,List listRes,boolean[] isUsed,int times) {
        if (times == nums.length){
            lists.add(new ArrayList<>(listRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !isUsed[i - 1]) continue;
            isUsed[i] = true;
            listRes.add(nums[i]);
            permute(nums,listRes,isUsed,times+1);
            isUsed[i] =false;
            listRes.remove(listRes.size()-1);
        }

    }
}