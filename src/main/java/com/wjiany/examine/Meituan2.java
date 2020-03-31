package com.wjiany.examine;


import java.util.Scanner;

public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[num];
        int max = 0;
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        if(nums.length <= 1){
            System.out.println(nums.length);
            return;
        }
        for (int i = 0; i < num; i++) {
            int tmp = nums[i];
            nums[i] = '.';
            max = Math.max(max,find(nums));
            nums[i] = tmp;
        }
        System.out.println(max);
    }
    public static int find(int[] nums) {
        int ans = 1;
        int count = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] == '.'){
                nums[i-1] = Integer.MAX_VALUE;
                continue;
            }
            if(nums[i] == '.'){
                nums[i] =nums[i-1];
                continue;
            }
            if(nums[i] > nums[i-1]) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

}
