package com.wjiany.leetcode.backtrack;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute_46 {

    @Test
    public void test(){
        permute(new int[]{1,2,3}).stream().forEach(x->{System.out.println("===");x.stream().forEach(System.out::println);});
//        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
//        for (int i = 0; i < permute.size(); i++) {
//            for (int j = 0; j < permute.get(i).size(); j++) {
//                System.out.println(permute.get(i).get(j));
//            }
//        }
    }



    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
//        List<Integer> integers = new ArrayList<>();
//        for(int i = 0 ; i <nums.length;i++){
//            integers.add(nums[i]);
//        }
//        permuteList(integers,new ArrayList<>());
        boolean[] booleans = new boolean[nums.length];
        permute(nums,new ArrayList(),booleans,0);
        return lists;
    }
    //第一次自己做的
    private void permuteList(List<Integer> nums ,List<Integer> list){
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

    //第二次自己做的
    private void permute(int[] nums,List listRes,boolean[] isUsed,int times) {
        if (times == nums.length){
            lists.add(new ArrayList<>(listRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            listRes.add(nums[i]);
            permute(nums,listRes,isUsed,times+1);
            isUsed[i] =false;
            listRes.remove(listRes.size()-1);
        }

    }

    }
