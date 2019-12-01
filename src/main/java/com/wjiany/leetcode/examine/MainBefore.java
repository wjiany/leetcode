package com.wjiany.leetcode.examine;
import java.util.Scanner;

public class MainBefore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[num];
        for (int i = 0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0 ;i<num;i++){
            int min = arr[i];
            int add = 0;
            for (int j = i ;j< num;j++){
                min = Math.min(min,arr[j]);
                add+=arr[j];
                max = Math.max(max,min*add);
            }
        }
        System.out.println(max);
}
}