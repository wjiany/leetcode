package com.wjiany.leetcode.Array2P;

import org.junit.Test;

import java.util.*;

/**
 * 求两个数组中位数
 */
public class FindMedianSortedArrays_4 {

    @Test
    public void testFind(){
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i = 0;i<nums2.length;i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        boolean isOdd = list.size() % 2 == 1;
        if(isOdd){
            return list.get(list.size()/2);
        }else {
            return (list.get(list.size()/2)+list.get(list.size()/2 -1))/2.0;
        }

    }
    //todo 官方和下边的递归方法有待学习
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        boolean flag = (length1+length2)%2==1;
        int mid = (length1+length2)/2+1;
        int tmp = 0;
        int result = 0;
        int m = 0;
        int n = 0;
        for (int i = 0;i<mid;i++){  //mid = 2
            if(flag){
                if(m<length1&&n<length2){
                    if(i == mid-1){
                        result = nums1[m]<nums2[n]?nums1[m]:nums2[n];
                        break;
                    }
                    if(nums1[m]<nums2[n]){
                        m++;
                    }else {
                        n++;
                    }
                }else if(m<length1){
                    if(i == mid-1){
                        result = nums1[m];
                        break;
                    }
                    m++;
                }else if(n<length2){
                    if(i == mid-1){
                        result = nums2[n];
                        break;
                    }
                    n++;
                }
            }else {
                if(m<length1&&n<length2){
                    if(i == mid-2 ){
                        tmp = nums1[m]<nums2[n]?nums1[m]:nums2[n];
                    }else if(i == mid-1){
                        result = nums1[m]<nums2[n]?nums1[m]:nums2[n];
                        break;
                    }
                    if(nums1[m]<nums2[n]){
                        m++;
                    }else {
                        n++;
                    }
                }else if(m<length1){
                    if(i == mid-2 ){
                        tmp = nums1[m];
                    }else if(i == mid-1){
                        result = nums1[m];
                        break;
                    }
                    m++;
                }else if(n<length2){
                    if(i == mid-2 ){
                        tmp = nums2[n];
                    }else if(i == mid-1){
                        result = nums2[n];
                        break;
                    }
                    n++;
                }
            }
        }
        return tmp != 0 ?(result+tmp)/2.0:result;
    }
}
