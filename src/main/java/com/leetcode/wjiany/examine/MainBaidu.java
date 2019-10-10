package com.leetcode.wjiany.examine;

import java.util.Scanner;

public class MainBaidu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();
        long max = n>m?n:m;
        long min = n>m?m:n;
        int b = 0;
        while (b<=min){
            if(max*(min-b)<=k){
                System.out.println(b);
                break;
            }
            b++;
        }
    }
}
