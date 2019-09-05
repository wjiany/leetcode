package com.leetcode.wjiany.Array2P;

import java.util.*;

public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0 ;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        int j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
