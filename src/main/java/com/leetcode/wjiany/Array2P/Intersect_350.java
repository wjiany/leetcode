package com.leetcode.wjiany.Array2P;

import org.junit.Test;

import java.util.*;

public class Intersect_350 {

    @Test
    public void test(){
        System.out.println(intersect(new int[]{1,2,2,1},new int[]{2,2}));
    }
    /**
     * 排序加双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i =0,j=0;
        while (i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] res = new int[list.size()];
        for (int m = 0;m<list.size();m++){
            res[m] = list.get(m);
        }
        return res;
    }

    /**
     * 使用map记录次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect_map(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0 ; i<nums1.length ; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j=0 ;j<nums2.length;j++){
            if(map.containsKey(nums2[j])){
                list.add(nums2[j]);
                Integer integer = map.get(nums2[j]);
                if(integer == 1){
                    map.remove(nums2[j]);
                }else {
                    map.put(nums2[j],integer-1);
                }
            }
        }
        int[] ints = new int[list.size()];
        for (int i =0;i<list.size();i++){
            ints[i] = list.get(i);
        }
        return ints;
    }
}
