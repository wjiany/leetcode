package com.leetcode.wjiany.Array2P;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 */
public class ThreeSum_15 {

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0 ; i<length ; i++){
            if(nums[i]>0){
                continue;
            }
            for (int j=i+1 ; j<length; j++){
                if(nums[i]+nums[j]>0){
                    continue;
                }
                if(map.containsKey(-nums[i]-nums[j])){
                    lists.add(Arrays.asList(nums[i],-nums[i]-nums[j],nums[j]));
                    if(map.get(-nums[i]-nums[j]) == 1){
                        map.remove(-nums[i]-nums[j]);
                    }else {
                        map.put(-nums[i]-nums[j],map.get(-nums[i]-nums[j])-1);
                    }
                    if( i == j-2){
                        i = j;
                    }
                    break;
                }
                if(map.containsKey(nums[j])){
                    map.put(nums[j],map.get(nums[j])+1);
                    if(i == j-1){
                        i = j;
                    }
                }else {
                    map.put(nums[j],1);
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum_error(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0 ; i<length ; i++){
            Map<Integer,Integer> map = new HashMap();
            if(nums[i]>0){
                continue;
            }
            for (int j=i+1 ; j<length; j++){
                if(nums[i]+nums[j]>0){
                    continue;
                }
                if(map.containsKey(-nums[i]-nums[j])){
                    lists.add(Arrays.asList(nums[i],-nums[i]-nums[j],nums[j]));
                    if(map.get(-nums[i]-nums[j]) == 1){
                        map.remove(-nums[i]-nums[j]);
                    }else {
                        map.put(-nums[i]-nums[j],map.get(-nums[i]-nums[j])-1);
                    }
                    break;
                }
                if(map.containsKey(nums[j])){
                    map.put(nums[j],map.get(nums[j])+1);
                }else {
                    map.put(nums[j],1);
                }
            }
        }
        return lists;
    }
}
