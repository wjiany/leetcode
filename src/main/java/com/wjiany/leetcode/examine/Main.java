package com.wjiany.leetcode.examine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[num];
        Integer index = null;
        int max = 0;
        Integer min = null;
        Integer left = num;
        Integer right = -1;
        for (int i = 0 ;i< num;i++){
            arr[i] = sc.nextInt();
            max +=arr[i];
            if(arr[i]<=0){
                left = Math.min(left,i);
                right = Math.max(right,i);
                if(min == null){
                    min = arr[i];
                    index = i;
                }else if(arr[i]<min){
                    min = arr[i];
                    index = i;
                }
            }
        }
        if(index == null){
            System.out.println(max);
            return;
        }
        if(left == right && left == index){
            System.out.println(max-arr[index]);
            return;
        }
        int tmp1 = max;
        int tmp2 = max;
        int tmp3 = max;
        for (int i = left;i<=index;i++){
            tmp1 -=arr[i];
        }
        for (int i = index;i<=right;i++){
            tmp2 -=arr[i];
        }
        for (int i = left;i<=right;i++){
            tmp3 -=arr[i];
        }
        System.out.println(Math.max(tmp1,Math.max(tmp2,tmp3)));
        return;
    }
}
